package com.exemple.school.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolDto {
    private String name;
    private String email;
    List<StudentDto> students;
}
