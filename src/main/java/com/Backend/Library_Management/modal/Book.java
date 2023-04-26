package com.Backend.Library_Management.modal;

import com.Backend.Library_Management.Enum.Genres;
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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int price;

    private boolean isIssued;

    @CreatedDate
    private Date created;

    @UpdateTimestamp
    private Date updationDate;

    @Enumerated(EnumType.STRING)
    private Genres genre;

    @ManyToOne
    @JoinColumn
    Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions=  new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LibraryCard card;


}
