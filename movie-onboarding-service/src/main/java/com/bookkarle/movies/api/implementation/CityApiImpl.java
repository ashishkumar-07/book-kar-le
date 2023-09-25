package com.bookkarle.movies.api.implementation;

import com.bookkarle.movies.api.contract.CityApi;
import com.bookkarle.movies.entity.City;
import com.bookkarle.movies.model.CityRequest;
import com.bookkarle.movies.model.CityResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/city")
public class CityApiImpl implements CityApi {
    @Override
    public City onbaordCity(CityRequest city) {
        return null;
    }

    @Override
    public List<CityResponse> getAllCityByCountry(String country) {
        return null;
    }
}
