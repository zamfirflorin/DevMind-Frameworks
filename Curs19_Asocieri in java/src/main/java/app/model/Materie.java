package app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "materii")
@Data
public class Materie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    public Profesor profesor;

}
