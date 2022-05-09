package com.controller;

import com.domain.Student;
import com.domain.StudentiToMaterie;
import com.dto.AdresaDto;
import com.dto.StudentDto;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/student/enroll")
    public ResponseEntity<StudentiToMaterie> enroll(@RequestParam(name = "studentId") Integer studentId,
                                                    @RequestParam(name = "materieId") Integer materieId) {
        return ResponseEntity.ok(studentService.assignStudentToMaterie(studentId, materieId));
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.createStudent(studentDto));
    }

    @PutMapping("/student/{studentId}/adresa")
    public ResponseEntity<StudentDto> updateStudentAdress(@PathVariable Integer studentId,
                                                         @RequestBody AdresaDto adresaDto) {
        return ResponseEntity.ok(studentService.updateStudentAdress(studentId, adresaDto));
    }

    @DeleteMapping("/student/delete/{studentId}")
    public ResponseEntity<StudentDto> deleteStudentById(@PathVariable Integer studentId) {
        return ResponseEntity.ok(studentService.deleteStudent(studentId));
    }

}
