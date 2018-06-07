package com.example.erosa.puppy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class FavoriteListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.favorite_pet_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new PetAdapter(fakeFavoriteData()));
    }
    public ArrayList<Mascota> fakeFavoriteData(){
        ArrayList<Mascota> list = new ArrayList<Mascota>();
        list.add(new Mascota("Leon", R.drawable.image_lion, 20, false));
        list.add(new Mascota("Delfin", R.drawable.image_dolphin, 9, false));
        list.add(new Mascota("Ratón", R.drawable.image_rat, 5, false));
        list.add(new Mascota("Gato", R.drawable.image_cat, 3, false));
        list.add(new Mascota("Conejo", R.drawable.image_rabbit, 14, false));
        return list;
    }
}
