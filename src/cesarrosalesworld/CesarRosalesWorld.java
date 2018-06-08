package cesarrosalesworld;

import Edificaciones.DirectorEdificacion;
import Edificaciones.Edificacion;
import Milicia.DirectorMilicia;
import Milicia.Milicia;
import Recursos.DirectorRecurso;
import Recursos.Recurso;
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
        DirectorEdificacion directorE = new DirectorEdificacion();
        DirectorRecurso directorR = new DirectorRecurso();
        DirectorMilicia directorM = new DirectorMilicia();
        Vehiculo v1 = directorV.getVehiculo("Tanque", 100, 13, 75, 35, 69);
        Edificacion e1 = directorE.getEdificacion("Centro de Mando", 1000, 0, 0, 0, 0);
        Recurso r1 = directorR.getRecurso("1", 1000, 1);
        Milicia m1 = directorM.getMilicia("Soldado", 150, 20, 13, 50, 25, 7);
        Milicia m2 = directorM.getMilicia("Boki", 330, 25, 15, 100, 75,43,8);
        System.out.println(v1.toString());
        System.out.println(e1.toString());
        System.out.println(r1.toString());
        System.out.println(m1.toString());
        System.out.println(m2.toString());
    }

}
