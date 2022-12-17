package com.sebastian.homepage.api.domain.core.user;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    @Override
    public User editById(User user, PutBodyUser toModify) {

        if (toModify.getFirst_name() != null)
            user.setFirst_name(toModify.getFirst_name());
        if (toModify.getLast_name() != null)
            user.setLast_name(toModify.getLast_name());
        if (toModify.getPhone() != null)
            user.setPhone(toModify.getPhone());
        if (toModify.getTitle() != null)
            user.setTitle(toModify.getTitle());
        if (toModify.getDescription() != null)
            user.setDescription(toModify.getDescription());
        if (toModify.getFamilyState() != null)
            user.setFamilyState(toModify.getFamilyState());
        if (toModify.getBirthday() != null)
            user.setBirthday(toModify.getBirthday());
        if (toModify.getNationality() != null)
            user.setNationality(toModify.getNationality());
        if (toModify.getGithub_link() != null)
            user.setGithub_link(toModify.getGithub_link());
        if (toModify.getXing_link() != null)
            user.setXing_link(toModify.getXing_link());
        if (toModify.getLinkedin_link() != null)
            user.setLinkedin_link(toModify.getLinkedin_link());
        if (toModify.getBirth_land() != null)
            user.setBirth_land(toModify.getBirth_land());
        if (toModify.getBirth_city() != null)
            user.setBirth_city(toModify.getBirth_city());
        if (toModify.getStreet_name() != null)
            user.setStreet_name(toModify.getStreet_name());
        if (toModify.getStreet_number() != null)
            user.setStreet_number(toModify.getStreet_number());
        if (toModify.getPostal_code() != null)
            user.setPostal_code(toModify.getPostal_code());
        if (toModify.getCity() != null)
            user.setCity(toModify.getCity());
        if (toModify.getState() != null)
            user.setState(toModify.getState());
        return userRepository.save(user);
    }

    @Override
    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }
}
