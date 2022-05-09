package com.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "CNP")
    private String cnp;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "studenti_to_materii",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_materie"))
    @JsonManagedReference
    private Set<Materie> cursuriAlese;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<StudentiToMaterie> inscrieri;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresa")
    private Adresa adresa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && nume.equals(student.nume) && prenume.equals(student.prenume) && cnp.equals(student.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, prenume, cnp);
    }
}
