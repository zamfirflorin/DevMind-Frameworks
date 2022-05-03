package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "adresa")
public class Adresa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @ManyToMany(mappedBy = "cursuriAlese", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Student> studentiInrolati;

    @OneToMany(mappedBy = "materie")
    @JsonIgnore
    private Set<StudentiToMaterie> inscrieri;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materie materie = (Materie) o;
        return id.equals(materie.getId()) && nume.equals(materie.getNume());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume);
    }
}
