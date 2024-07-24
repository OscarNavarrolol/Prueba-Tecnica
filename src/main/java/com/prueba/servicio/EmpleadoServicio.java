package com.prueba.servicio;

import com.prueba.entidad.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoServicio {
    public Empleado guardar(Empleado empleado);

    public List<Empleado> obtenerPorRol(Long rolId);

    public Empleado obtenerPorId(Long id);

    public Empleado actualizar(Long id, Empleado detallesEmpleado);

    public Double calcSalarioConHorasExtra(Long id, int horasExtraDiurnas, int horasExtraNocturnas, int horasExtraFestivas);

    public Double calcPromedioSalarioPorRol(Long rolId);
}
