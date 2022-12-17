package com.sebastian.homepage.api.port.experience;

import com.sebastian.homepage.api.domain.core.experience.Experience;
import com.sebastian.homepage.api.domain.core.experience.PutBodyExperience;
import com.sebastian.homepage.api.domain.core.generic.GenericController;
import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/experiences", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceController extends GenericController<Experience, PutBodyExperience> {

    protected ExperienceController(GenericRepository<Experience, PutBodyExperience> repository) {
        super(repository);
    }

}
