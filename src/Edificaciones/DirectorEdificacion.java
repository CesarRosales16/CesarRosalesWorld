/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificaciones;

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
}
