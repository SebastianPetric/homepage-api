package com.sebastian.homepage.api.port.user;

import com.sebastian.homepage.api.domain.core.exception.NotFoundException;
import com.sebastian.homepage.api.domain.core.user.PutBodyUser;
import com.sebastian.homepage.api.domain.core.user.User;
import com.sebastian.homepage.api.domain.core.user.UserServiceImpl;
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
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<?> deleteById(@PathVariable @Valid ObjectId id) {
        Optional<User> user = userService.findById(id);

        if (user.isEmpty())
            throw new NotFoundException(id);

        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<User> editById(@PathVariable ObjectId id, @RequestBody @Valid PutBodyUser toModify) {

        Optional<User> user = userService.findById(id);

        if (user.isEmpty())
            throw new NotFoundException(id);

        return ResponseEntity.ok(userService.editById(user.get(), toModify));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:admin')")
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
