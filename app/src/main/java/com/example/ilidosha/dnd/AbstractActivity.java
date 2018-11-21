package com.example.ilidosha.dnd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

public class AbstractActivity extends Activity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_dices:
                    intent = new Intent(getApplicationContext(), Dices.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_inventory:
                    intent = new Intent(getApplicationContext(), Inventory.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_skills:
                    intent = new Intent(getApplicationContext(), Skills.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_spells:
                    intent = new Intent(getApplicationContext(), Spells.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_character:
                    intent = new Intent(getApplicationContext(), Character.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abstract_layout);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
