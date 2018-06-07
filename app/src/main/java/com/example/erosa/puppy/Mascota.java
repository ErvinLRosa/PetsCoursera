package com.example.erosa.puppy;

public class Mascota {
    private String nombre;
    private int imagen;
    private int raiting;
    private boolean favorito;

    public Mascota(String nombre, int imagen, int raiting, boolean favorito) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.raiting = raiting;
        this.favorito = favorito;
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
}
