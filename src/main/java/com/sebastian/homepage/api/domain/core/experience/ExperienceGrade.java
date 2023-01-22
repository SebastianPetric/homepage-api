package com.sebastian.homepage.api.domain.core.experience;

public enum ExperienceGrade {
    TOTAL_BEGINNER("TOTAL_BEGINNER"),
    BEGINNER("BEGINNER"),
    INTERMEDIATE("INTERMEDIATE"),
    PROFESSIONAL("PROFESSIONAL");


    public final String label;

    ExperienceGrade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
