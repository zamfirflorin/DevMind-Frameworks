package com.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "materii")
@Getter
@Setter
public class Materie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @JsonBackReference
    public Profesor profesor;

//    @ManyToMany(mappedBy = "cursuriAlese")
//    @JsonManagedReference
//    public Set<Student> studentiInrolati;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materie materie = (Materie) o;
        return id.equals(materie.id) && nume.equals(materie.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, profesor);
    }
}
