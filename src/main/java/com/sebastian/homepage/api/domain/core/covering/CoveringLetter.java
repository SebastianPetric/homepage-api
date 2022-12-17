package com.sebastian.homepage.api.domain.core.covering;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "covering_letter")
public class CoveringLetter {

    @Id
    private String id;

    @NotEmpty
    private String text;

    @NotEmpty
    private String title;

    public CoveringLetter() {
    }

    public CoveringLetter(String id, String text, String title) {
        this.id = id;
        this.text = text;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoveringLetter that = (CoveringLetter) o;
        return Objects.equals(id, that.id) && Objects.equals(text, that.text) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, title);
    }
}
