package com.example.w5_p1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.fragment.app.Fragment;

public class frag_top extends Fragment implements AdapterView.OnItemClickListener{

    ListView lv;



    private Callbacks mCallbacks = sDummyCallbacks;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            Toast.makeText(getActivity(), view.findViewById(R.id.inputText).getContext().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public interface Callbacks{
        public void updateTextView(String input);
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {
        public void updateTextView(String input){
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

    public void updateTextView(String input){
        mCallbacks.updateTextView(input);
    }

    public frag_top(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.top_frag, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        String [] words = {"CAT", "DOG", "TIGER", "LION", "ELEPHANT"};
        ListView listView = (ListView) view.findViewById(R.id.inputText);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,words);
        listView.setAdapter(adapter);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        View fragment = getView();
//
//
////        send.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String inputText = input.getText().toString();
////                Log.i("debugging", inputText);
////                if (inputText == null){
////                    Toast.makeText(getContext(), "please enter a word", Toast.LENGTH_SHORT).show();
////                }
//////                for (int i=0;i<words.length;i++){
//////                    if (inputText.toUpperCase().equals(words[i])){
//////                        matchWord(words[i]);
//////                    }
//////                }
////                matchWord(inputText);
////            }
////        });


}
