package com.sebastian.homepage.api.domain.core.user;

public enum FamilyState {
    MARRIED("Verheiratet"),
    SINGLE("Ledig");

    private final String label;

    FamilyState(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
