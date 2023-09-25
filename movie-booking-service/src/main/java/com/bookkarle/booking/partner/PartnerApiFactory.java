package com.bookkarle.booking.partner;

import com.bookkarle.booking.partner.impl.InoxApi;
import com.bookkarle.booking.partner.impl.PVRApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PartnerApiFactory {

    @Bean
    public PVRApi getPVRApi(){
        return new PVRApi();
    }

    @Bean
    public InoxApi getInoxApi(){
        return new InoxApi();
    }
}
