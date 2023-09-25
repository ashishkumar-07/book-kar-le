package com.bookkarle.offers.model;

import com.bookkarle.offers.entity.OfferCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OffersDto {
    private Long offerId;
    private Long cityId;
    private Long theatreId;
    private String offerName;
    private OfferCategory offerCategory;
    private String offerDescription;


}
