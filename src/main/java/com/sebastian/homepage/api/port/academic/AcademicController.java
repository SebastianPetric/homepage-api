package com.sebastian.homepage.api.port.academic;

import com.sebastian.homepage.api.domain.core.academic.Academic;
import com.sebastian.homepage.api.domain.core.academic.PutBodyAcademic;
import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import com.sebastian.homepage.api.port.generic.GenericController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/academic", produces = MediaType.APPLICATION_JSON_VALUE)
public class AcademicController extends GenericController<Academic, PutBodyAcademic> {


    protected AcademicController(GenericRepository<Academic, PutBodyAcademic> repository) {
        super(repository);
    }
}
