package com.example.proiectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.proiectfinal.R;
import com.google.android.material.textfield.TextInputEditText;

import static android.widget.Toast.LENGTH_SHORT;

public class MenuActivity extends AppCompatActivity {
        TextInputEditText nume, prenume, data, ora;
        CheckBox checkBox, checkBox2;
        Button b;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            nume=findViewById(R.id.nume);
            prenume=findViewById(R.id.prenume);
            data=findViewById(R.id.data);
            ora=findViewById(R.id.ora);
            b=findViewById(R.id.button);
            checkBox=findViewById(R.id.checkBox);
            checkBox2=findViewById(R.id.checkBox2);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SendInfo si=new SendInfo();
                    si.execute(nume.getText().toString(), prenume.getText().toString(), data.getText().toString(), ora.getText().toString()).isCancelled();
                    Toast.makeText(getApplicationContext(), "Te-ai programat in data de " + data.getText().toString() + " la ora " + ora.getText().toString(), Toast.LENGTH_LONG).show();



                    Log.i("info", "ok");
//                    si.execute(prenume.getText().toString());
//                    si.execute(data.getText().toString());
//                    si.execute(ora.getText().toString());
                }
            });
        }

}