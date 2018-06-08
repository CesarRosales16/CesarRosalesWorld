package Milicia;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class DirectorMilicia {
    public Milicia getMilicia(String tipo, int vida, int danioEdificacion, int danioEnemigos, int costoR1, int costoR2, int faseCreacion) {
        return new Milicia.Builder(tipo, vida, danioEdificacion, danioEnemigos, costoR1, costoR2, faseCreacion).build();
    }
    public Milicia getMilicia(String tipo, int vida, int danioEdificacion, int danioEnemigos, int costoR1, int costoR2, int costoR3, int faseCreacion) {
        return new Milicia.Builder(tipo, vida, danioEdificacion, danioEnemigos, costoR1, costoR2, faseCreacion).costoRecurso3(costoR3).build();
    }
}
