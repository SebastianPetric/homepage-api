package com.sebastian.homepage.api.domain.core.career;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareerServiceImpl implements ICareerService {

    @Autowired
    ICareerRepository careerRepository;

    @Override
    public Career save(Career career) {
        return careerRepository.save(career);
    }

    @Override
    public List<Career> findAll() {
        return careerRepository.findAll();
    }

    @Override
    public Optional<Career> findById(ObjectId id) {
        return careerRepository.findById(id);
    }

    @Override
    public Career editById(Career career, PutBodyCareer toModify) {
        if (toModify.getTitle() != null)
            career.setTitle(toModify.getTitle());
        if (toModify.getCompany() != null)
            career.setCompany(toModify.getCompany());
        if (toModify.getFrom_date() != null)
            career.setFrom_date(toModify.getFrom_date());
        if (toModify.getTo_date() != null)
            career.setTo_date(toModify.getTo_date());
        if (toModify.getToDos() != null) {
            List<String> tmp = career.getToDos();
            tmp.add(toModify.getToDo());
            career.setToDos(tmp);
        }
        return careerRepository.save(career);
    }

    @Override
    public void deleteById(ObjectId id) {

    }
}
