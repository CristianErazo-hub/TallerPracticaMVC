package com.taller.controller;

import com.taller.modelo.Docente;
import com.taller.service.DocenteService;

import java.util.List;

public class DocenteController {

    private DocenteService service;

    public DocenteController(DocenteService service) {
        this.service = service;
    }

    public void crear(String nombre, String especialidad) {
        Docente docente = new Docente(0, nombre, especialidad);
        service.crearDocente(docente);
    }

    public List<Docente> listar() {
        return service.listar();
    }
}