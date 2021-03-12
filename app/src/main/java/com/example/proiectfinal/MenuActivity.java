package com.example.proiectfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proiectfinal.Fragment.Fragment1;
import com.example.proiectfinal.R;
import com.google.android.material.textfield.TextInputEditText;

import static android.widget.Toast.LENGTH_SHORT;

public class MenuActivity extends AppCompatActivity {
        TextInputEditText nume, prenume, data, ora;
        CheckBox checkBox, checkBox2;
        Button b;
        TextView text;

        //pentru transmitere mesaj dintr o activitate in alta

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);
//            FragmentManager manager=getSupportFragmentManager();
//            final FragmentTransaction t=manager.beginTransaction().replace(R.id.text, new Fragment1());
//            final Fragment1 f1=new Fragment1();

            prenume=findViewById(R.id.prenume);
            nume=findViewById(R.id.nume);
            data=findViewById(R.id.data);
            ora=findViewById(R.id.ora);
            b=findViewById(R.id.button);
            checkBox=findViewById(R.id.checkBox);
            checkBox2=findViewById(R.id.checkBox2);
            text=findViewById(R.id.text);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SendInfo si=new SendInfo();
                    si.execute(nume.getText().toString(), prenume.getText().toString(), data.getText().toString(), ora.getText().toString()).isCancelled();
                    Toast.makeText(getApplicationContext(), "Te-ai programat in data de " + data.getText().toString() + " la ora " + ora.getText().toString(), Toast.LENGTH_LONG).show();

//                    Bundle b=new Bundle();
//                    b.putString("nume", nume.getText().toString());
//                    f1.setArguments(b);
//                    t.add(R.id.text, f1);
//                    t.commit();
//                    String numeA=nume.getText().toString();
//                    Intent intent=new Intent(getApplicationContext(), Fragment1.class);
//                    intent.putExtra("keynume", String.valueOf(numeA));
//                    startActivity(intent);


                    Log.i("info", "ok");
//                    si.execute(prenume.getText().toString());
//                    si.execute(data.getText().toString());
//                    si.execute(ora.getText().toString());

                    String numeVal=nume.getText().toString();
                    String prenumeVal=prenume.getText().toString();
                    String dataVal=data.getText().toString();
                    String oraVal=ora.getText().toString();

                    Intent intent=new Intent(MenuActivity.this, ProgramariActivity.class);
                    intent.putExtra("EXTRA", numeVal);
                    intent.putExtra("EXTRA1", prenumeVal);
                    intent.putExtra("EXTRA2", dataVal);
                    intent.putExtra("EXTRA3", oraVal);
                    startActivity(intent);
                }
            });
        }
        public TextInputEditText getNume(){
            return nume;
        }
}