package com.bookkarle.search.model;


import lombok.Data;

import java.util.List;

@Data
public class MovieWiseShow {
    private Long movieId;
    private String movieName;
    private String language;
    List<ShowInfo> showsInfo;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        MovieWiseShow that = (MovieWiseShow) object;

        if (!movieId.equals(that.movieId)) return false;
        return language.equals(that.language);
    }

    @Override
    public int hashCode() {
        int result = movieId.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }
}
