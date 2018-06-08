package Recursos;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class DirectorRecurso {
    public Recurso getRecurso(String tipo, int cantidad, int faseRecoleccion) {
        return new Recurso.Builder(tipo, cantidad, faseRecoleccion).build();
    }
}
