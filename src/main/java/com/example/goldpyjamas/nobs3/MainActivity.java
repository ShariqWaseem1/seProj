package com.example.goldpyjamas.nobs3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.app.MESSAGE";
    private static String serverIP = "172.16.35.193";

    public static String getServerIP () {
        return serverIP;
    }
    public static boolean changeServerIP(String newIP) {
        if (ip(newIP)){
            serverIP = newIP;
            return true;
        }
        return false;
    }

    public static boolean ip(String text) {
        Pattern p = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher m = p.matcher(text);
        return m.find();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMessage();

    }

//    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
//    private void showProgress(final boolean show) {
//        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
//        // for very easy animations. If available, use these APIs to fade-in
//        // the progress spinner.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
//            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
//
//
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//                }
//            });
//
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mProgressView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//                }
//            });
//        } else {
//            // The ViewPropertyAnimator APIs are not available, so simply show
//            // and hide the relevant UI components.
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//        }
//    }

    public void sendMessage()  {

        final Intent intent = new Intent(this, LoginActivity.class);

        final Intent byPass = new Intent(this, AddRoomActivity.class);



        startActivity(byPass);
        finish();

//        class SendMessageToServer extends AsyncTask<String, Void, String> {
//
//            private Exception exception;
//            boolean connected = false;
//            private Context mContext;
//
//            SendMessageToServer(Context mContext){
//                this.mContext = mContext;
//            }
//
//            protected String doInBackground(String... rcv) {
//
//                    try {
//
//
//                        createSocket();
//
//                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//                        DataInputStream dis = new DataInputStream(socket.getInputStream());
//
//
//                        dos.writeUTF(rcv[0]);
//
//
//                        if (dis.readUTF().equals("ok")) {
//                            findViewById(R.id.progressBar).setVisibility(View.GONE);
//                            connected = true;
//                        }
//
//
//
//                        return "ok";
//
//
//                    } catch (Exception IOException) {
//
//                        return null;
//
//                    }
//
//
//
//            }
//
//            protected void onPostExecute(String result) {
//                if (connected){
//                    intent.putExtra(EXTRA_MESSAGE, result);
//                    startActivity(intent);
//                }else{
//                    errorIntent.putExtra(EXTRA_MESSAGE, result);
//                }
//
//            }
//        }
//
//        new SendMessageToServer(this).execute(message);

//        try{
//            Socket socket = new Socket("192.168.16.106", 8888);
//            intent.putExtra(EXTRA_MESSAGE, "fuck");
//
//            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//
//            dos.writeUTF(message);
//            intent.putExtra(EXTRA_MESSAGE, connectionStatus);
//        }catch (Exception IOException) {
//
//
//            intent.putExtra(EXTRA_MESSAGE, getStackTrace(IOException));
//        }












    }
    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
