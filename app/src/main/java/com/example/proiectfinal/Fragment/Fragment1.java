package com.example.proiectfinal.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proiectfinal.MenuActivity;
import com.example.proiectfinal.ProgramariActivity;
import com.example.proiectfinal.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import static android.widget.Toast.LENGTH_SHORT;

public class Fragment1 extends Fragment {
    Button button3;
    RatingBar ratingBar;
    Button button4;
    TextView textView4;
    Button button5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragement1, container, false);

        EditText nr = (EditText) v.findViewById(R.id.editText);


        button3=v.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                            String str=nr.getText().toString().trim();
                            Toast.makeText(getActivity(), str, LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });


        ratingBar=v.findViewById(R.id.ratingBar);
        textView4=v.findViewById(R.id.textView4);
        button4=v.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=String.valueOf(ratingBar.getRating());
                //Toast.makeText(getActivity(), s, LENGTH_SHORT).show();
                textView4.setText("Ati acordat " + s + " stele frizeriei!");
            }
        });

//        button5=v.findViewById(R.id.button5);
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getActivity(), ProgramariActivity.class);
//                startActivity(intent);
//            }
//        });

        return v;
    }
}
