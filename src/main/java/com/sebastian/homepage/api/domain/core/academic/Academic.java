package com.sebastian.homepage.api.domain.core.academic;

import com.sebastian.homepage.api.domain.core.generic.GenericEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Document(collection = "academic")
public class Academic implements Serializable, GenericEntity<Academic, PutBodyAcademic> {

    @Id
    private String id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String school;

    @NotNull
    private LocalDate from_date;

    private LocalDate to_date;

    private List<String> focusList;

    public Academic() {
    }

    public Academic(String id, String title, String school, LocalDate from_date, LocalDate to_date, List<String> focusList) {
        this.id = id;
        this.title = title;
        this.school = school;
        this.from_date = from_date;
        this.to_date = to_date;
        this.focusList = focusList;
    }


    @Override
    public Academic editOriginal(PutBodyAcademic source) {
        if (source.getTitle() != null)
            setTitle(source.getTitle());
        if (source.getSchool() != null)
            setSchool(source.getSchool());
        if (source.getFrom_date() != null)
            setFrom_date(source.getFrom_date());
        if (source.getTo_date() != null)
            setTo_date(source.getTo_date());
        if (source.getFocusList() != null)
            setFocusList(source.getFocusList());
        if (source.getFocusPoint() != null) {
            List<String> tmp = getFocusList();
            tmp.add(source.getFocusPoint());
            setFocusList(tmp);
        }
        return this;
    }

    @Override
    public void init(Academic source) {
        this.title = source.getTitle();
        this.school = source.getSchool();
        this.from_date = source.getFrom_date();
        this.to_date = source.getTo_date();
        this.focusList = source.getFocusList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Academic createNewInstance() {
        Academic academic = new Academic();
        academic.init(this);
        return academic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public List<String> getFocusList() {
        return focusList;
    }

    public void setFocusList(List<String> focusList) {
        this.focusList = focusList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Academic academic = (Academic) o;
        return Objects.equals(id, academic.id) && Objects.equals(title, academic.title) && Objects.equals(school, academic.school) && Objects.equals(from_date, academic.from_date) && Objects.equals(to_date, academic.to_date) && Objects.equals(focusList, academic.focusList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, school, from_date, to_date, focusList);
    }
}
