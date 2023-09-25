package com.bookkarle.movies.model;

import jakarta.validation.constraints.NotNull;

public record PartnerOnboardingRequest(@NotNull String name, String phoneNumber) {
}
