package com.example.goldpyjamas.nobs3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PromptServerIP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt_server_ip);
        TextView lblServerIPView = findViewById(R.id.lblServerIP);

        lblServerIPView.setText(MainActivity.getServerIP());
    }

    public void btnchangeServerIP(View view) {

        TextView serverIP = findViewById(R.id.txtServerIP);

        if (!MainActivity.changeServerIP(serverIP.getText().toString())) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("IP Address is not in the correct format")
                    .setTitle("Alert").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // FIRE ZE MISSILES!
                }
            });
            alertDialogBuilder.create();
            alertDialogBuilder.show();
        }else{
            TextView lblServerIPView = findViewById(R.id.lblServerIP);
            lblServerIPView.setText(lblServerIPView.getText().toString());
            finish();
        }


    }
}
