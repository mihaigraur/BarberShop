package com.example.proiectfinal;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SendInfo extends AsyncTask<String, Void, Void> {
    private Exception ex;
    @Override
    protected Void doInBackground(String... params) {
        try{
            try {
                Socket socket=new Socket("192.168.0.103", 8888);
                PrintWriter pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                pw.print(" | " + params[0] + " | ");
                //pw.print(" ");
                pw.print(params[1] + " | ");
                //pw.print(" ");
                pw.print(params[2] + " | ");
                //pw.print(" ");
                pw.print(params[3] + " | ");
                //pw.print(params[2]);
                //pw.print(params[3]);
                //pw.print(params[4] + " | ");
                //pw.print(params[5] + " | ");
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            this.ex=e;
            return null;
        }
        return null;
    }

}
