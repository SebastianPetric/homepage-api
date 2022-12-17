package com.sebastian.homepage.api.domain.core.experience;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceImpl implements IExperienceService {

    @Autowired
    IExperienceRepository experienceRepository;

    @Override
    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Optional<Experience> findById(ObjectId id) {
        return experienceRepository.findById(id);
    }

    @Override
    public Experience editById(Experience experience, PutBodyExperience toModify) {
        if (toModify.getTitle() != null)
            experience.setTitle(toModify.getTitle());
        if (toModify.getExperiencePoints() != null)
            experience.setExperiencePoints(toModify.getExperiencePoints());
        if (toModify.getExperience() != null) {
            List<String> tmp = experience.getExperiencePoints();
            tmp.add(toModify.getExperience());
            experience.setExperiencePoints(tmp);
        }
        return experienceRepository.save(experience);
    }

    @Override
    public void deleteById(ObjectId id) {
        experienceRepository.deleteById(id);
    }
}
