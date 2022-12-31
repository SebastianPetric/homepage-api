package com.sebastian.homepage.api.domain.core.covering;

import com.sebastian.homepage.api.domain.core.generic.GenericEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "covering_letter")
public class CoveringLetter implements Serializable, GenericEntity<CoveringLetter, PutBodyCoveringLetter> {

    @Id
    private String id;

    @NotEmpty
    private String text;

    @NotNull
    private TextType type;

    public CoveringLetter() {
    }

    public CoveringLetter(String id, String text, TextType type) {
        this.id = id;
        this.text = text;
        this.type = type;
    }

    @Override
    public void init(CoveringLetter source) {
        this.id = source.id;
        this.text = source.text;
        this.type = source.type;
    }

    @Override
    public CoveringLetter editOriginal(PutBodyCoveringLetter source) {
        if (source.getType() != null)
            setType(source.getType());
        if (source.getText() != null)
            setText(source.getText());
        return this;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public CoveringLetter createNewInstance() {
        CoveringLetter coveringLetter = new CoveringLetter();
        coveringLetter.init(this);
        return coveringLetter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextType getType() {
        return type;
    }

    public void setType(TextType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoveringLetter that = (CoveringLetter) o;
        return Objects.equals(id, that.id) && Objects.equals(text, that.text) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, type);
    }
}
