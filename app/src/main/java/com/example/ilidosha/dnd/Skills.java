package com.example.ilidosha.dnd;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class Skills extends AbstractActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_skills);
        navigation = findViewById(R.id.navigation);

        navigation.setSelectedItemId(R.id.navigation_skills);
        super.onCreate(savedInstanceState);
    }
}
