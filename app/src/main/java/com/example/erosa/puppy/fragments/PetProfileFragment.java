package com.example.erosa.puppy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.erosa.puppy.R;
import com.example.erosa.puppy.adapters.PetProfileAdapter;
import com.example.erosa.puppy.model.Mascota;

import java.util.ArrayList;

public class PetProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pet_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Mascota miMascota = initProfileData();
        ((ImageView)view.findViewById(R.id.iv_perfil_masctoa)).setImageResource(R.drawable.gato_1);
        ((TextView)view.findViewById(R.id.tv_nombre_mascota)).setText(miMascota.getNombre());
        RecyclerView rvFotos = view.findViewById(R.id.rv_fotos_mascota);
        rvFotos.setLayoutManager(new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false));
        rvFotos.setAdapter(new PetProfileAdapter(miMascota));
    }
    public Mascota initProfileData(){
        Mascota miMascota = new Mascota("Mufasa", R.drawable.gato_1, 20, true);
        miMascota.addToGaleria(R.drawable.gato_2);
        miMascota.addToGaleria(R.drawable.gato_3);
        miMascota.addToGaleria(R.drawable.gato_4);
        miMascota.addToGaleria(R.drawable.gato_5);
        return miMascota;
    }
}
