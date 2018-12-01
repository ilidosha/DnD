package com.example.ilidosha.dnd.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ilidosha.dnd.R;

import static com.example.ilidosha.dnd.pages.LayoutPage.*;

public class SkillDescription extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skill_description, container,
                false);
        renderSkillDescription(view);
        return view;
    }

    private void renderSkillDescription(View view){
        TextView name = view.findViewById(R.id.textViewNameSD);
        TextView description = view.findViewById(R.id.textViewDescriptionSD);
        name.setText(currentSkill.getName());
        description.setText(currentSkill.getDescription());
    }
}
