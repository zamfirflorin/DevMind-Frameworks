package repository;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByNume(String nume);
    Optional<Student> findByNumeAndPrenume(String nume, String prenume);
    List<Optional<Student>> findByNumeAndLocalitate(String nume, String localitate);

}
