package org.alexoff.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "film", schema = "films")
public class Film {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer Id;
    @Column(name = "name")
    private String Name;

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



    @Override
    public String toString() {
        return "Film{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
