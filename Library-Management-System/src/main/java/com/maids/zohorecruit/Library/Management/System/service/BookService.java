package com.maids.zohorecruit.Library.Management.System.service;

import com.maids.zohorecruit.Library.Management.System.ExceptionHandler.ResourceNotFoundException;
import com.maids.zohorecruit.Library.Management.System.Repositories.BookRepository;
import com.maids.zohorecruit.Library.Management.System.model.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get All Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get Book By ID
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }


    // Add New Book
    public Book addBook(@Valid Book book) {
        return bookRepository.save(book);
    }


    // update Book By ID With New Data of Book
    public Book updateBook(Long id, Book updatedBook) {
        // Frist Find Book with ID And Hadling Error When Not Found
        Book book = getBookById(id);
        // After Found Book Update Data this Book
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPublicationYear(updatedBook.getPublicationYear());
        book.setIsbn(updatedBook.getIsbn());
        return bookRepository.save(book);
    }

    //Delete Book By ID
    public void deleteBook(Long id) {
        // Frist Find Book with ID And Hadling Error When Not Found
        Book book = getBookById(id);

        // After Found Book Delete this Book
        bookRepository.deleteById(book.getId());
    }

}
