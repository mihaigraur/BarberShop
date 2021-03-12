package com.example.proiectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.proiectfinal.LoginActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Button button = (Button) findViewById(R.id.register);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openRegister();
                }
            });
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Eroare", Toast.LENGTH_SHORT).show();
        }


        Button button1=(Button) findViewById(R.id.login);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }

    public void openRegister(){
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void openLogin(){
        Intent intent1=new Intent(this, LoginActivity.class);
        startActivity(intent1);
    }
}