package com.example.erosa.puppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class PetListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    //private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.pet_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new PetAdapter(fakeData()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_favorite:
            startActivity(new Intent(this, FavoriteListActivity.class));
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Mascota> fakeData(){
        ArrayList<Mascota> list = new ArrayList<Mascota>();
        list.add(new Mascota("Gato", R.drawable.image_cat, 3, false));
        list.add(new Mascota("Mono", R.drawable.image_monkey, 6, false));
        list.add(new Mascota("Leon", R.drawable.image_lion, 20, false));
        list.add(new Mascota("Delfin", R.drawable.image_dolphin, 9, false));
        list.add(new Mascota("Ratón", R.drawable.image_rat, 5, false));
        list.add(new Mascota("Loro", R.drawable.image_loro, 12, false));
        list.add(new Mascota("Perro", R.drawable.image_dog, 0, false));
        list.add(new Mascota("Conejo", R.drawable.image_rabbit, 14, false));
        return list;
    }
}
