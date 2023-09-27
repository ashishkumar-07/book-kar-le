package com.bookkarle.movies.api.contract;

import com.bookkarle.movies.entity.Show;
import com.bookkarle.movies.model.ShowOnboardingRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(

        name = "Show Management API",
        description = "Following APIs are used to manage/onboard the shows running in different screens"
)
public interface ShowApi {

    @Operation(summary = "This API onboards a show of a movie along-with available seats")
    public Show onbaordShow(ShowOnboardingRequest showOnboardingRequest);



    @Operation(summary = "Cancel a show of a movie")
    void cancelShow(@PathVariable String externalShowId);
}
