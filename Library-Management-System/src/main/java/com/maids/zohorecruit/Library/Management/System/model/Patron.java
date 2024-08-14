package com.maids.zohorecruit.Library.Management.System.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Patrons")
@NoArgsConstructor
@AllArgsConstructor
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    @NotNull(message = "Name cannot be null")
    private String name;
    @Column(name = "contact_info", length = 255)
    private String contactInfo;

    @OneToMany(mappedBy = "patron")
    @JsonIgnore
    private List<BorrowingRecord> borrowingRecordsPatran;

}
