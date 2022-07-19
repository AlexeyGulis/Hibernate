package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_production")
    private int year;

    @ManyToOne
    @JoinColumn(name = "director_id",referencedColumnName = "director_id")
    private Director owner;

    public Movie() {
    }

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Director getOwner() {
        return owner;
    }

    public void setOwner(Director owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", owner=" + owner +
                '}';
    }
}
