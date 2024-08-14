package com.maids.zohorecruit.Library.Management.System.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Borrowings")

public class BorrowingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id", nullable = false)
    private Patron patron;


    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrowDate;


    @Column(name = "return_date")
    private LocalDate returnDate;


    public BorrowingRecord(Book book, Patron patron, LocalDate borrowDate) {
        this.book = book;
        this.patron = patron;
        this.borrowDate = borrowDate;
        this.returnDate = borrowDate.plusDays(5);
    }

}
