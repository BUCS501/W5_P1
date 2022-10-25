package com.example.w5_p1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements frag_top.Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentById(R.id.top_frag) == null){
            androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            frag_top fragment = new frag_top();
            transaction.add(R.id.top_frag, fragment);
            transaction.commit();
        }
        if (fragmentManager.findFragmentById(R.id.bottom_frag) == null){
            androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            frag_bottom fragment = new frag_bottom();
            transaction.add(R.id.bottom_frag, fragment);
            transaction.commit();
        }
    }

    public void matchWord(String input){
        FragmentManager fragmentManager = getSupportFragmentManager();
        frag_bottom bFragment = (frag_bottom) fragmentManager.findFragmentById(R.id.bottom_frag);
        bFragment.updateTextView(input);
    }
}