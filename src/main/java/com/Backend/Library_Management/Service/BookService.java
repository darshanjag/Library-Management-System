package com.Backend.Library_Management.Service;

import com.Backend.Library_Management.DTO.BookRequestDto;
import com.Backend.Library_Management.DTO.BookResponseDto;
import com.Backend.Library_Management.Repository.AuthorRepository;
import com.Backend.Library_Management.Repository.BookRepository;
import com.Backend.Library_Management.modal.Author;
import com.Backend.Library_Management.modal.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    public BookResponseDto addBook(BookRequestDto bookRequestDto) throws Exception {

        Book book = new Book();
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setTitle(bookRequestDto.getTitle());
        book.setPrice(bookRequestDto.getPrice());
        book.setGenre(bookRequestDto.getGenre());
        book.setAuthor(author);
        book.setIssued(false);

        author.getBooks().add(book);
        authorRepository.save(author); // this will save both book and author.
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());
        return bookResponseDto;
    }
}
