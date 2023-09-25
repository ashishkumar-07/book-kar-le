package com.bookkarle.movies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;


public record CityRequest (

    String cityName,

    String state,

    String country
){}
