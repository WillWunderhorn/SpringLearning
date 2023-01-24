package ru.horn.postgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> findAll(){
        return studentRepo.findAll();
    }

    public List<Student> addNew(Student student) {
        Optional<Student> studentOptional = studentRepo
                .findStudentsByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("EMAIL IS TAKEN!");
        }
        studentRepo.save(student);
        return studentRepo.findAll();
    }

    public void removeStudent(Long id){
        studentRepo.findById(id);

        boolean exists = studentRepo.existsById(id);

        if(!exists) {
            throw new IllegalStateException("NOT FOUND!");
        }
        studentRepo.deleteById(id);
    }

    public void clearStudentsList(){
        studentRepo.deleteAll();
    }

    public void updateStudent(Long id, String name, String email, LocalDate date) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("STUDENT WITH ID: " + id + " NOT FOUND!"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepo.findStudentsByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("EMAIL IS TAKEN!");
            }
            student.setEmail(email);
        }

        if(date != null && !Objects.equals(student.getDate(), date)){
            student.setDate(date);
        }
        studentRepo.save(student);
    }
}
