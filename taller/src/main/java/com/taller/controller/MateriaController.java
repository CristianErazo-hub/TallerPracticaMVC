package com.taller.controller;

import com.taller.modelo.Materia;
import com.taller.service.MateriaService;

import java.util.List;

public class MateriaController {

    private MateriaService service;

    public MateriaController(MateriaService service) {
        this.service = service;
    }

    public void crear(String nombre, int creditos) {
        Materia materia = new Materia(0, nombre, creditos);
        service.crearMateria(materia);
    }

    public List<Materia> listar() {
        return service.listar();
    }
}