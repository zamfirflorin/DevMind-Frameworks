package app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STUDENTI")
@Data
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @OneToOne
    @JoinColumn(name = "id_adresa")
    private Adresa adresa;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    @JoinTable(
//            name = "studenti_to_materii",
//            joinColumns = @JoinColumn(name = "id_student"),
//            inverseJoinColumns = @JoinColumn(name = "id_materie"))
//    public Set<Materie> cursuriAlese;



}
