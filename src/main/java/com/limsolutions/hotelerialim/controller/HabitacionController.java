import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.limsolutions.hotelerialim.service.IHabitacionService;

import java.util.List;
import java.util.Map;


	public Habitacion agregarHabitacion(@RequestBody Habitacion habitacion) {
    }

    @GetMapping("/habitaciones/{id_habitacion}")
    public ResponseEntity<Habitacion> buscarHabitacion(@PathVariable Long id_habitacion) {
        Habitacion habitacion = IHabitacionService.buscarHabitacion(id_habitacion);

        return ResponseEntity.ok(habitacion);
    }

    @PutMapping("/habitaciones/{id_habitacion}")
    public ResponseEntity<Habitacion> editarHabitacion(@PathVariable Long id_habitacion,
            @RequestBody Habitacion habitacionRecibido) {
        Habitacion habitacion = IHabitacionService.buscarHabitacion(id_habitacion);

        habitacion.setTipo(habitacionRecibido.getTipo());
        habitacion.setPrecio(habitacionRecibido.getPrecio());
        habitacion.setNumero(habitacionRecibido.getNumero());
    }

    @DeleteMapping("/habitaciones/{id_habitacion}")
    public ResponseEntity<Map<String, Boolean>> eliminarHabitacion(@PathVariable Long id_habitacion) {
        Habitacion habitacion = IHabitacionService.buscarHabitacion(id_habitacion);

        if (habitacion == null) {
            // Habitación no encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Eliminado", false));
        }

        IHabitacionService.eliminarHabitacion(habitacion);

        // Habitación eliminada con éxito
        return ResponseEntity.ok(Map.of("Eliminado", true));
    }
    