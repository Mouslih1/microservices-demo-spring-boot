package com.exemple.student.service;

import com.exemple.student.entity.Student;
import com.exemple.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentsBySchool(Integer schoolId)
    {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
