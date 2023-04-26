package com.Backend.Library_Management.Service;

import com.Backend.Library_Management.Repository.AuthorRepository;
import com.Backend.Library_Management.modal.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutrhorService {
    @Autowired
    AuthorRepository authorRepository;
    public void addAuthor (Author author){
        authorRepository.save(author);
    }
}
