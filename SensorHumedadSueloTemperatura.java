import java.util.OptionalDouble;

public interface AdaptadorHardware {
    
    OptionalDouble leer() throws FallaHardwareSensorException;
}
import java.util.OptionalDouble;
//CLASE SensorHumedadSuelo
public class SensorTemperatura extends Sensor {

  
    private final AdaptadorHardware adaptador;


    public SensorTemperatura(String id, String ubicacion, AdaptadorHardware adaptador) {
        super(id, ubicacion);
        if (adaptador == null) {
            throw new IllegalArgumentException("El adaptador de hardware es obligatorio.");
        }
        this.adaptador = adaptador;
    }

    @Override
    protected OptionalDouble leerHardware() throws FallaHardwareSensorException {
     
        return adaptador.leer();
    }
}
import java.util.OptionalDouble;
//CLASE  SensorTemperatura 
public class SensorHumedadSuelo extends Sensor {

    private final AdaptadorHardware adaptador;

    public SensorHumedadSuelo(String id, String ubicacion, AdaptadorHardware adaptador) {
        super(id, ubicacion);
        if (adaptador == null) {
            throw new IllegalArgumentException("El adaptador de hardware es obligatorio.");
        }
        this.adaptador = adaptador;
    }

    @Override
    protected OptionalDouble leerHardware() throws FallaHardwareSensorException {
        return adaptador.leer();
    }
}
