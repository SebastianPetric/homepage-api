package com.sebastian.homepage.api.domain.core.career;

import com.sebastian.homepage.api.domain.core.generic.GenericPutBody;

import java.time.LocalDate;
import java.util.List;

public class PutBodyCareer implements GenericPutBody<PutBodyCareer> {


    private String title;


    private String company;


    private LocalDate from_date;

    private LocalDate to_date;

    private List<String> toDos;

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
}
