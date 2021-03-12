package com.example.proiectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.proiectfinal.Fragment.Fragmente;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextUser, textInputEditTextPassword;
    Button loginButton;
    //ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextUser=findViewById(R.id.username);
        textInputEditTextPassword=findViewById(R.id.parola);
        loginButton=findViewById(R.id.loginButton);
        //progressBar2=findViewById(R.id.progressBar2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username, parola;
                username= String.valueOf(textInputEditTextUser.getText());
                parola= String.valueOf(textInputEditTextPassword.getText());
                if(!username.equals("") && username !=null && !parola.equals("") && parola !=null) {
                    Log.i("info:", "am intrat in if");

                    //progressBar2.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "parola";
                            String[] data = new String[2];
                            data[0] = username;
                            data[1]=parola;
                            PutData putData = new PutData("http://192.168.0.103/LoginRegister/login.php?_ijt=m5vvecs8hgpc5ge7s5l9eol3cg", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    //progressBar2.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    Log.i("info", putData.getResult());
                                    if(result.equals("Login Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(getApplicationContext(), Fragmente.class);
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


//        Button b=(Button) findViewById(R.id.login);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openMenu();
//            }
//        });
    }

//    public void openMenu(){
//        Intent intent2=new Intent(this, MenuActivity.class);
//        startActivity(intent2);
//    }
}