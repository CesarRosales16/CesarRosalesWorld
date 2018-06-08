package Vehiculos;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class DirectorVehiculo {

    public Vehiculo getVehiculo(String tipo, int vida, int danio, int costoR1, int costoR2) {
        return new Vehiculo.Builder(tipo, vida, danio, costoR1, costoR2).build();
    }
}
