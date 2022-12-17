package com.sebastian.homepage.api.port.covering;

import com.sebastian.homepage.api.domain.core.covering.CoveringLetter;
import com.sebastian.homepage.api.domain.core.covering.CoveringLetterServiceImpl;
import com.sebastian.homepage.api.domain.core.covering.PutBodyCoveringLetter;
import com.sebastian.homepage.api.domain.core.exception.NotFoundException;
import com.sebastian.homepage.api.domain.core.generic.GenericController;
import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/covering-letter", produces = MediaType.APPLICATION_JSON_VALUE)
public class CoveringLetterController extends GenericController<CoveringLetter> {

    @Autowired
    CoveringLetterServiceImpl coveringLetterServiceImpl;

    protected CoveringLetterController(GenericRepository<CoveringLetter> repository) {
        super(repository);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<CoveringLetter> editById(@PathVariable ObjectId id, @RequestBody @Valid PutBodyCoveringLetter toModify) {

        Optional<CoveringLetter> coveringLetter = coveringLetterServiceImpl.findById(id);

        if (coveringLetter.isEmpty())
            throw new NotFoundException(id);

        return ResponseEntity.ok(coveringLetterServiceImpl.editById(coveringLetter.get(), toModify));
    }
}
