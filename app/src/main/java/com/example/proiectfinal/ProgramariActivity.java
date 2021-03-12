package com.example.proiectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProgramariActivity extends AppCompatActivity {
    //TextView t1;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programari);

        //t1=(TextView) findViewById(R.id.textView5);
        Intent intent=getIntent();

        String strNume=intent.getStringExtra("EXTRA");
        String strPrenume=intent.getStringExtra("EXTRA1");
        String strData=intent.getStringExtra("EXTRA2");
        String strOra=intent.getStringExtra("EXTRA3");

        //Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        //t1.setText(str);

        lista=findViewById(R.id.lista);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(strNume);
        arrayList.add(strPrenume);
        arrayList.add(strData);
        arrayList.add(strOra);

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lista.setAdapter(arrayAdapter);
    }
}