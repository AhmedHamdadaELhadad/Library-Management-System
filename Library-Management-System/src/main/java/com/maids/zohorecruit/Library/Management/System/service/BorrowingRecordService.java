package com.maids.zohorecruit.Library.Management.System.service;

import com.maids.zohorecruit.Library.Management.System.ExceptionHandler.ResourceNotFoundException;
import com.maids.zohorecruit.Library.Management.System.Repositories.BookRepository;
import com.maids.zohorecruit.Library.Management.System.Repositories.BorrowingRepository;
import com.maids.zohorecruit.Library.Management.System.Repositories.PatronRepository;
import com.maids.zohorecruit.Library.Management.System.model.Book;
import com.maids.zohorecruit.Library.Management.System.model.BorrowingRecord;
import com.maids.zohorecruit.Library.Management.System.model.Patron;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Validated
public class BorrowingRecordService {

    private BorrowingRepository borrowingRepository;


    private BookRepository bookRepository;


    private PatronRepository patronRepository;

    @Autowired
    public BorrowingRecordService(BorrowingRepository borrowingRepository, BookRepository bookRepository, PatronRepository patronRepository) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    @Transactional
    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Patron> patron = patronRepository.findById(patronId);

        if (book.isPresent() && patron.isPresent()) {

            BorrowingRecord borrowingRecord = new BorrowingRecord(book.get(), patron.get(), LocalDate.now());

            return borrowingRepository.save(borrowingRecord);
        } else {
            throw new ResourceNotFoundException("Book or Patron not found");
        }
    }

    @Transactional
    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        Optional<BorrowingRecord> borrowingRecord = borrowingRepository.findByBookIdAndPatronIdAndReturnDateIsNotNull(bookId, patronId);

        if ( borrowingRecord.isPresent()) {
            BorrowingRecord record = borrowingRecord.get();
            record.setBorrowDate(LocalDate.now());
            LocalDate returnDate = LocalDate.now().plusDays(10);
            record.setReturnDate(returnDate);  // Set the return date to the current date
            return borrowingRepository.save(record);

        } else {
            throw new ResourceNotFoundException("No active borrowing record found for this book and patron");
        }


    }


}

