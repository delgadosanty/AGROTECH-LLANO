import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.OptionalDouble;

public class EstacionMonitoreo {

    private final List<Sensor> sensores;

    public EstacionMonitoreo() {
 
        this.sensores = new CopyOnWriteArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        if (sensor == null) {
            throw new IllegalArgumentException("Violación de contrato: No se puede registrar un sensor nulo.");
        }
        this.sensores.add(sensor);
    }
    
    public void removerSensor(Sensor sensor) {
        this.sensores.remove(sensor);
    }

  
    public void procesarLecturas() {
        System.out.println("--- INICIANDO CICLO DE TELEMETRÍA ---");

        for (Sensor sensor : sensores) {
          
            OptionalDouble lectura = sensor.tomarLectura();

          
            if (lectura.isPresent()) {
                System.out.printf("[EXITO] Sensor ID: %s | Ubicación: %s | Lectura: %.2f%n", 
                    sensor.getId(), 
                    sensor.getUbicacion(), 
                    lectura.getAsDouble());
            } else {
               
                System.out.printf("[OMITIDO] Sensor ID: %s | Ubicación: %s | Causa: Equipo en estado %s%n", 
                    sensor.getId(), 
                    sensor.getUbicacion(), 
                    sensor.getEstado().name());
            }
        }
        
        System.out.println("--- CICLO DE TELEMETRÍA FINALIZADO ---\n");
    }
}
