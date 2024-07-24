package com.prueba.servicio.impl;

import com.prueba.entidad.Empleado;
import com.prueba.repositorio.EmpleadoRepositorio;
import com.prueba.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public Empleado guardar(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public List<Empleado> obtenerPorRol(Long rolId) {
        if (rolId == null) {
            return empleadoRepositorio.findAll();
        } else {
            return empleadoRepositorio.findByRolId(rolId);
        }
    }

    @Override
    public Empleado obtenerPorId(Long id) {
        return empleadoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Empleado actualizar(Long id, Empleado detallesEmpleado) {
        Empleado empleado = obtenerPorId(id);
        if (empleado != null) {
            empleado.setNombre(detallesEmpleado.getNombre());
            empleado.setEmail(detallesEmpleado.getEmail());
            empleado.setPuesto(detallesEmpleado.getPuesto());
            empleado.setSalarioBase(detallesEmpleado.getSalarioBase());
            empleado.setRol(detallesEmpleado.getRol());
            return empleadoRepositorio.save(empleado);
        }
        return null;
    }

    @Override
    public Double calcSalarioConHorasExtra(Long id, int horasExtraDiurnas, int horasExtraNocturnas, int horasExtraFestivas) {
        Optional<Empleado> optionalEmpleado = empleadoRepositorio.findById(id);
        if (optionalEmpleado.isPresent()) {
            Empleado empleado = optionalEmpleado.get();
            double salarioBasePorHora = empleado.getSalarioBase() / 160;
            double salarioTotal = empleado.getSalarioBase() +
                    (horasExtraDiurnas * salarioBasePorHora * 1.25) +
                    (horasExtraNocturnas * salarioBasePorHora * 1.5) +
                    (horasExtraFestivas * salarioBasePorHora * 1.75);
            return salarioTotal;
        }
        return null;
    }

    @Override
    public Double calcPromedioSalarioPorRol(Long rolId) {
        List<Empleado> empleados = empleadoRepositorio.findByRolId(rolId);
        if (empleados.isEmpty()) {
            return 0.0;
        }
        double sumaSalarios = empleados.stream().mapToDouble(Empleado::getSalarioBase).sum();
        return sumaSalarios / empleados.size();
    }

}