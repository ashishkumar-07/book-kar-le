package com.bookkarle.offers.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class Offer {
    @Id
    private Long offerId;
    private Long cityId;
    private Long theatreId;
    private String offerName;
    private OfferCategory offerCategory;
    private String offerDescription;

    @Enumerated(EnumType.STRING)
    private OfferType offerType;
    private Integer offerValue;

    private ZonedDateTime offerEffectiveDateTime;
    private ZonedDateTime offerExpirationDateTime;

    private LocalTime applicableAfterTime;
    private LocalTime applicableBeforeTime;
    private Integer minQuantity;

    private String handlerClass;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Offer offer = (Offer) object;

        return offerId.equals(offer.offerId);
    }

    @Override
    public int hashCode() {
        return offerId.hashCode();
    }
}
