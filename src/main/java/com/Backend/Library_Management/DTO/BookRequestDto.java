package com.Backend.Library_Management.DTO;



import com.Backend.Library_Management.Enum.Genres;
import com.Backend.Library_Management.modal.Author;
import com.Backend.Library_Management.modal.LibraryCard;
import com.Backend.Library_Management.modal.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int price;

    private int authorId;

    private Genres genre;



}
