package com.Backend.Library_Management.DTO;

import com.Backend.Library_Management.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDto {
    private String name;

    private String email;

    private Department department;

    private String cardNo;
}
