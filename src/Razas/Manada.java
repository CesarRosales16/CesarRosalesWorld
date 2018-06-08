package Razas;

import Edificaciones.CentroMando;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Manada implements Raza {

    @Override
    public void crear() {
        CentroMando cm = new CentroMando.Builder(1000, 1, 750, 750, 500, 10000, 5000, 3000).build();
        System.out.println("\nInformación de la raza Manada: \nEdificaciones disponibles:");
        System.out.println(cm.toString());
    }
}
