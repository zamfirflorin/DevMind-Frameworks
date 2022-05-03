package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "profesori")
public class Profesor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @OneToMany(mappedBy = "profesor")
    @JsonIgnore
    private Set<Materie> materiiPredate;
}
