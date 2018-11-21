package com.example.ilidosha.dnd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Character extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_character);
        navigation = findViewById(R.id.navigation);

        navigation.setSelectedItemId(R.id.navigation_character);
        super.onCreate(savedInstanceState);
    }

}
