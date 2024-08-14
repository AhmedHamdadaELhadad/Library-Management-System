package com.maids.zohorecruit.Library.Management.System.Repositories;

import com.maids.zohorecruit.Library.Management.System.model.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BorrowingRepository extends JpaRepository<BorrowingRecord, Long> {

    Optional<BorrowingRecord> findByBookIdAndPatronIdAndReturnDateIsNotNull(Long bookId, Long patronId);


}
