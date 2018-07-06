package com.example.erosa.puppy.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.erosa.puppy.model.Mascota;
import com.example.erosa.puppy.R;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{
    private ArrayList<Mascota> mList;

    public PetAdapter(ArrayList<Mascota> mList) {
        this.mList = mList;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PetViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false));
    }

    @Override
    public void onBindViewHolder(PetViewHolder holder, int position) {
        holder.getPetName().setText(mList.get(position).getNombre());
        holder.getPetRating().setText(String.valueOf(mList.get(position).getRaiting()));
        holder.getPetImage().setImageResource(mList.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class PetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView petImage, btnHueso;
        private TextView petName, petRating;
        public PetViewHolder(View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.iv_mascota);
            petName = itemView.findViewById(R.id.tv_nombre_mascota);
            petRating = itemView.findViewById(R.id.tv_raiting);
            btnHueso = itemView.findViewById(R.id.iv_hueso);
            btnHueso.setOnClickListener(this);
        }

        public ImageView getPetImage() {
            return petImage;
        }

        public TextView getPetName() {
            return petName;
        }

        public TextView getPetRating() {
            return petRating;
        }

        public ImageView getBtnHueso() {
            return btnHueso;
        }

        @Override
        public void onClick(View view) {
            Snackbar.make(this.itemView, mList.get(getAdapterPosition()).getNombre() + ": Para agregar proximamente a favoritos", Snackbar.LENGTH_SHORT).show();
        }
    }
}
