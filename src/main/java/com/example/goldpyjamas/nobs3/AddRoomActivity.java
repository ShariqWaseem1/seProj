package com.example.goldpyjamas.nobs3;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AddRoomActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);



        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        layoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
// specify an adapter (see also next example)

        String [] dataSet = {"13", "42"};
        mAdapter = new MyAdapter(dataSet);

        recyclerView.setAdapter(mAdapter);


    }

}
