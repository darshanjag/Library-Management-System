package com.Backend.Library_Management.Service;

import com.Backend.Library_Management.DTO.IssudeBookResponseDto;
import com.Backend.Library_Management.DTO.IssueBookRequestDto;
import com.Backend.Library_Management.Enum.CardStatus;
import com.Backend.Library_Management.Enum.TransactionStatus;
import com.Backend.Library_Management.Repository.BookRepository;
import com.Backend.Library_Management.Repository.CardRepository;
import com.Backend.Library_Management.Repository.TransactionRepository;
import com.Backend.Library_Management.modal.Book;
import com.Backend.Library_Management.modal.LibraryCard;
import com.Backend.Library_Management.modal.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private JavaMailSender emailSender;
    public IssudeBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto)throws Exception{
        Transaction transaction = new Transaction();

        transaction.setTransactionNumber(UUID.randomUUID().toString());
        transaction.setIssueOperation(true);

        LibraryCard card;

        try{
           card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("card not found");
            transactionRepository.save(transaction);
            throw new Exception("Card not found!!");

        }
        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("book not found");
            transactionRepository.save(transaction);

            throw new Exception("Book not found!!");

        }

        transaction.setBook(book);
        transaction.setCard(card);
        if(card.getStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("card status not activated");
            transactionRepository.save(transaction);

            throw new Exception("Sorry Card is not Activated.");
        }

        if(book.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Sorry the book has been issued");
            transactionRepository.save(transaction);
            throw new Exception("Sorry the book has been issued");
        }
        book.setIssued(true);
        book.setCard(card);
        transaction.setMessage("Transaction was Successfull");
        book.getTransactions().add(transaction);
        card.getTransactions().add(transaction);
        card.getBooks().add(book);

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        cardRepository.save(card); // will save both book and transaction
        IssudeBookResponseDto responseDto = new IssudeBookResponseDto();
        responseDto.setStatus(transaction.getTransactionStatus());
        responseDto.setBookName(book.getTitle());
        responseDto.setTransactionId(transaction.getTransactionNumber());

        String text = "book "+book.getTitle()+" has been issued to you.";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("saymynamejessi@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Issue Book Notification");
        message.setText(text);
        emailSender.send(message);
        return responseDto;
    }
}
