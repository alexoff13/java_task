package org.alexoff.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="author", schema = "films")
public class Author {
    @Id
    @GeneratedValue
    private Integer Id;
    @Column(name = "name")
    private String Name;
    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Film> Films;
    @Override
    public String toString() {
        return "Author{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", films=" + Films +
                '}';
    }

    public Author() {
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

    public List<Film> getFilms() {
        return Films;
    }

    public void setFilms(List<Film> films) {
        Films = films;
    }
}
