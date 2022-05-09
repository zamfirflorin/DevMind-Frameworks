package com.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "studenti_to_materii")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentiToMaterie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_materie")
    @JsonBackReference
    private Materie materie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentiToMaterie that = (StudentiToMaterie) o;
        return id.equals(that.id) && student.equals(that.student) && materie.equals(that.materie);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}