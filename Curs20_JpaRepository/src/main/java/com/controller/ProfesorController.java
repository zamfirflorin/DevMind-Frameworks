package com.controller;

import com.domain.Materie;
import com.domain.Profesor;
import com.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/demo/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Profesor>> getProfesorById(@PathVariable Long id) {
        return ResponseEntity.ok(profesorRepository.findById(id));
    }
    @GetMapping("/materii/{id}")
    public ResponseEntity<Optional<Materie>> getAllMateriiByProfesorId(@PathVariable Long id) {
        return ResponseEntity.ok(profesorRepository.findMateriiByProfesorId(id));
    }

}
