package com.sebastian.homepage.api.domain.core.covering;

public enum TextType {
    COVERING("Begrüßung"),
    ABOUT_ME("Über mich"),
    CAREER("Beruflicher Werdegang"),
    ACADEMIC("Akademischer Werdegang"),
    INFO("Info");


    public final String label;

    TextType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}