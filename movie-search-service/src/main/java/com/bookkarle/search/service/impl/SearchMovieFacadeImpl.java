package com.bookkarle.search.service.impl;


import com.bookkarle.search.cache.CacheApi;
import com.bookkarle.search.cache.InMemoryApiImpl;
import com.bookkarle.search.dao.MovieDao;
import com.bookkarle.search.entity.ActiveShow;
import com.bookkarle.search.model.*;
import com.bookkarle.search.service.CalculateTierBookingStatus;
import com.bookkarle.search.service.SearchMovieFacade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SearchMovieFacadeImpl implements SearchMovieFacade {
    private final CacheApi<String,List<ActiveShow>> movieCache;
    private final CacheApi<String,List<ActiveShow>> theatreCache;
    private final MovieDao movieDao;
    private final CalculateTierBookingStatus calculateTierBookingStatus;

    public SearchMovieFacadeImpl(@Qualifier("movieCache") CacheApi<String, List<ActiveShow>> movieCache,
                                 @Qualifier("theatreCache") CacheApi<String, List<ActiveShow>> theatreCache,
                                 MovieDao movieDao,
                                 CalculateTierBookingStatus calculateTierBookingStatus) {
        this.movieCache = movieCache;
        this.theatreCache = theatreCache;
        this.movieDao = movieDao;
        this.calculateTierBookingStatus = calculateTierBookingStatus;
    }

    @Override
    public MovieAvailableShowResponse fetchShowsByLanguageMovieAndCity(Long movieId, String language, Long cityId){
        List<ActiveShow> activeShows = getActiveShowsByMovie(movieId, language, cityId);

        Map<LocalDate, List<ActiveShow>> movieShowGroupedByDate =  activeShows.stream()
                .collect(Collectors.groupingBy(ActiveShow::getShowDate));

        List<MovieShow> movieShowsResponse = movieShowGroupedByDate.entrySet().stream()
                .map(entry -> buildMovieShowsResponse(entry.getKey(), entry.getValue()))
                .toList();

        MovieAvailableShowResponse response = new MovieAvailableShowResponse();
        response.setMovieShows(movieShowsResponse);
        return response;
    }

    private List<ActiveShow> getActiveShowsByMovie(Long movieId, String language, Long cityId) {
        List<ActiveShow> activeShows = movieCache.get(movieId + ":" + language + ":" + cityId);
        if( activeShows== null || activeShows.isEmpty()){
            activeShows = movieDao.fetchNextFiveDaysShowsByLanguageMovieAndCity(movieId, language, cityId);
            movieCache.put(movieId + ":" + language + ":" + cityId,activeShows);
        }
        return activeShows;
    }

    private MovieShow buildMovieShowsResponse(LocalDate date, List<ActiveShow> activeShows) {

        List<Show> shows = activeShows.stream()
                .map(this::buildShowObject)
                .toList();

        Map<Long,List<ShowInfo>> theatreShowInfoMap = buildTheatreWiseShowInfoMap(activeShows);
        shows.stream().forEach(show -> {
            show.setShowsInfo(theatreShowInfoMap.get(show.getTheatreId()));
        });

        MovieShow movieShow = new MovieShow();
        movieShow.setShows(shows);
        movieShow.setDate(date);
        return movieShow;
    }

    private Show buildShowObject(ActiveShow activeShow) {
        return Show.builder()
                .theatreId(activeShow.getTheaterId())
                .theatreName(activeShow.getTheaterName())
                .build();
        
    }

    private Map<Long, List<ShowInfo>> buildTheatreWiseShowInfoMap(List<ActiveShow> activeShows) {
        return activeShows.stream().collect(
                Collectors.groupingBy(ActiveShow::getTheaterId,
                        Collectors.mapping(activeShow -> {
                            return ShowInfo.builder()
                                    .showId(activeShow.getShowId())
                                    .showTime(activeShow.getShowId())
                                    .auditoriumName(activeShow.getAuditoriumName())
                                    .auditoriumId(activeShow.getAuditoriumId())
                                    .showTierDetails(calculateTierBookingStatus.buildShowTierDetail(activeShow))
                                    .build();
                        },Collectors.toList())));

    }


    @Override
    public ActiveMovieAndTheatreList getMovieAndTheatreList(Long cityId) {
        return ActiveMovieAndTheatreList.builder()
                .movies(movieDao.getAllActiveMoviesNameBytCity(cityId))
                .theatres(movieDao.getAllActiveTheatreName(cityId))
                .build();
    }

    private List<ActiveShow> getActiveShowsByTheatre(Long cityId, Long theatreId) {
        List<ActiveShow> activeShows = movieCache.get(theatreId + ":" + cityId );
        if( activeShows== null || activeShows.isEmpty()){
            activeShows = movieDao.fetchNextFiveDaysShowsByTheatreIdAndCity(theatreId, cityId);
            movieCache.put(theatreId + ":" + cityId + cityId,activeShows);
        }
        return activeShows;
    }

    @Override
    public TheatreAvailableMovieShows fetchShowsByTheatreAndCity(Long cityId, Long theatreId){

        List<ActiveShow> activeShowsByTheatre = getActiveShowsByTheatre(cityId, theatreId);

        Map<LocalDate, List<ActiveShow>> theatreShowGroupedByDate =  activeShowsByTheatre.stream()
                .collect(Collectors.groupingBy(ActiveShow::getShowDate));

        List<TheatreShow> theatreShowsResponse = theatreShowGroupedByDate.entrySet().stream()
                .map(entry -> buildTheatreShowsResponse(entry.getKey(), entry.getValue()))
                .toList();

        return new TheatreAvailableMovieShows(theatreShowsResponse);

    }

    private TheatreShow buildTheatreShowsResponse(LocalDate date, List<ActiveShow> activeShows) {

        //TODO
        return new TheatreShow();


    }
}
