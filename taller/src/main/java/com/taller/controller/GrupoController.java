package com.taller.controller;

import com.taller.modelo.Grupo;
import com.taller.service.GrupoService;

import java.util.List;

public class GrupoController {

    private GrupoService service;

    public GrupoController(GrupoService service) {
        this.service = service;
    }

    public void crear(int idMateria, int idDocente, String aula, String horario) {
        Grupo grupo = new Grupo(0, idMateria, idDocente, aula, horario);
        service.crearGrupo(grupo);
    }

    public List<Grupo> listar() {
        return service.listar();
    }
}