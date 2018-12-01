package com.example.ilidosha.dnd.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.ilidosha.dnd.enities.CustomBuilder;
import com.example.ilidosha.dnd.enities.Spell;
import com.example.ilidosha.dnd.enities.Stat;

import static com.example.ilidosha.dnd.pages.LayoutPage.*;

public class MySpells extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_spells, container,
                false);
        renderSpells(view);
        return view;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new SpellDescription();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content_frame, fragment);
            getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
            currentSpell = (Spell)view.getTag();
            transaction.commit();
        }
    };

    private View.OnClickListener listenerCell = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            final int index = (int)view.getTag();
            builder.setTitle("Изменение ячеек заклинаний");
            builder.setPositiveButton("- 1",  new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    character.getSpellCells().getLevel()[index]=character.getSpellCells().getLevel()[index]-1;
                    ((Button)view).setText((index+1)+" уровень: "+character.getSpellCells().getLevel()[index]+"/"+character.getSpellCells().getMaxLevel()[index]);
                }
            });
            builder.setNegativeButton("Восстановить", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    character.getSpellCells().getLevel()[(int)view.getTag()]=character.getSpellCells().getMaxLevel()[(int)view.getTag()];
                    ((Button)view).setText((index+1)+" уровень: "+character.getSpellCells().getLevel()[index]+"/"+character.getSpellCells().getMaxLevel()[index]);
                }
            });
            builder.setCancelable(true);
            builder.create().show();
        }
    };

    private void renderSpells(View view){
        LinearLayout layout = view.findViewById(R.id.linearLayoutMySkillsTable);
        for (int i=0;i<9;++i){
            LinearLayout spellCells = view.findViewById(R.id.linearLayoutSpellCells);
            if (character.getSpellCells().getMaxLevel()[i]!=0){
                Button button = new Button(getContext());
                button.setTag(i);
                button.setText((i+1)+" уровень: "+character.getSpellCells().getLevel()[i]+"/"+character.getSpellCells().getMaxLevel()[i]);
                button.setOnClickListener(listenerCell);
                spellCells.addView(button);
            }
        }

        for (Spell spell:character.getSpells()){
            Button button = new Button(getContext());
            button.setTag(spell);
            button.setText(spell.getLevel()+" "+spell.getName());
            button.setOnClickListener(listener);
            layout.addView(button);
        }
    }
}
