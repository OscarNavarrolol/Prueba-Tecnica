package com.prueba.repositorio;

import com.prueba.entidad.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
    List<Empleado> findByRolId(Long rolId);
}