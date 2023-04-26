package com.Backend.Library_Management.Controller;

import com.Backend.Library_Management.DTO.BookRequestDto;
import com.Backend.Library_Management.DTO.BookResponseDto;
import com.Backend.Library_Management.Service.BookService;
import com.Backend.Library_Management.modal.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto book) throws Exception {
        BookResponseDto bookResponseDto;
        try{
          bookResponseDto=  bookService.addBook(book);
        }catch (Exception e){
            throw new Exception(e);
        }

        return bookResponseDto;
    }
}
