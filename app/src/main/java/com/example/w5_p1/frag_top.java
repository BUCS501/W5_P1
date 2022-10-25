package com.example.w5_p1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.fragment.app.Fragment;

public class frag_top extends Fragment {

    private String [] words = {"CAT", "DOG", "TIGER", "LION", "ELEPHANT"};

    private Callbacks mCallbacks = sDummyCallbacks;

    public interface Callbacks{
        public void matchWord(String input);
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {
        public void matchWord(String input){
        }
    };

    public void onAttach( Context context ) {
        super.onAttach( context );
        if ( !( context instanceof Callbacks ) ) {
            throw new IllegalStateException(
                    "Context must implement fragment's callbacks." );
        }
        mCallbacks = ( Callbacks ) context;
    }

    public void onDetach( ) {
        super.onDetach( );
        mCallbacks = sDummyCallbacks;
    }

    public void matchWord(String input){
        mCallbacks.matchWord(input);
    }

    public frag_top(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.top_frag, container, false);
    }

    public void onStart() {
        super.onStart();
        View fragment = getView();
        EditText input = fragment.findViewById(R.id.inputText);
        Button send = fragment.findViewById(R.id.sendBtn);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = input.getText().toString();
                Log.i("debugging", inputText);
                if (inputText == null){
                    Toast.makeText(getContext(), "please enter a word", Toast.LENGTH_SHORT).show();
                }
//                for (int i=0;i<words.length;i++){
//                    if (inputText.toUpperCase().equals(words[i])){
//                        matchWord(words[i]);
//                    }
//                }
                matchWord(inputText);
            }
        });

    }
}
