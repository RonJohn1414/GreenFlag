package com.example.firstassignmentgreenflag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerPage extends AppCompatActivity {

    CustomAdapter adapter;
    Intent intent;
    private List<User> dataset;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_recycler_page);

        recyclerView = findViewById (R.id.recycler_view);
        dataset = new ArrayList<> ();
        intent = getIntent ();
        User user = intent.getParcelableExtra ("User");
        dataset.add (user);
        adapter = new CustomAdapter ();
        adapter.setDataSet (dataset);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager (linearLayoutManager);
        recyclerView.setAdapter (adapter);


    }
}
