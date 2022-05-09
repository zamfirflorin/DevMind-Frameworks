package com.repository;

import com.domain.Materie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterieRepository extends JpaRepository<Materie, Integer> {

    Optional<Materie> findById(Integer id);

}
