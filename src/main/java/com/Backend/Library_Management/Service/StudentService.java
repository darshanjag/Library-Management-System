package com.Backend.Library_Management.Service;

import com.Backend.Library_Management.DTO.StudentRequestDto;
import com.Backend.Library_Management.DTO.StudentUpdateMobile;
import com.Backend.Library_Management.Enum.CardStatus;
import com.Backend.Library_Management.Repository.StudentRepository;
import com.Backend.Library_Management.modal.LibraryCard;
import com.Backend.Library_Management.modal.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(StudentRequestDto studentRequestDto){
            Student student = new Student();
            student.setAge(studentRequestDto.getAge());
            student.setName(studentRequestDto.getName());
            student.setDepartment(studentRequestDto.getDepartment());
            student.setEmail(studentRequestDto.getEmail());

            LibraryCard card = new LibraryCard();
            card.setStatus(CardStatus.ACTIVATED);
            card.setStudent(student);
            student.setCard(card);
            studentRepository.save(student);

    }
    public Student findByEmail(String email){
        return (studentRepository.findByEmail(email));
    }
    public StudentUpdateMobile updateEmail(StudentUpdateMobile dto){

            Student student = studentRepository.findById(dto.getId()).get();

            student.setEmail(dto.getEmail());
            Student updated =studentRepository.save(student);
            StudentUpdateMobile newDto = new StudentUpdateMobile();
            newDto.setEmail(updated.getEmail());
            newDto.setId(updated.getId());

            return newDto;
    }
}
