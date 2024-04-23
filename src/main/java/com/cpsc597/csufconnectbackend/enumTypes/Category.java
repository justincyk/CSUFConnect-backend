package com.cpsc597.csufconnectbackend.enumTypes;

import java.util.Arrays;

public enum Category {
    UNIVERSITY("University"),
    ORGANIZATION("Organization"),
    CLUB("Club"),
    GROUP("Group"),
    STUDENT("Student");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Category fromString(String value) {
        return Arrays.stream(Category.values())
                .filter(category -> category.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}