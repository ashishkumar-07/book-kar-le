package com.bookkarle.offers.service;


import com.bookkarle.offers.model.OfferEligibilityRequest;
import com.bookkarle.offers.model.OfferEligibilityResponse;
import com.bookkarle.offers.model.OffersDto;
import com.bookkarle.offers.dao.OfferDao;
import com.bookkarle.offers.entity.Offer;
import com.bookkarle.offers.strategy.OfferEligibilityStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferDao offerDao;
    private final ApplicationContext applicationContext;
    public List<OffersDto> listActiveOffers(Long cityId, Long theatreId) {

        List<Offer> offerList = offerDao.findByCityIdAndTheatreId(cityId,theatreId);
        return offerList.stream().map(this::toOfferDto).toList();
    }

    public OffersDto toOfferDto(Offer offer){
       return OffersDto.builder()
                .offerId(offer.getOfferId())
                .offerCategory(offer.getOfferCategory())
                .offerDescription(offer.getOfferDescription())
                .offerName(offer.getOfferName())
                .cityId(offer.getCityId())
                .theatreId(offer.getTheatreId())
                .build();
    }

    public OfferEligibilityResponse checkOfferEligibility(OfferEligibilityRequest offerEligibility) {
        Offer offer = offerDao.findById(offerEligibility.getOfferId()).get();
        OfferEligibilityStrategy eligibilityStrategy = (OfferEligibilityStrategy)applicationContext.getBean(offer.getHandlerClass());
        return eligibilityStrategy.calculate(offerEligibility,offer);
    }
}
