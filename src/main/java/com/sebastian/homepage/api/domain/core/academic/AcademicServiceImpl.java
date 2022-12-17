package com.sebastian.homepage.api.domain.core.academic;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicServiceImpl implements IAcademicService {

    @Autowired
    IAcademicRepository iAcademicRepository;

    @Override
    public Academic save(Academic academic) {
        return iAcademicRepository.save(academic);
    }

    @Override
    public List<Academic> findAll() {
        return iAcademicRepository.findAll();
    }

    @Override
    public Optional<Academic> findById(ObjectId id) {
        return iAcademicRepository.findById(id);
    }

    @Override
    public Academic editById(Academic academic, PutBodyAcademic toModify) {

        if (toModify.getTitle() != null)
            academic.setTitle(toModify.getTitle());
        if (toModify.getSchool() != null)
            academic.setSchool(toModify.getSchool());
        if (toModify.getFrom_date() != null)
            academic.setFrom_date(toModify.getFrom_date());
        if (toModify.getTo_date() != null)
            academic.setTo_date(toModify.getTo_date());
        if (toModify.getFocusList() != null)
            academic.setFocusList(toModify.getFocusList());
        if (toModify.getFocusPoint() != null) {
            List<String> tmp = academic.getFocusList();
            tmp.add(toModify.getFocusPoint());
            academic.setFocusList(tmp);
        }

        return iAcademicRepository.save(academic);
    }

    @Override
    public void deleteById(ObjectId id) {

    }
}
