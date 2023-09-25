package com.bookkarle.movies.api.implementation;

import com.bookkarle.movies.api.contract.TheatreApi;
import com.bookkarle.movies.entity.Theatre;
import com.bookkarle.movies.model.TheatreOnboardingRequest;
import com.bookkarle.movies.model.TheatreResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreApiImpl implements TheatreApi {

    @PostMapping
    @Override
    public Theatre onboardTheatre(TheatreOnboardingRequest theatreOnboardingRequest) {
        return null;
    }
}
