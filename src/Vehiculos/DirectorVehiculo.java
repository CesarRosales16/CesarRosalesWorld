package Vehiculos;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class DirectorVehiculo {

    public Vehiculo getVehiculo(String tipo, int vida, int danio, int costoR1, int costoR2, int faseCreacion) {
        return new Vehiculo.Builder(tipo, vida, danio, costoR1, costoR2).faseCreacion(faseCreacion).build();
    }

    public Vehiculo getVehiculo(String tipo, int vida, int danio, int costoR1, int costoR2, int costoR3, int faseCreacion) {
        return new Vehiculo.Builder(tipo, vida, danio, costoR1, costoR2).faseCreacion(faseCreacion).costoR3(costoR3).build();
    }
    public Vehiculo getVehiculo(String tipo, int vida, int danio, int costoR1, int costoR2, int costoR3, int faseCreacion, int tiempoEspera) {
        return new Vehiculo.Builder(tipo, vida, danio, costoR1, costoR2).faseCreacion(faseCreacion).costoR3(costoR3).tiempoEspera(tiempoEspera).build();
    }
}
