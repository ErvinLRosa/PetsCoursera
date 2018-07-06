package com.example.erosa.puppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.erosa.puppy.adapters.PetAdapter;

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
            case R.id.item_contact:
                startActivity(new Intent(this, ContactActivity.class));
                break;
            case R.id.item_acercade:
                startActivity(new Intent(this, AcercaDeActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
