package com.example.ilidosha.dnd;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class Inventory extends AbstractActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_inventory);
        navigation = findViewById(R.id.navigation);

        navigation.setSelectedItemId(R.id.navigation_inventory);
        super.onCreate(savedInstanceState);
    }
}
