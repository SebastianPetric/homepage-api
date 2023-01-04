package com.sebastian.homepage.api.domain.core.academic;

import com.sebastian.homepage.api.domain.core.generic.GenericPutBody;

import java.time.LocalDate;
import java.util.List;

public class PutBodyAcademic implements GenericPutBody<PutBodyAcademic> {


    private String title;


    private String school;


    private LocalDate from_date;

    private LocalDate to_date;

    private List<String> focusList;

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
}
