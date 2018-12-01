package com.example.ilidosha.dnd.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.ilidosha.dnd.R;
import com.example.ilidosha.dnd.enities.Skill;
import com.example.ilidosha.dnd.enities.Spell;

import static com.example.ilidosha.dnd.pages.LayoutPage.*;

public class MySkills extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_skills, container,
                false);
        renderSkills(view);
        return view;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new SkillDescription();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content_frame, fragment);
            getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
            currentSkill = (Skill) view.getTag();
            transaction.commit();
        }
    };

    private void renderSkills(View view){
        LinearLayout layout = view.findViewById(R.id.linearLayoutMySkillsTable);
        for (Skill skill:character.getSkills()){
            Button button = new Button(getContext());
            button.setTag(skill);
            button.setText(skill.getName());
            button.setOnClickListener(listener);
            layout.addView(button);
        }
    }
}
