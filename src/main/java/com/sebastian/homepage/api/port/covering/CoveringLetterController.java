package com.sebastian.homepage.api.port.covering;

import com.sebastian.homepage.api.domain.core.covering.CoveringLetter;
import com.sebastian.homepage.api.domain.core.covering.PutBodyCoveringLetter;
import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import com.sebastian.homepage.api.port.generic.GenericController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/covering-letter", produces = MediaType.APPLICATION_JSON_VALUE)
public class CoveringLetterController extends GenericController<CoveringLetter, PutBodyCoveringLetter> {

    protected CoveringLetterController(GenericRepository<CoveringLetter, PutBodyCoveringLetter> repository) {
        super(repository);
    }
}
