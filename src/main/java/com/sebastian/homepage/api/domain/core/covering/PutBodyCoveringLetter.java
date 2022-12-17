package com.sebastian.homepage.api.domain.core.covering;

import com.sebastian.homepage.api.domain.core.generic.GenericPutBody;

public class PutBodyCoveringLetter implements GenericPutBody<PutBodyCoveringLetter> {

    private String text;


    private String title;

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
}
