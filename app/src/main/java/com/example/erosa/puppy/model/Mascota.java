package com.example.erosa.puppy.model;

import android.support.annotation.DrawableRes;

import com.example.erosa.puppy.R;

import java.util.ArrayList;

public class Mascota {
    private String nombre;
    private int raiting;
    private boolean favorito;
    @DrawableRes
    private int imagen;
    private ArrayList<Integer> galeriaImagenes;

    public Mascota(String nombre, @DrawableRes int imagen, int raiting, boolean favorito) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.raiting = raiting;
        this.favorito = favorito;
        this.galeriaImagenes = new ArrayList<>();
    }

    public static ArrayList<Mascota> fakeData(){
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public ArrayList<Integer> getGaleriaImagenes() {
        return galeriaImagenes;
    }

    public void addToGaleria(@DrawableRes int imagen) {
        this.galeriaImagenes.add(imagen);
    }
}
