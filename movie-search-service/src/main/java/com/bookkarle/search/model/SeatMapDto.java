package com.bookkarle.search.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SeatMapDto {
    private Long seatId;
    private Long auditoriumId;
    private String rowNumber;
    private String seatNumber;
    private Tier tier;
}
