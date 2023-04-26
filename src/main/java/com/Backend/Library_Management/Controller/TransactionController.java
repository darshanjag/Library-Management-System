package com.Backend.Library_Management.Controller;

import com.Backend.Library_Management.DTO.IssudeBookResponseDto;
import com.Backend.Library_Management.DTO.IssueBookRequestDto;
import com.Backend.Library_Management.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/issue")
    public ResponseEntity issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        IssudeBookResponseDto responseDto;
        System.out.println(issueBookRequestDto.getBookId());
        System.out.println(issueBookRequestDto.getCardId());
        try{
            responseDto= transactionService.issueBook(issueBookRequestDto);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(responseDto,HttpStatus.ACCEPTED);

    }

}
