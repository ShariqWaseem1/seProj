package com.example.goldpyjamas.nobs3;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.Socket;

class GetSocketTask extends AsyncTask<Void, Void, Socket> {

    Context mContext;

    GetSocketTask(Context c) {

        mContext = c;
    }

    @Override
    protected Socket doInBackground(Void... params) {
        // TODO: attempt authentication against a network service.

        try {
            Socket socket = SocketHandler.getSocket();

            if (socket != null){
                return socket;
            }
            return null;



        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }



    }

    @Override
    protected void onPostExecute(final Socket status) {


    }

    @Override
    protected void onCancelled() {


    }
}