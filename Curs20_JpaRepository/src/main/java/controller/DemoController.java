package controller;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/demo")
public class DemoController {
    private final StudentRepository studentRepository;

    @Autowired
    public DemoController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(path = "/student/all")
    public @ResponseBody Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/student")
    public @ResponseBody Optional<Student> getStudentByNumeAndPrenume(@RequestParam(name = "nume") String nume, @RequestParam(name = "prenume", required = false) String prenume) {
        if (prenume == null) {
            return studentRepository.findByNume(nume);
        }
        return studentRepository.findByNumeAndPrenume(nume, prenume);
    }

    @GetMapping(path = "/student/localitate")
    public @ResponseBody
    List<Optional<Student>> getStudentByNumeAndLocalitate(@RequestParam(name = "nume") String nume, @RequestParam(name = "localitate") String localitate) {
        return studentRepository.findByNumeAndLocalitate(nume, localitate);
    }
}