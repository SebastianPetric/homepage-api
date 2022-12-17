package com.sebastian.homepage.api.domain.core.user;

import com.sebastian.homepage.api.domain.core.generic.GenericEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "users")
public class User implements Serializable, GenericEntity<User> {
    @Id
    private String id;

    @NotEmpty
    private String first_name;
    @NotEmpty
    private String last_name;

    @NotEmpty
    private String street_name;
    @NotEmpty
    private Integer street_number;
    @NotEmpty
    private Long postal_code;
    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;
    @NotEmpty
    private String phone;
    @NotNull
    private FamilyState familyState;
    @NotNull
    private LocalDate birthday;
    @NotNull
    private Nationality nationality;
    @NotEmpty
    private String github_link;
    @NotEmpty
    private String xing_link;
    @NotEmpty
    private String linkedin_link;
    @NotEmpty
    private String birth_land;
    @NotEmpty
    private String birth_city;


    public User() {
    }

    public User(String id, String first_name, String last_name, String street_name, Integer street_number, Long postal_code, String city, String state, String title, String description, String phone, FamilyState familyState, LocalDate birthday, Nationality nationality, String github_link, String xing_link, String linkedin_link, String birth_land, String birth_city) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street_name = street_name;
        this.street_number = street_number;
        this.postal_code = postal_code;
        this.city = city;
        this.state = state;
        this.title = title;
        this.description = description;
        this.phone = phone;
        this.familyState = familyState;
        this.birthday = birthday;
        this.nationality = nationality;
        this.github_link = github_link;
        this.xing_link = xing_link;
        this.linkedin_link = linkedin_link;
        this.birth_land = birth_land;
        this.birth_city = birth_city;
    }

    @Override
    public void update(User source) {
        this.id = source.id;
        this.first_name = source.first_name;
        this.last_name = source.last_name;
        this.street_name = source.street_name;
        this.street_number = source.street_number;
        this.postal_code = source.postal_code;
        this.city = source.city;
        this.state = source.state;
        this.title = source.title;
        this.description = source.description;
        this.phone = source.phone;
        this.familyState = source.familyState;
        this.birthday = source.birthday;
        this.nationality = source.nationality;
        this.github_link = source.github_link;
        this.xing_link = source.xing_link;
        this.linkedin_link = source.linkedin_link;
        this.birth_land = source.birth_land;
        this.birth_city = source.birth_city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public User createNewInstance() {
        User user = new User();
        user.update(this);
        return user;
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

    public Long getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(Long postal_code) {
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
}
