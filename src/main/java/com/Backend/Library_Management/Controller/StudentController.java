package com.Backend.Library_Management.Controller;

import com.Backend.Library_Management.DTO.StudentRequestDto;
import com.Backend.Library_Management.DTO.StudentUpdateMobile;
import com.Backend.Library_Management.Service.StudentService;
import com.Backend.Library_Management.modal.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto student){
        studentService.addStudent(student);
        return "Student Added.";
    }
    @GetMapping(value = "/find-by-email",produces = "application/json")
    @ResponseBody
    public Student findByEmail(@RequestParam("email") String email){
      Student student = studentService.findByEmail(email);
       return student;
    }
    @PutMapping("/update_mob")
    public StudentUpdateMobile updateMob(@RequestBody StudentUpdateMobile studentUpdateMobUpdateDto){
       return studentService.updateEmail(studentUpdateMobUpdateDto);


    }
}
