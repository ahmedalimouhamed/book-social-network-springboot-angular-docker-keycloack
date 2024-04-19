package com.example.book.email;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum EmailTemplateName {
    ACTIVATE_ACCOUNT("Activate_account");

    private final String name;

    EmailTemplateName(String name) {
        this.name = name;
    }
}
