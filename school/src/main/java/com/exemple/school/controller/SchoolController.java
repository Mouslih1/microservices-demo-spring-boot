package com.exemple.school.controller;

import com.exemple.school.dto.FullSchoolDto;
import com.exemple.school.entity.School;
import com.exemple.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<School>> all()
    {
        return ResponseEntity.ok(schoolService.getAllSchool());
    }

    @PostMapping
    public ResponseEntity<School> save(@RequestBody School school)
    {
        return new ResponseEntity<>(schoolService.saveSchool(school), HttpStatus.CREATED);
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolDto> findAllSchoolWithStudents(@PathVariable("school-id") Long schoolId)
    {
        return new ResponseEntity<>(schoolService.findSchoolsWithStudents(schoolId), HttpStatus.OK);
    }

}
