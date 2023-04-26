package com.Backend.Library_Management.DTO;

import com.Backend.Library_Management.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssudeBookResponseDto {

    private String transactionId;

    private String bookName;

    private TransactionStatus status;
}
