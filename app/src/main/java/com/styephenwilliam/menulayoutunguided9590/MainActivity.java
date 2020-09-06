package com.styephenwilliam.menulayoutunguided9590;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment start = new FragmentSatu();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, start)
                .commit();
    }
}