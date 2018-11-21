package com.example.ilidosha.dnd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import com.example.ilidosha.dnd.pages.*;
import com.example.ilidosha.dnd.pages.Character;

public class AbstractActivity extends Activity {

    protected BottomNavigationView navigation;
    protected BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent = null;
            switch (item.getItemId()) {
                case R.id.navigation_dices:
                    intent = new Intent(getApplicationContext(), Dices.class);
                    break;
                case R.id.navigation_inventory:
                    intent = new Intent(getApplicationContext(), Inventory.class);
                    break;
                case R.id.navigation_skills:
                    intent = new Intent(getApplicationContext(), Skills.class);
                    break;
                case R.id.navigation_spells:
                    intent = new Intent(getApplicationContext(), Spells.class);
                    break;
                case R.id.navigation_character:
                    intent = new Intent(getApplicationContext(), Character.class);
                    break;
            }
            startActivity(intent);
            return true;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
