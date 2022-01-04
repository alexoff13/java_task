package org.alexoff.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre", schema = "films")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany
    @JoinColumn(name = "genre_id")
    private List<Film> Films;

    public Genre() {
        this.Films = new ArrayList<Film>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public List<Film> getFilms() {
        return Films;
    }

    public void setFilms(List<Film> films) {
        Films = films;
    }

    public void addFilm(Film film) {
        this.Films.add(film);
    }
}
