package com.sebastian.homepage.api.domain.core.experience;

import jakarta.validation.constraints.NotEmpty;

public class ExperiencePoint {

    @NotEmpty
    private String name;

    private Integer yearsOfExperience;

    private ExperienceGrade gradeOfExperience;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public ExperienceGrade getGradeOfExperience() {
        return gradeOfExperience;
    }

    public void setGradeOfExperience(ExperienceGrade experienceGrade) {
        this.gradeOfExperience = experienceGrade;
    }
}
