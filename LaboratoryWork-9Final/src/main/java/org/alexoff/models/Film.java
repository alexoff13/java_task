package org.alexoff.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "film", schema = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "year")
    private Date year;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "rating")
    private Integer rating;

    public Film() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
