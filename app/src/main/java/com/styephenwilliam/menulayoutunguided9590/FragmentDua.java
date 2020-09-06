package com.styephenwilliam.menulayoutunguided9590;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import static com.styephenwilliam.menulayoutunguided9590.FragmentSatu.FULL_NAME;

public class FragmentDua extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_dua, container, false);

       final MaterialTextView message = view.findViewById(R.id.full_name_tv);
       MaterialButton back = view.findViewById(R.id.btn_back);
       MaterialButton done = view.findViewById(R.id.btn_Done);
        AutoCompleteTextView ddiItem = view.findViewById(R.id.item_text);

       String check = getArguments().getString(FULL_NAME);
       if (check.isEmpty()){
           check = "Try Again!";
           message.setTextColor(Color.WHITE);
           message.setBackgroundColor(Color.RED);
       }
       message.setText(check);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.item_text));
       arrayAdapter.setDropDownViewResource(android.R.layout
               .simple_spinner_dropdown_item);
       ddiItem.setAdapter(arrayAdapter);

       ddiItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View v, int x, long y) {
               Toast.makeText(getActivity(),
                       "Saya Suka Makan " + arrayAdapter.getItem(x),
                       Toast.LENGTH_SHORT)
                       .show();
           }
       });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finishAndRemoveTask();
            }
        });

       return view;
    }
}