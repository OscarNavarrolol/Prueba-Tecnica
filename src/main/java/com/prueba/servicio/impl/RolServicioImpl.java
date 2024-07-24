package com.prueba.servicio.impl;

import com.prueba.entidad.Rol;
import com.prueba.repositorio.RolRepositorio;
import com.prueba.servicio.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServicioImpl implements RolServicio {
    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public List<Rol> conseguirTodosRol() {
        return rolRepositorio.findAll();
    }
}
