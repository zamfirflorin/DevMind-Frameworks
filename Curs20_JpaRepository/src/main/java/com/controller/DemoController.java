package com.controller;

import com.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
    private final StudentRepository studentRepository;

    @Autowired
    public DemoController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(value = "/student/all")
    public @ResponseBody Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/student")
    public @ResponseBody Optional<Student> getStudentByNumeAndPrenume(@RequestParam(name = "nume") String nume, @RequestParam(name = "prenume", required = false) String prenume) {
        if (prenume == null) {
            return studentRepository.findByNume(nume);
        }
        return studentRepository.findByNumeAndPrenume(nume, prenume);
    }

    @GetMapping( "/student/localitate")
    public @ResponseBody
    List<Optional<Student>> getStudentByNumeAndLocalitate(@RequestParam(name = "nume") String nume, @RequestParam(name = "localitate") String localitate) {
        return studentRepository.findByNumeAndLocalitate(nume, localitate);
    }
}