package com.repository;

import com.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByNume(String nume);
    Optional<Student> findById(Integer id);
    Optional<Student> findByNumeAndPrenume(String nume, String prenume);
    List<Optional<Student>> findByNumeAndAdresa(String nume, String localitate);

    @Query("SELECT s FROM Student s WHERE s.nume = ?1")
    List<Student> findByNumeUsingQuery(String nume);



    @Query(value = "SELECT * FROM student " +
            "JOIN adresa ON student.id_adresa = adresa.id " +
            "WHERE " +
            "student.nume like ?1 " +
            "AND adresa.localitate like ?2",
            nativeQuery = true)
    List<Optional<Student>> findByNumeAndLocalitate(String nume, String localitate);

    Student save(Student student);



}
