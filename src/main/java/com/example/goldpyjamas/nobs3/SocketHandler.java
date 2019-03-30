package com.example.goldpyjamas.nobs3;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHandler {
    private static Socket socket;
    private static boolean alreadyCreated = false;
    private static boolean isCreatedNow = false;
    public static boolean isCreated(){
        return isCreatedNow;
    }

    private static void createSocket() throws IOException {

        socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(MainActivity.getServerIP(), 8888 ), 2000 );
            alreadyCreated = true;
        } catch (IOException e) {
            e.printStackTrace();

        }



    }



    public static synchronized Socket getSocket() throws IOException {

        if (!alreadyCreated || socket.isClosed()) {
            createSocket();
        }

        if (alreadyCreated){
//            try{
////                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
////                dos.writeUTF("0000");
//            }catch (IOException e){
//                createSocket();
//            }

        }


        return socket;

    }
}