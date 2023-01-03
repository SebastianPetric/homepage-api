package com.sebastian.homepage.api.port.experience;

import com.sebastian.homepage.api.domain.core.experience.Experience;
import com.sebastian.homepage.api.domain.core.experience.PutBodyExperience;
import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import com.sebastian.homepage.api.port.generic.GenericController;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "/experiences", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceController extends GenericController<Experience, PutBodyExperience> {

    protected ExperienceController(GenericRepository<Experience, PutBodyExperience> repository) {
        super(repository);
    }

}
