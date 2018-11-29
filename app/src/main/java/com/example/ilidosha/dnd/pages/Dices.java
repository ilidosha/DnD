package com.example.ilidosha.dnd.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.ilidosha.dnd.R;

import static com.example.ilidosha.dnd.pages.LayoutPage.character;

public class Dices extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dices, container,
                false);
        renderDicesView(view);
        return view;
    }

    private void renderDicesView(View view){
        Button notifications = view.findViewById(R.id.buttonNotificationsOpen);
        if (character.getNotifications().size()==0){
            notifications.setVisibility(View.GONE);
        } else {
            notifications.setText("Оповещения: "+character.getNotifications().size());
            notifications.setVisibility(View.VISIBLE);
        }
    }
}
