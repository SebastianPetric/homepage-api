package com.sebastian.homepage.api.domain.core.experience;

import com.sebastian.homepage.api.domain.core.generic.GenericPutBody;

import java.util.List;

public class PutBodyExperience implements GenericPutBody<PutBodyExperience> {

    private String title;


    private List<String> experiencePoints;

    private String experience;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(List<String> experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
