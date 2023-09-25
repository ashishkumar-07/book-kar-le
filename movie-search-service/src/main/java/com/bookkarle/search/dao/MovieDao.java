package com.bookkarle.search.dao;

import com.bookkarle.search.entity.ActiveShow;
import com.bookkarle.search.model.MovieSummary;
import com.bookkarle.search.model.TheatreSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieDao extends JpaRepository<ActiveShow,Long> {

    static String FETCH_FIVE_DAYS_SHOWS_BY_MOVIE_ID=""" 
        select *
        from active_show 
        where 
             movie_id = :movieId
         and show_date between current_date and (CURRENT_DATE + interval '5 day')  
         and show_time > NOW()
         and showLanguage = :language
         and city_id =:cityId               
    """;

    static String FETCH_FIVE_DAYS_SHOWS_BY_THEATRE_ID=""" 
        select *
        from active_show 
        where 
             theatre_id = :theatreId
         and show_date between current_date and (CURRENT_DATE + interval '5 day')  
         and show_time > NOW()
         and showLanguage = :language
         and city_id =:cityId               
    """;

    static String FETCH_FIVE_DAYS_BY_CITY=""" 
        select *
        from active_show 
        where 
             show_date between current_date and (CURRENT_DATE + interval '5 day')  
         and show_time > NOW()
         and showLanguage = :language
         and city_id =:cityId               
    """;

    static String FETCH_ALL_ACTIVE_MOVIE_NAME_BY_CITY= """
            select distinct movie_id as movieId, movie_name as movieName from active_show
            where city_id=:cityId
            """;

    static String FETCH_ALL_ACTIVE_THEATRE_NAME_BY_CITY= """
            select distinct theatre_id as theatreId, theatre_name as theatreName from active_show
            where city_id=:cityId
            """;

    @Query(value = FETCH_FIVE_DAYS_SHOWS_BY_MOVIE_ID,nativeQuery = true)
    public List<ActiveShow> fetchNextFiveDaysShowsByLanguageMovieAndCity(Long movieId, String language, Long cityId);

    @Query(value = FETCH_FIVE_DAYS_SHOWS_BY_THEATRE_ID,nativeQuery = true)
    public List<ActiveShow> fetchNextFiveDaysShowsByTheatreIdAndCity(Long theatreId, Long cityId);


    @Query(value = FETCH_FIVE_DAYS_BY_CITY,nativeQuery = true)
    public List<ActiveShow>  getAllActiveForNextFiveDayByCity(Long cityId);

    @Query(value=FETCH_ALL_ACTIVE_MOVIE_NAME_BY_CITY, nativeQuery = true)
    public List<MovieSummary> getAllActiveMoviesNameBytCity(Long cityId);

    @Query(value=FETCH_ALL_ACTIVE_THEATRE_NAME_BY_CITY, nativeQuery = true)
    public List<TheatreSummary> getAllActiveTheatreName(Long cityId);
}
