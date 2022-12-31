package com.sebastian.homepage.api.domain.core.covering;

import com.sebastian.homepage.api.domain.core.generic.GenericPutBody;

public class PutBodyCoveringLetter implements GenericPutBody<PutBodyCoveringLetter> {

    private String text;
    
    private TextType type;

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
}
