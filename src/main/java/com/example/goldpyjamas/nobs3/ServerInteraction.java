package com.example.goldpyjamas.nobs3;

import android.content.Context;
import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ServerInteraction {


    Context mContext;

    ServerInteraction(Context c){
        mContext = c;
    }

    public boolean sendToServer(List<String> messages) throws ExecutionException, InterruptedException, IOException {






        class SendMessageToServerTask extends AsyncTask<List<String>, Void, String> {

            Context mContext;

            SendMessageToServerTask(Context c) {

                mContext = c;
            }

            @Override
            protected String doInBackground(List<String>... params) {
                // TODO: attempt authentication against a network service.




                try {
                    Socket socket = SocketHandler.getSocket();


                    if (socket == null) {

                        return "Error";
                    }
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                    for (int i = 0; i<params[0].size(); ++i) {
                        dos.writeUTF( params[0].get(i));
                    }
                    return "0";
                } catch (IOException e) {
                    e.printStackTrace();


                    return "Error";
                }



            }

            @Override
            protected void onPostExecute(final String status) {


            }

            @Override
            protected void onCancelled() {


            }
        }


        SendMessageToServerTask sendMessageToServerTask  = new SendMessageToServerTask(mContext);
        String status = sendMessageToServerTask.execute(messages).get();

        if (!status.equals("0")){
            return false;
        }
        return true;






    }


}
