package com.bookkarle.booking.service;

import com.bookkarle.BusinessValidationException;
import com.bookkarle.NotFoundException;
import com.bookkarle.OperationFailedException;
import com.bookkarle.booking.dao.BookingOrderDao;
import com.bookkarle.booking.dao.ShowSeatBookingDao;
import com.bookkarle.booking.entity.BookingOrder;
import com.bookkarle.booking.entity.BookingOrderStatus;
import com.bookkarle.booking.entity.SeatBookingStatus;
import com.bookkarle.booking.entity.ShowSeatBooking;
import com.bookkarle.booking.model.*;
import com.bookkarle.booking.partner.PartnerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingFacade {

    private final ShowSeatBookingDao showSeatBookingDao;
    private final PaymentServiceInterface paymentServiceInterface;
    private final BookingOrderDao bookingOrderDao;
    private final PartnerFacade partnerFacade;


    @Transactional(readOnly = true)
    public List<ShowSeatBooking> fetchSeatMap(Long showId) {
        List<ShowSeatBooking> showSeatLayout = showSeatBookingDao.findByShowId(showId);
        if(showSeatLayout.size()<=0){
            throw new NotFoundException("Show was not found");
        }
        return showSeatLayout;
    }

    @Transactional(rollbackFor = Exception.class)
    public void blockSeat(HoldRequest holdRequest) {
        int affectedRows = showSeatBookingDao.updateBySeatBookingStatusAndShowSeatIdIn(SeatBookingStatus.HOLD.toString(), SeatBookingStatus.AVAILABLE.toString(), holdRequest.getShowSeatIds());
        if(holdRequest.getShowSeatIds().size() > affectedRows){
            throw new BusinessValidationException("Failed in blocking the all seats");
        }
        partnerFacade.blockSeatInPartnerSystem(holdRequest);
    }

    @Transactional(rollbackFor = Exception.class)
    public CreateBookingOrderResponse createOrder(CreateBookingOrder order) {

        List<ShowSeatBooking> seatsToBook = showSeatBookingDao.findBySeatBookingStatusAndShowSeatIdIn(SeatBookingStatus.HOLD, order.getSeatIds());
        if (seatsToBook.size() < order.getSeatIds().size()) {
            throw new BusinessValidationException("Few of the selected seats are not available now. Please try with new selection!");
        }
        try {
            updateSeats(seatsToBook);
            BookingOrder bookingOrderEntity = toBookingEntity(order);
            partnerFacade.updateBookingInProgressPartnerSystem(seatsToBook, order);
            getFeeDetails(bookingOrderEntity);
            BookingOrder saved = bookingOrderDao.save(bookingOrderEntity);
            return createBookingOrderResponse(saved);
        } catch (Exception e) {
            e.printStackTrace();
            throw new OperationFailedException("Order could not be created. Please try again");
        }
    }

    private static CreateBookingOrderResponse createBookingOrderResponse(BookingOrder saved) {
        return CreateBookingOrderResponse.builder()
                .bookingOrderId(saved.getBookingId())
                .baseAmountOfFee(saved.getBaseAmountOfFee())
                .convenienceFee(saved.getConvenienceFee())
                .taxOnFee(saved.getTaxOnFee())
                .build();
    }

    private String fetchExternalTheaterPartner(Long showId) {
        //Fetch the details
        return "INOX_1";
    }

    private void getFeeDetails(BookingOrder bo) {
        //Call API to get the fee and tax breakup
        bo.setBaseAmountOfFee(BigDecimal.valueOf(30));
        bo.setTaxOnFee(BigDecimal.valueOf(30*28/100));
        bo.setConvenienceFee(bo.getBaseAmountOfFee().add(bo.getTaxOnFee()));
    }


    private void createOrderInPaymentGatewayAndSetPaymentDetails(BookingOrder order) {
        PaymentOrderResponse paymentOrderResponse = paymentServiceInterface.createPaymentOrder(new PaymentOrder(order.getAmountAfterOffer(), order.getPaymentGatewayId()));
        setPaymentDetails(order, paymentOrderResponse);
    }

    private void updateSeats(List<ShowSeatBooking> seatsToBook) {
        seatsToBook.stream().forEach(seat ->{
            seat.setBookingStatus(SeatBookingStatus.IN_PROGRESS);
        });
        showSeatBookingDao.saveAll(seatsToBook);
    }

    private void setPaymentDetails(BookingOrder bookingOrderEntity, PaymentOrderResponse paymentOrderResponse) {
        bookingOrderEntity.setPaymentGatewayId(paymentOrderResponse.paymentGatewayId());
        bookingOrderEntity.setPaymentGatewayOrderId(paymentOrderResponse.paymentGatewayOrderId());
        bookingOrderEntity.setPaymentGatewayTransactionId(paymentOrderResponse.paymentGatewayTransactionId());
        bookingOrderEntity.setPaymentGatewayOrderStatus(paymentOrderResponse.paymentGatewayOrderStatus());
    }

    private BookingOrder toBookingEntity(CreateBookingOrder order) {
        return BookingOrder.builder()
                .userId(order.getUserId())
                .seatIds(order.getSeatIds())
                .ticketQuantity(order.getSeatIds().size())
                .totalTicketPrice(order.getTotalTicketPrice())
                .offerAmount(order.getOfferAmount())
                .amountAfterOffer(order.getAmountAfterOffer())
                .offerId(order.getOfferId())
                .orderStatus(BookingOrderStatus.PENDING)
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    public ConfirmOrderResponse confirmOrder(ConfirmOrderRequest order) {
        BookingOrder bookingOrder = bookingOrderDao.findById(order.getBookingOrderId()).orElseThrow(() -> new BusinessValidationException("Booking ID was not found."));
        bookingOrder.setPaymentGatewayId(order.getPaymentGatewayId());
        createOrderInPaymentGatewayAndSetPaymentDetails(bookingOrder);
        bookingOrderDao.save(bookingOrder);
        return createConfirmOrderResponse(bookingOrder);
    }

    private ConfirmOrderResponse createConfirmOrderResponse(BookingOrder order) {
        return ConfirmOrderResponse.builder()
                .bookingOrderId(order.getBookingId())
                .paymentGatewayOrderId(order.getPaymentGatewayOrderId())
                .paymentGatewayOrderStatus(order.getPaymentGatewayOrderStatus())
                .build();
    }

    private void generateTickets(BookingOrder order) {
    }

    @Transactional(rollbackFor = Exception.class)
    public CompleteOrderResponse completeOrder(CompleteOrderRequest request) {
        BookingOrder order = bookingOrderDao.findById(request.getBookingOrderId()).orElseThrow(() -> new BusinessValidationException("Booking ID was not found."));
        order.setPaymentGatewayTransactionId(request.getPaymentGatewayTransactionId());
        order.setOrderStatus(BookingOrderStatus.COMPLETED);
        partnerFacade.confirmOrder(order);
        showSeatBookingDao.updateBySeatBookingStatusAndShowSeatIdIn(SeatBookingStatus.BOOKED.toString(),SeatBookingStatus.IN_PROGRESS.toString(),order.getSeatIds());
        generateTickets(order);
        bookingOrderDao.save(order);
        return createCompleteOrderResponse(order);

    }

    private CompleteOrderResponse createCompleteOrderResponse(BookingOrder order) {
        return CompleteOrderResponse.builder()
                .paymentStatus("COMPLETED")
                .ticketImagePath(order.getTicketImagePath())
                .ticketQrCodePath(order.getTicketQrCodePath())
                .build();
    }
}
