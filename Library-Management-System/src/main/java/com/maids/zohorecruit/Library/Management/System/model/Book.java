package com.maids.zohorecruit.Library.Management.System.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Title cannot be null")
    @Column(name = "title", length = 100, nullable = false)
    private String title;
    @Column(name = "author", length = 100, unique = true, nullable = false)
    private String author;

    @Min(value = 1000, message = "Publication year must be no earlier than 1000")
    @Max(value = 9999, message = "Publication year must be no later than 9999")
    @Column(name = "publicationYear", nullable = false)
    private int publicationYear;

    @NotNull(message = "ISBN cannot be null")
    @Column(name = "isbn", length = 20, nullable = false, unique = true)
    private String isbn;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BorrowingRecord> borrowingRecordsBook;
}
