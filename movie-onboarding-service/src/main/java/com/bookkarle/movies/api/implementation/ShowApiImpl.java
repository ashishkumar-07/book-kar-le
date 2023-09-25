package com.bookkarle.movies.api.implementation;

import com.bookkarle.movies.api.contract.ShowApi;
import com.bookkarle.movies.entity.Show;
import com.bookkarle.movies.model.ShowOnboardingRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shows")
public class ShowApiImpl implements ShowApi {

    @PostMapping()
    @Override
    public Show onbaordShow(ShowOnboardingRequest showOnboardingRequest) {
        //TODO
        return null;
    }

    @DeleteMapping("/{externalShowId}")
    @Override
    public void cancelShow(@PathVariable String externalShowId) {
        //TODO
    }
}
