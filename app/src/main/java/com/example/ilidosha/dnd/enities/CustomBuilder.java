package com.example.ilidosha.dnd.enities;

import android.app.AlertDialog;

public class CustomBuilder {
    AlertDialog.Builder builder;
    String name;

    public CustomBuilder(AlertDialog.Builder builder, String name) {
        this.builder = builder;
        this.name = name;
    }

    public AlertDialog.Builder getBuilder() {
        return builder;
    }

    public void setBuilder(AlertDialog.Builder builder) {
        this.builder = builder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
