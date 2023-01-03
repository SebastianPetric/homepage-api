package com.sebastian.homepage.api.port.user;

import com.sebastian.homepage.api.domain.core.generic.GenericRepository;
import com.sebastian.homepage.api.domain.core.user.PutBodyUser;
import com.sebastian.homepage.api.domain.core.user.User;
import com.sebastian.homepage.api.port.generic.GenericController;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends GenericController<User, PutBodyUser> {

    protected UserController(GenericRepository<User, PutBodyUser> repository) {
        super(repository);
    }
}
