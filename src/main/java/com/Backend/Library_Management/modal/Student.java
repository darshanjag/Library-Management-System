package com.Backend.Library_Management.modal;

import com.Backend.Library_Management.Enum.CardStatus;
import com.Backend.Library_Management.Enum.Department;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;
    @Enumerated(EnumType.STRING)
    Department department;

    private String email;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    LibraryCard card;

}
