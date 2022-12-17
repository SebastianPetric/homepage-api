package com.sebastian.homepage.api.domain.core.experience;

import com.sebastian.homepage.api.domain.core.generic.GenericEntity;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document(collection = "experiences")
public class Experience implements Serializable, GenericEntity<Experience, PutBodyExperience> {

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


    @Override
    public void init(Experience source) {
        this.id = source.id;
        this.title = source.title;
        this.experiencePoints = source.experiencePoints;
    }

    @Override
    public Experience editOriginal(PutBodyExperience source) {
        if (source.getTitle() != null)
            setTitle(source.getTitle());
        if (source.getExperiencePoints() != null)
            setExperiencePoints(source.getExperiencePoints());
        if (source.getExperience() != null) {
            List<String> tmp = getExperiencePoints();
            tmp.add(source.getExperience());
            setExperiencePoints(tmp);
        }
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Experience createNewInstance() {
        Experience experience = new Experience();
        experience.init(this);
        return experience;
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
