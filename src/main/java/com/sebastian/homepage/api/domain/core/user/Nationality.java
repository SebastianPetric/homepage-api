package com.sebastian.homepage.api.domain.core.user;

public enum Nationality {
    DE("deutsch"),
    EN("englisch");

    public final String label;

    Nationality(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
