package com.sebastian.homepage.api.port.covering;

import com.sebastian.homepage.api.domain.core.covering.CoveringLetter;
import com.sebastian.homepage.api.domain.core.covering.CoveringLetterService;
import com.sebastian.homepage.api.domain.core.covering.PutBodyCoveringLetter;
import com.sebastian.homepage.api.domain.core.covering.TextType;
import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import com.sebastian.homepage.api.port.generic.GenericController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "/covering-letter", produces = MediaType.APPLICATION_JSON_VALUE)
public class CoveringLetterController extends GenericController<CoveringLetter, PutBodyCoveringLetter> {

    @Autowired
    CoveringLetterService coveringLetterService;

    protected CoveringLetterController(GenericRepository<CoveringLetter, PutBodyCoveringLetter> repository) {
        super(repository);
    }

    @GetMapping("/{type}")
    public ResponseEntity<CoveringLetter> findByType(@PathVariable @Valid TextType type) {
        return ResponseEntity.ok(coveringLetterService.findByType(type).orElse(null));
    }
}
