package com.bookkarle.movies.api.implementation;

import com.bookkarle.movies.api.contract.TheatrePartnerApi;
import com.bookkarle.movies.entity.TheatrePartner;
import com.bookkarle.movies.model.PartnerOnboardingRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/partners")
public class TheatrePartnerApiImpl implements TheatrePartnerApi {

    @PostMapping
    @Override
    public TheatrePartner onboardPartner(PartnerOnboardingRequest partnerOnboardingRequest) {
        return null;
    }

}
