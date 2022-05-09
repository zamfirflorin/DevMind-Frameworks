package com.repository;

import com.domain.Materie;
import com.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    Optional<Profesor> findById(Long id);

    @Query("select c from Materie c where c.profesor.id = ?1")
    Optional<Materie> findMateriiByProfesorId(Long id);

}
