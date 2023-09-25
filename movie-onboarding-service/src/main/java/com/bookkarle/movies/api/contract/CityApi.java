package com.bookkarle.movies.api.contract;

import com.bookkarle.movies.entity.City;
import com.bookkarle.movies.model.CityRequest;
import com.bookkarle.movies.model.CityResponse;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface CityApi {

    @Operation(summary = "API is for onboarding a city")
    public City onbaordCity(CityRequest city);

    @Operation(summary = "API lists all the cities of a country")
    public List<CityResponse> getAllCityByCountry (String country);
}
