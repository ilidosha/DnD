package com.example.ilidosha.dnd.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.ilidosha.dnd.R;

import static com.example.ilidosha.dnd.pages.LayoutPage.character;
import static com.example.ilidosha.dnd.pages.LayoutPage.levelUpService;

public class Character extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_character, container,
                false);
        renderCharacterView(view);
        return view;
    }

    private void renderCharacterView(View view){

    }
}
