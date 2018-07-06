package com.example.erosa.puppy.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.erosa.puppy.R;
import com.example.erosa.puppy.model.Mascota;

import java.util.ArrayList;
import java.util.Random;

public class PetProfileAdapter extends RecyclerView.Adapter<PetProfileAdapter.PetProfileViewHolder>{
    private Mascota mMascota;

    public PetProfileAdapter(Mascota mMascota) {
        this.mMascota = mMascota;
    }

    @Override
    public PetProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PetProfileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false));
    }

    @Override
    public void onBindViewHolder(PetProfileViewHolder holder, int position) {
        holder.getPetRating().setText(String.valueOf(new Random().nextInt(20)));
        holder.getPetImage().setImageResource(mMascota.getGaleriaImagenes().get(position));
    }

    @Override
    public int getItemCount() {
        return mMascota.getGaleriaImagenes().size();
    }

    class PetProfileViewHolder extends RecyclerView.ViewHolder {
        private ImageView petImage;
        private TextView petRating;
        public PetProfileViewHolder(View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.iv_mascota);
            petRating = itemView.findViewById(R.id.tv_raiting);
        }

        public ImageView getPetImage() {
            return petImage;
        }


        public TextView getPetRating() {
            return petRating;
        }



    }
}