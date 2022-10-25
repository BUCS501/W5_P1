package com.example.w5_p1;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import java.util.*;

import javax.security.auth.callback.Callback;

public class frag_bottom extends Fragment {

    private String [] words = {"CAT", "DOG", "TIGER", "LION", "ELEPHANT"};
    private ArrayList<Integer> images = new ArrayList<Integer>();
    private int currentIndex;

    private frag_top.Callbacks mCallbacks = sDummyCallbacks;

    public interface Callbacks{
        public void updateTextView(String input);
    }

    private static frag_top.Callbacks sDummyCallbacks = new frag_top.Callbacks(){
        public void updateTextView(String input){

        }
    };

    public frag_bottom(){

    }

    public void onAttach( Context context ) {
        super.onAttach( context );
        if ( !( context instanceof frag_top.Callbacks) ) {
            throw new IllegalStateException(
                    "Context must implement fragment's callbacks." );
        }
        mCallbacks = (frag_top.Callbacks) context;
    }

    public void onDetach( ) {
        super.onDetach( );
        mCallbacks = sDummyCallbacks;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.bottom_frag, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View fragment = getView();
        ImageView image = (ImageView) fragment.findViewById(R.id.img);
        TextView retrieved = (TextView) fragment.findViewById(R.id.received);
        images.add(R.drawable.cat);
        images.add(R.drawable.dog);
        images.add(R.drawable.tiger);
        images.add(R.drawable.lion);
        images.add(R.drawable.elephant);

        currentIndex = 0;
        image.setImageResource(R.drawable.cat);


    }
    @Override
    public void onResume() {
        super.onResume();

        View fragment = getView();
        ImageView image = (ImageView) fragment.findViewById(R.id.img);
        if (currentIndex == 0){
            image.setImageResource(R.drawable.cat);
        }
        if (currentIndex == 1){
            image.setImageResource(R.drawable.dog);
        }
        if (currentIndex == 2){
            image.setImageResource(R.drawable.tiger);
        }
        if (currentIndex == 3){
            image.setImageResource(R.drawable.lion);
        }
        if (currentIndex == 4){
            image.setImageResource(R.drawable.elephant);
        }
    }

    public void updateImage(String input){
        for (int i=0;i<words.length;i++){
            if (input.toUpperCase().equals(words[i])){
                currentIndex = i;
            }
        }
    }
}
