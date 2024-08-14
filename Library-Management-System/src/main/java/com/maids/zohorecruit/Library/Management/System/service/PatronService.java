package com.maids.zohorecruit.Library.Management.System.service;

import com.maids.zohorecruit.Library.Management.System.ExceptionHandler.ResourceNotFoundException;
import com.maids.zohorecruit.Library.Management.System.Repositories.PatronRepository;
import com.maids.zohorecruit.Library.Management.System.model.Patron;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class PatronService {


    private final PatronRepository patronRepository;

    @Autowired
    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(Long id) {
        return patronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with ID: " + id));
    }

    public Patron addPatron(@Valid Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron updatePatron(Long id, @Valid Patron updatedPatron) {
        Patron existingPatron = getPatronById(id);
        existingPatron.setName(updatedPatron.getName());
        existingPatron.setContactInfo(updatedPatron.getContactInfo());
        return patronRepository.save(existingPatron);
    }

    public void deletePatron(Long id) {
        if (!patronRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patron not found with ID: " + id);
        }
        patronRepository.deleteById(id);
    }
}
