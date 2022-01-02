package org.alexoff.utils;

import org.alexoff.models.Author;
import org.alexoff.models.Film;
import org.alexoff.models.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParsedFilms {

    private List<Film> films;
    private List<Genre> genres;
    private List<Author> authors;

    public ParsedFilms(List<String> films, Set<String> genres, Set<String> authors) {
        this.films = new ArrayList<Film>();
        this.genres = new ArrayList<Genre>();
        this.authors = new ArrayList<Author>();

        for (String film:films){
            Film new_film = new Film();
            new_film.setName(film);
            this.films.add(new_film);
        }
        for (String genre:genres){
            Genre new_genre = new Genre();
            new_genre.setName(genre);
            this.genres.add(new_genre);
        }
        for (String author:authors){
            Author new_author = new Author();
            new_author.setName(author);
            this.authors.add(new_author);
        }
    }

    public List<Film> getFilms() {
        return films;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Author> getAuthors() {
        return authors;
    }
    // getters and setters
}
