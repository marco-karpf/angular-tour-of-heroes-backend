package ch.swiss.km.angulartourofheroesbackend.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
public class Hero {
    @Column
    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Hero(){}

    public Hero(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}


