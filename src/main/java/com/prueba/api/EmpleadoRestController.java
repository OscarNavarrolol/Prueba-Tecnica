package com.prueba.api;

import com.prueba.entidad.Empleado;
import com.prueba.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoServicio.guardar(empleado);
    }

    @GetMapping("/rol")
    public List<Empleado> obtenerEmpleadosPorRol(@RequestParam(required = false) Long rolId) {
        return empleadoServicio.obtenerPorRol(rolId);
    }

    @GetMapping("/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable Long id) {
        return empleadoServicio.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoServicio.actualizar(id, empleado);
    }

    @GetMapping("/{id}/salario-hora-extra")
    public Double calcSalarioConHorasExtra(@PathVariable Long id, @RequestParam int horasExtraDiurnas, @RequestParam int horasExtraNocturnas, @RequestParam int horasExtraFestivas) {
        return empleadoServicio.calcSalarioConHorasExtra(id, horasExtraDiurnas, horasExtraNocturnas, horasExtraFestivas);
    }

    @GetMapping("/rol/{rolId}/promedio-salario")
    public Double calcPromedioSalarioPorRol(@PathVariable Long rolId) {
        return empleadoServicio.calcPromedioSalarioPorRol(rolId);
    }

}

