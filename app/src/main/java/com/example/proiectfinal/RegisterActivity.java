package com.example.proiectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.net.Inet4Address;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextName, textInputEditTextUser, textInputEditTextEmail, textInputEditTextPassword;
    Button register;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputEditTextName=findViewById(R.id.nume);
        textInputEditTextUser=findViewById(R.id.username);
        textInputEditTextEmail=findViewById(R.id.email);
        textInputEditTextPassword=findViewById(R.id.parola);
        register=findViewById(R.id.register);
        progressBar=findViewById(R.id.progressBar);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nume, username, parola, email;
                nume= String.valueOf(textInputEditTextName.getText());
                username= String.valueOf(textInputEditTextUser.getText());
                email= String.valueOf(textInputEditTextEmail.getText());
                parola= String.valueOf(textInputEditTextPassword.getText());
                Log.i("info", nume);
                Log.i("info", username);
                Log.i("info", email);
                Log.i("info", parola);
                if(!nume.equals("") && nume!= null && !username.equals("") && username !=null && !email.equals("") && email != null &&
                        !parola.equals("") && parola !=null) {
                    Log.i("info:", "am intrat in if");

                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[4];
                            field[0] = "nume";
                            field[1] = "username";
                            field[2] = "email";
                            field[3] = "parola";
                            String[] data = new String[4];
                            data[0] = nume;
                            data[1] = username;
                            data[2]=email;
                            data[3]=parola;
                            PutData putData = new PutData("http://192.168.0.103/LoginRegister/signup.php?_ijt=1d32lgfi8q16g758lue7282qna", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    Log.i("info", putData.getResult());
                                    if(result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}