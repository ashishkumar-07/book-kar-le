package com.bookkarle.search.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class Show {
    private Long theatreId;
    private String theatreName;
    List<ShowInfo> showsInfo;
}
