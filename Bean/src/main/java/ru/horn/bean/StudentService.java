package ru.horn.bean;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public List<Student> addStudent(Student student){
        studentRepository.save(student);
        return studentRepository.findAll();
    }

    public List<Student> removeStudent(Long id){
        studentRepository.deleteById(id);
        return studentRepository.findAll();
    }

    public List<Student> removeAllStudents(){
        studentRepository.deleteAll();
        return studentRepository.findAll();
    }
}
