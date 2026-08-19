//Hito 1: Encapsulamiento y Abstracción Base 
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Sensor {


    public enum EstadoSensor {
        ACTIVO, 
        INACTIVO, 
        MANTENIMIENTO,
        FALLA
    }


    private final String id;
    private final String ubicacion;


    private final AtomicReference<EstadoSensor> estado;

    public Sensor(String id, String ubicacion) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El sensor debe tener un ID válido.");
        }
        this.id = id;
        this.ubicacion = ubicacion;
    
        this.estado = new AtomicReference<>(EstadoSensor.INACTIVO); 
    }



    public void encender() {
    
        if (!estado.compareAndSet(EstadoSensor.INACTIVO, EstadoSensor.ACTIVO)) {
            EstadoSensor estadoActual = estado.get();
            if (estadoActual == EstadoSensor.MANTENIMIENTO) {
                throw new IllegalStateException("ALERTA DE SEGURIDAD: No se puede encender un sensor en mantenimiento.");
            } else if (estadoActual == EstadoSensor.FALLA) {
                throw new IllegalStateException("ALERTA DE SEGURIDAD: El sensor reporta una falla y requiere revisión.");
            }
          
        }
    }

    public void apagar() {
     
        estado.compareAndSet(EstadoSensor.ACTIVO, EstadoSensor.INACTIVO);
    }

    public void ponerEnMantenimiento() {
       
        estado.set(EstadoSensor.MANTENIMIENTO);
    }

    public void certificarReparacion() {
        
        if (!estado.compareAndSet(EstadoSensor.MANTENIMIENTO, EstadoSensor.INACTIVO)) {
            throw new IllegalStateException("El sensor no se encontraba en mantenimiento.");
        }
    }

    public void reportarFalla() {
        estado.set(EstadoSensor.FALLA);
    }

    protected abstract Optional<Double> leerHardware();

 
    public final Optional<Double> tomarLectura() {
        if (estado.get() != EstadoSensor.ACTIVO) {
            return Optional.empty(); 
        }
        
        try {
            return leerHardware();
        } catch (Exception e) {
            reportarFalla(); 
            return Optional.empty();
        }
    }

    
    public String evaluarEstado() {
        return "El sensor " + id + " en " + ubicacion + " reporta estado: " + estado.get();
    }

    public String getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public EstadoSensor getEstado() {
        return estado.get();
    }
}
