package com.sebastian.homepage.api.domain.core.generic;

public interface GenericEntity<T, B> {

    void init(T source);

    T editOriginal(B source);

    String getId();

    T createNewInstance();
}
