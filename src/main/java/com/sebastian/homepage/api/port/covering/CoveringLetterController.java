package com.sebastian.homepage.api.port.covering;

import com.sebastian.homepage.api.domain.core.covering.CoveringLetter;
import com.sebastian.homepage.api.domain.core.covering.CoveringLetterServiceImpl;
import com.sebastian.homepage.api.domain.core.covering.PutBodyCoveringLetter;
import com.sebastian.homepage.api.domain.core.exception.NotFoundException;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/covering-letter", produces = MediaType.APPLICATION_JSON_VALUE)
public class CoveringLetterController {

    @Autowired
    CoveringLetterServiceImpl coveringLetterServiceImpl;

    @GetMapping
    public ResponseEntity<List<CoveringLetter>> getAll() {
        return ResponseEntity.ok(coveringLetterServiceImpl.findAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> deleteById(@PathVariable @Valid ObjectId id) {
        Optional<CoveringLetter> coveringLetter = coveringLetterServiceImpl.findById(id);

        if (coveringLetter.isEmpty())
            throw new NotFoundException(id);

        coveringLetterServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<CoveringLetter> editById(@PathVariable ObjectId id, @RequestBody @Valid PutBodyCoveringLetter toModify) {

        Optional<CoveringLetter> coveringLetter = coveringLetterServiceImpl.findById(id);

        if (coveringLetter.isEmpty())
            throw new NotFoundException(id);

        return ResponseEntity.ok(coveringLetterServiceImpl.editById(coveringLetter.get(), toModify));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> save(@RequestBody @Valid CoveringLetter coveringLetter) {
        return ResponseEntity.ok(coveringLetterServiceImpl.save(coveringLetter));
    }
}
