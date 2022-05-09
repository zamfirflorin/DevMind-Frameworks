package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "profesori")
public class Profesor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nume")
    private String nume;

    @OneToMany(mappedBy = "profesor")
    @JsonManagedReference
    private Set<Materie> materiiPredate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return id.equals(profesor.id) && nume.equals(profesor.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume);
    }
}
