package com.taller.modelo;

public class Materia {

    private int id;
    private String nombreMateria;
    private int creditos;

    public Materia() {
    }

    public Materia(int id, String nombreMateria, int creditos) {

        this.id = id;
        this.nombreMateria = nombreMateria;
        this.creditos = creditos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getCreditos() {
        return creditos;
    }

    public void SetCreditos(int creditos) {
        this.creditos = creditos;
    }
}