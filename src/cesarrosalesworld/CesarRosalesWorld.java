package cesarrosalesworld;

import Vehiculos.DirectorVehiculo;
import Vehiculos.Vehiculo;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class CesarRosalesWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DirectorVehiculo directorV = new DirectorVehiculo();
        Vehiculo v1 = directorV.getVehiculo("Tanqueta", 100, 13, 104, 75);
        System.out.println(v1.toString());
    }

}
