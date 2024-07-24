## Prueba Técnica: Aplicación CRUD con Spring Boot

- Se desarrolló un CRUD para gestionar empleados usando Spring Boot.
- Se implementaron endpoints REST para manejar las operaciones requeridas

### Crear Empleado
- **Método**: `POST`
- **Ruta**: `/empleados`
- **Cuerpo**: Empleado en formato JSON

### Obtener Empleados por Rol
- **Método**: `GET`
- **Ruta**: `/empleados/rol`
- **Parámetro Opcional**: `rolId`

### Obtener Empleado por ID
- **Método**: `GET`
- **Ruta**: `/empleados/{id}`

### Actualizar Empleado
- **Método**: `PUT`
- **Ruta**: `/empleados/{id}`
- **Cuerpo**: Empleado en formato JSON

### Calcular Salario con Horas Extra
- **Método**: `GET`
- **Ruta**: `/empleados/{id}/salario-hora-extra`
- **Parámetros**: `horasExtraDiurnas`, `horasExtraNocturnas`, `horasExtraFestivas`

### Calcular Promedio de Salario por Rol
- **Método**: `GET`
- **Ruta**: `/empleados/rol/{rolId}/promedio-salario`
