package com.bookkarle.search.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ShowInfo {
    private Long showId;
    private Long showTime;
    private Long auditoriumId;
    private String auditoriumName;
    List<ShowTierDetail> showTierDetails;
}
