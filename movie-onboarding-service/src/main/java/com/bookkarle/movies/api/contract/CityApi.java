package com.bookkarle.movies.api.contract;

import com.bookkarle.movies.entity.City;
import com.bookkarle.movies.model.CityRequest;
import com.bookkarle.movies.model.CityResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(

        name = "CITY Management API",
        description = "Following APIs are used to manage/onboard the cities"
)
public interface CityApi {

    @Operation(summary = "API is for onboarding a city")
    public City onbaordCity(CityRequest city);

    @Operation(summary = "API lists all the cities of a country")
    public List<CityResponse> getAllCityByCountry (String country);
}
