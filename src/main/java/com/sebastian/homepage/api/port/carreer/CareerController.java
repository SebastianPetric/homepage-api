package com.sebastian.homepage.api.port.carreer;

import com.sebastian.homepage.api.domain.core.career.Career;
import com.sebastian.homepage.api.domain.core.career.PutBodyCareer;
import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import com.sebastian.homepage.api.port.generic.GenericController;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "/career", produces = MediaType.APPLICATION_JSON_VALUE)
public class CareerController extends GenericController<Career, PutBodyCareer> {

    protected CareerController(GenericRepository<Career, PutBodyCareer> repository) {
        super(repository);
    }
}
