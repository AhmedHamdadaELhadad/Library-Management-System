package com.maids.zohorecruit.Library.Management.System.Repositories;

import com.maids.zohorecruit.Library.Management.System.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
