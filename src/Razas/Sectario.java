package Razas;

import Edificaciones.CentroMando;
import Edificaciones.DirectorEdificacion;
import Edificaciones.Edificacion;
import Milicia.Milicia;
import Recursos.Recurso;
import Vehiculos.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Sectario implements Raza {

    CentroMando cm;
    ArrayList<Edificacion> edificaciones;
    Milicia[] milicia;
    Vehiculo[] vehiculos;
    Recurso[] recursos;

    @Override
    public void crear() {
        cm = new CentroMando.Builder(1060, 1, 750, 750, 500, 10000, 5000, 3000).build();
        System.out.println("\nInformación de la raza Sectarios: \nEdificaciones disponibles:");
        System.out.println(cm.toString());
    }

    @Override
    public void construirEdificacion() {
        DirectorEdificacion directorE = new DirectorEdificacion();
//        Edificacion e1 = directorE.getEdificacion("Generador de oro", 1000, 0, 0, 0, 0);
        Edificacion e1 = new Edificacion.Builder("Generador de oro", 0, 0, 0).faseCreacion(5).build();
        edificaciones = new ArrayList<>();
        edificaciones.add(e1);
    }

    @Override
    public int getVidaCentroMando() {
        return cm.getVida();
    }

    @Override
    public void mostrarEdificaciones() {
        for (Edificacion e : edificaciones) {
            System.out.println(e.toString());
        }
    }
}
