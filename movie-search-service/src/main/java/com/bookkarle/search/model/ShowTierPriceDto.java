package com.bookkarle.search.model;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShowTierPriceDto {
    Tier tierName;
    BigDecimal tierPrice;
}
