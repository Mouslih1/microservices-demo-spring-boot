package com.exemple.school.service;

import com.exemple.school.client.StudentClient;
import com.exemple.school.dto.FullSchoolDto;
import com.exemple.school.entity.School;
import com.exemple.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public School saveSchool(School school)
    {
        return schoolRepository.save(school);
    }

    public List<School> getAllSchool()
    {
        return schoolRepository.findAll();
    }

    public FullSchoolDto findSchoolsWithStudents(Long schoolId)
    {
        var school = schoolRepository.findById(schoolId).orElse(
                School.builder()
                        .name("NOT FOUND")
                        .email("NOT FOUND")
                        .build()
        );

        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolDto.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
