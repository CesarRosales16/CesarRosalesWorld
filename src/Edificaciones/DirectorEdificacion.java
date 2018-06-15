package Edificaciones;

import java.util.ArrayList;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class DirectorEdificacion {

    public Edificacion getEdificacion(String tipo, int vida, int costoR1, int costoR2, int faseCreacion) {
        return new Edificacion.Builder(tipo, vida, costoR1, costoR2).faseCreacion(faseCreacion).build();
    }
    public Edificacion getEdificacion(String tipo, int vida, int costoR1, int costoR2, int costoR3, int faseCreacion) {
        return new Edificacion.Builder(tipo, vida, costoR1, costoR2).faseCreacion(faseCreacion).costoR3(costoR3).build();
    }
    public Edificacion getEdificacion(String tipo, int vida, int costoR1, int costoR2, int costoR3, int faseCreacion, ArrayList<Object> el) {
        return new Edificacion.Builder(tipo, vida, costoR1, costoR2).faseCreacion(faseCreacion).costoR3(costoR3).ArrayList(el).build();
    }
    public Edificacion getEdificacion(String tipo, int vida, int costoR1, int costoR2, int costoR3, int faseCreacion, ArrayList<Object> el,int tiempoEspera) {
        return new Edificacion.Builder(tipo, vida, costoR1, costoR2).faseCreacion(faseCreacion).costoR3(costoR3).ArrayList(el).tiempoEspera(tiempoEspera).build();
    }
}
