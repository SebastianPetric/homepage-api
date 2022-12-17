package com.sebastian.homepage.api.domain.core.career;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Document(collection = "career")
public class Career {

    @Id
    private String id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String company;

    @NotNull
    private LocalDate from_date;

    private LocalDate to_date;

    private List<String> toDos;


    public Career() {
    }

    public Career(String id, String title, String company, LocalDate from_date, LocalDate to_date, List<String> toDos) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.from_date = from_date;
        this.to_date = to_date;
        this.toDos = toDos;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public List<String> getToDos() {
        return toDos;
    }

    public void setToDos(List<String> toDos) {
        this.toDos = toDos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Career career = (Career) o;
        return Objects.equals(id, career.id) && Objects.equals(title, career.title) && Objects.equals(company, career.company) && Objects.equals(from_date, career.from_date) && Objects.equals(to_date, career.to_date) && Objects.equals(toDos, career.toDos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, company, from_date, to_date, toDos);
    }
}
