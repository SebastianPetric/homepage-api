package com.sebastian.homepage.api.domain.core.experience;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "experiences")
public class Experience {

    @Id
    private String id;

    @NotEmpty
    private String title;

    @NotEmpty
    private List<String> experiencePoints;

    public Experience() {
    }

    public Experience(String id, String title, List<String> experiencePoints) {
        this.id = id;
        this.title = title;
        this.experiencePoints = experiencePoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(experiencePoints, that.experiencePoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, experiencePoints);
    }
}
