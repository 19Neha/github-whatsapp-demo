package com.example.android.whatsappmdc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class NewGroupActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    AppUtility appUtility;
    RecyclerViewNewGroupAdapter recycleViewAdapter;
    View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        recyclerView = findViewById(R.id.recycler_view_new_group);

        appUtility = AppUtility.getAppUtility(this);

        recycleViewAdapter = new RecyclerViewNewGroupAdapter(this, appUtility.getPeople());
      //  LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,true);
        recyclerView.setLayoutManager(gridLayoutManager);

        //recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(recycleViewAdapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

    }
}
