package com.bookkarle.search.entity;

import com.bookkarle.search.model.Tier;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
public class ActiveShowBookedSeat {
    @Id
    private Long showSeatBookId;
    private Long seatId;
    private long showId;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ActiveShowBookedSeat that = (ActiveShowBookedSeat) object;

        return Objects.equals(showSeatBookId, that.showSeatBookId);
    }

    @Override
    public int hashCode() {
        return showSeatBookId != null ? showSeatBookId.hashCode() : this.getClass().hashCode();
    }
}
