package com.sebastian.homepage.api.domain.core.user;

import com.sebastian.homepage.api.domain.core.generic.GenericEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Document(collection = "users")
public class User implements Serializable, GenericEntity<User, PutBodyUser> {
    @Id
    private String id;

    @NotEmpty
    private String first_name;
    @NotEmpty
    private String last_name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String street_name;
    @NotNull
    private Integer street_number;
    @NotNull
    private Integer postal_code;
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

    public User(String id, String first_name, String last_name, String email, String street_name, Integer street_number, Integer postal_code, String city, String state, String title, String description, String phone, FamilyState familyState, LocalDate birthday, Nationality nationality, String github_link, String xing_link, String linkedin_link, String birth_land, String birth_city) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
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
    public void init(User source) {
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
        this.email = source.email;
    }

    @Override
    public User editOriginal(PutBodyUser source) {
        if (source.getFirst_name() != null)
            setFirst_name(source.getFirst_name());
        if (source.getLast_name() != null)
            setLast_name(source.getLast_name());
        if (source.getPhone() != null)
            setPhone(source.getPhone());
        if (source.getTitle() != null)
            setTitle(source.getTitle());
        if (source.getDescription() != null)
            setDescription(source.getDescription());
        if (source.getFamilyState() != null)
            setFamilyState(source.getFamilyState());
        if (source.getBirthday() != null)
            setBirthday(source.getBirthday());
        if (source.getNationality() != null)
            setNationality(source.getNationality());
        if (source.getGithub_link() != null)
            setGithub_link(source.getGithub_link());
        if (source.getXing_link() != null)
            setXing_link(source.getXing_link());
        if (source.getLinkedin_link() != null)
            setLinkedin_link(source.getLinkedin_link());
        if (source.getBirth_land() != null)
            setBirth_land(source.getBirth_land());
        if (source.getBirth_city() != null)
            setBirth_city(source.getBirth_city());
        if (source.getStreet_name() != null)
            setStreet_name(source.getStreet_name());
        if (source.getStreet_number() != null)
            setStreet_number(source.getStreet_number());
        if (source.getPostal_code() != null)
            setPostal_code(source.getPostal_code());
        if (source.getEmail() != null)
            setEmail(source.getEmail());
        if (source.getCity() != null)
            setCity(source.getCity());
        if (source.getState() != null)
            setState(source.getState());
        return this;
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
        user.init(this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(email, user.email) && Objects.equals(street_name, user.street_name) && Objects.equals(street_number, user.street_number) && Objects.equals(postal_code, user.postal_code) && Objects.equals(city, user.city) && Objects.equals(state, user.state) && Objects.equals(title, user.title) && Objects.equals(description, user.description) && Objects.equals(phone, user.phone) && familyState == user.familyState && Objects.equals(birthday, user.birthday) && nationality == user.nationality && Objects.equals(github_link, user.github_link) && Objects.equals(xing_link, user.xing_link) && Objects.equals(linkedin_link, user.linkedin_link) && Objects.equals(birth_land, user.birth_land) && Objects.equals(birth_city, user.birth_city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, email, street_name, street_number, postal_code, city, state, title, description, phone, familyState, birthday, nationality, github_link, xing_link, linkedin_link, birth_land, birth_city);
    }
}
