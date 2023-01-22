package com.sebastian.homepage.api.domain.core.experience;

import com.sebastian.homepage.api.domain.core.generic.GenericPutBody;

import java.util.List;

public class PutBodyExperience implements GenericPutBody<PutBodyExperience> {

    private String title;

    private List<ExperiencePoint> experiencePoints;

    private ExperiencePoint experience;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ExperiencePoint> getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(List<ExperiencePoint> experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public ExperiencePoint getExperience() {
        return experience;
    }

    public void setExperience(ExperiencePoint experience) {
        this.experience = experience;
    }
}
