package com.example.ilidosha.dnd;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class Spells extends AbstractActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_spells);
        navigation = findViewById(R.id.navigation);

        navigation.setSelectedItemId(R.id.navigation_spells);
        super.onCreate(savedInstanceState);
    }
}
