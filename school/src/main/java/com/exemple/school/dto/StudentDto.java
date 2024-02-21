package com.exemple.school.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    private String firstname;
    private String lastname;
    private String email;
}
