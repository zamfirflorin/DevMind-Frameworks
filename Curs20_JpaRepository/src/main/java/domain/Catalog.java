package domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "catalog")
public class Catalog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
