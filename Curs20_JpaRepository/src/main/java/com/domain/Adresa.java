package com.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "adresa")
public class Adresa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "strada")
    private String strada;

    @Column(name = "numar")
    private String numar;

    @Column(name = "localitate")
    private String localitate;

    @ManyToMany(mappedBy = "cursuriAlese", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Student> studentiInrolati;

    @OneToMany(mappedBy = "materie")
    @JsonIgnore
    private Set<StudentiToMaterie> inscrieri;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @JsonBackReference
    private Profesor profesor;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresa adresa = (Adresa) o;
        return id.equals(adresa.id) && strada.equals(adresa.strada) && numar.equals(adresa.numar) && localitate.equals(adresa.localitate) && profesor.equals(adresa.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, strada, numar, localitate);
    }
}
