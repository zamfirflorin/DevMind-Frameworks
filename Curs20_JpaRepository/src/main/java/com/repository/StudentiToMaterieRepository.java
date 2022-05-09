package com.repository;

import com.domain.StudentiToMaterie;
import com.dto.StudentiToMaterieDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentiToMaterieRepository extends JpaRepository<StudentiToMaterie, Long> {



}
