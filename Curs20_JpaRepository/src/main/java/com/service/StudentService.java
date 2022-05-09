package com.service;

import com.domain.Adresa;
import com.domain.Materie;
import com.domain.Student;
import com.domain.StudentiToMaterie;
import com.dto.AdresaDto;
import com.dto.StudentDto;
import com.dto.StudentiToMaterieDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repository.AdresaRepository;
import com.repository.MaterieRepository;
import com.repository.StudentRepository;
import com.repository.StudentiToMaterieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentiToMaterieRepository studentiToMaterieRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MaterieRepository materieRepository;

    @Autowired
    private AdresaRepository adresaRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Transactional
    public StudentiToMaterie assignStudentToMaterie(final Integer studentId, final Integer materieId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("student not found"));
        Materie materie = materieRepository.findById(materieId).orElseThrow(() -> new RuntimeException("materie not found"));
        var studentToMaterie = StudentiToMaterie.builder().student(student).materie(materie).build();
        return studentiToMaterieRepository.save(studentToMaterie);
    }

    @Transactional
    public StudentDto createStudent(StudentDto studentDto) {
        var adresa = studentDto.getAdresa();
        var student = Student.builder()
                .nume(studentDto.getNume())
                .prenume(studentDto.getPrenume())
                .cnp(studentDto.getCnp())
                .adresa(studentDto.getAdresa())
                .build();
        adresaRepository.save(adresa);
        var persistedStudent= studentRepository.save(student);
        return modelMapper.map(persistedStudent, StudentDto.class);
    }
    @Transactional
    public StudentDto updateStudentAdress(Integer studentId, AdresaDto adresaDto) {
        var student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("student Not found"));
        var adresaStudent = modelMapper.map(adresaDto, Adresa.class);
        adresaRepository.save(adresaStudent);
        student.setAdresa(adresaStudent);
        var persistedStudent  = studentRepository.save(student);
        return modelMapper.map(persistedStudent, StudentDto.class);
    }

    @Transactional
    public StudentDto deleteStudent(Integer studentId) {
        var student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("student not found"));
        studentRepository.delete(student);
        return modelMapper.map(student, StudentDto.class);
    }
}
