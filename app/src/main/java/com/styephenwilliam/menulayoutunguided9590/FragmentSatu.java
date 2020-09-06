package com.styephenwilliam.menulayoutunguided9590;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentSatu extends Fragment {

    public final static String FULL_NAME = "full_name";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_satu, container, false);

        final TextInputEditText full_name = view.findViewById(R.id.full_name);
        final MaterialButton btnSumbit = view.findViewById(R.id.btnSubmit);

        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = full_name.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString(FULL_NAME, message);

                Fragment move = new FragmentDua();
                move.setArguments(bundle);
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentLayout, move)
                        .commit();
            }
        });
        return view;
    }
}