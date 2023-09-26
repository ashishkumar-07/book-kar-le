package com.bookkarle.booking.model;

import lombok.Data;

import java.util.List;

@Data
public class HoldRequest {
    List<Long> showSeatIds;
}
