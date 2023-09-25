package com.bookkarle.offers.strategy;

import com.bookkarle.offers.strategy.impl.QuantityBasedEligibility;
import com.bookkarle.offers.strategy.impl.TimeBasedEligibility;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferEligibilityStrategyFactory {
    @Bean
    @Qualifier("timeBasedEligibility")
    public TimeBasedEligibility createTimeBasedEligibility(){
        return new TimeBasedEligibility();
    }

    @Bean
    @Qualifier("quantityBasedEligibility")
    public QuantityBasedEligibility createQuantityBasedEligibility(){
        return new QuantityBasedEligibility();
    }
}
