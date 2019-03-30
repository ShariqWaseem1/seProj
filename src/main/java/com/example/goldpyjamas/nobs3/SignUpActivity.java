package com.example.goldpyjamas.nobs3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    private TextView phoneView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);





        try {
            GetSocketTask getSocketTask = new GetSocketTask(this);
            Socket socket = getSocketTask.execute().get();
            if (socket == null) {

                finish();
                return;
            }



        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void btnSignupClick(View view) throws IOException, ExecutionException, InterruptedException {




        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtName = findViewById(R.id.txtName);
        EditText txtPass = findViewById(R.id.txtPass);
        EditText txtRepass = findViewById(R.id.txtRepass);
        EditText txtPhone = findViewById(R.id.txtPhone);

        String email = txtEmail.getText().toString();
        String name = txtName.getText().toString();
        String pass = txtPass.getText().toString();
        String rePass= txtRepass.getText().toString();
        String phone = txtPhone.getText().toString();




        Boolean cancel = false;



        View focusView = null;
        if (!isValidEmailAddress(email)){
            txtEmail.setError("Incorrect Email format!");
            focusView = txtEmail;
            cancel = true;
        }

        if (!isFullname(name)){
            txtName.setError("Incorrect Name format!");
            focusView = txtName;
            cancel = true;
        }

        if (!pass.equals(rePass) || pass.equals("")){
            txtRepass.setError("Passwords do not match!");
            focusView = txtRepass;
            cancel = true;
        }

//        if (!validateMobile(phone)){
//            txtPhone.setError("Phone number incorrect!");
//            focusView = txtPhone;
//            cancel = true;
//        }





        if (cancel){
            focusView.requestFocus();
        }else{


            try{

                ServerInteraction si = new ServerInteraction(this);

                List<String> messagesToSend = new ArrayList<String>();


                messagesToSend.add("signup");
                messagesToSend.add(email);
                messagesToSend.add(name);
                messagesToSend.add(phone);
                messagesToSend.add(pass);


                si.sendToServer(messagesToSend);



            }catch (IOException e){
                String title = "Error!";
                String message = "Server Connection seems to be broken. Try again";
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage(message)
                        .setTitle(title).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }




        }



    }


    public static boolean validateMobile(String moblieNumber) {
        boolean check;
        Pattern p;
        Matcher m;
        String MobilePattern = "[0-9]";
        p = Pattern.compile(MobilePattern);

        m = p.matcher(moblieNumber);
        check = m.matches();
        return check;
    }
    public static boolean isFullname(String str) {
        String expression = "^[a-zA-Z\\s]+";
        return str.matches(expression);
    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
