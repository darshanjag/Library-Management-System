package com.Backend.Library_Management.Controller;

import com.Backend.Library_Management.Service.AutrhorService;
import com.Backend.Library_Management.modal.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthController {
    @Autowired
    AutrhorService autrhorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        autrhorService.addAuthor(author);
        return "Author Added.";
    }
}
