package com.sebastian.homepage.api.domain.core.user;

import com.sebastian.homepage.api.domain.core.generic.GenericPutBody;

import java.time.LocalDate;


public class PutBodyUser implements GenericPutBody<PutBodyUser> {


    private String first_name;

    private String last_name;

    private String email;

    private String street_name;

    private Integer street_number;

    private Integer postal_code;

    private String city;

    private String state;

    private String phone;

    private String title;

    private String description;

    private FamilyState familyState;

    private LocalDate birthday;

    private Nationality nationality;

    private String github_link;

    private String xing_link;

    private String linkedin_link;


    private String birth_land;


    private String birth_city;

    public PutBodyUser(String first_name,
                       String last_name,
                       String email, String street_name,
                       Integer street_number,
                       Integer postal_code,
                       String city, String state, String phone,
                       String title,
                       String description,
                       FamilyState familyState,
                       LocalDate birthday,
                       Nationality nationality,
                       String github_link,
                       String xing_link,
                       String linkedin_link,
                       String birth_land,
                       String birth_city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.street_name = street_name;
        this.street_number = street_number;
        this.postal_code = postal_code;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.title = title;
        this.description = description;
        this.familyState = familyState;
        this.birthday = birthday;
        this.nationality = nationality;
        this.github_link = github_link;
        this.xing_link = xing_link;
        this.linkedin_link = linkedin_link;
        this.birth_land = birth_land;
        this.birth_city = birth_city;
    }

    public PutBodyUser() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public FamilyState getFamilyState() {
        return familyState;
    }

    public void setFamilyState(FamilyState familyState) {
        this.familyState = familyState;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getGithub_link() {
        return github_link;
    }

    public void setGithub_link(String github_link) {
        this.github_link = github_link;
    }

    public String getXing_link() {
        return xing_link;
    }

    public void setXing_link(String xing_link) {
        this.xing_link = xing_link;
    }

    public String getLinkedin_link() {
        return linkedin_link;
    }

    public void setLinkedin_link(String linkedin_link) {
        this.linkedin_link = linkedin_link;
    }

    public String getBirth_land() {
        return birth_land;
    }

    public void setBirth_land(String birth_land) {
        this.birth_land = birth_land;
    }

    public String getBirth_city() {
        return birth_city;
    }

    public void setBirth_city(String birth_city) {
        this.birth_city = birth_city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public Integer getStreet_number() {
        return street_number;
    }

    public void setStreet_number(Integer street_number) {
        this.street_number = street_number;
    }

    public Integer getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(Integer postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
