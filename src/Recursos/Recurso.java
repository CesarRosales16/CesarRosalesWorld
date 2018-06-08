package Recursos;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Recurso {

    private String tipo;
    private int cantidad;
    private int faseRecoleccion;

    public Recurso() {
    }

    private Recurso(Builder b) {
        this.tipo = b.tipo;
        this.cantidad = b.cantidad;
        this.faseRecoleccion = b.faseRecoleccion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getFaseRecoleccion() {
        return faseRecoleccion;
    }

    public static class Builder {

        private String tipo;
        private int cantidad;
        private int faseRecoleccion;

        public Builder(String tipo, int cantidad, int faseRecoleccion) {
            this.tipo = tipo;
            this.cantidad = cantidad;
            this.faseRecoleccion = faseRecoleccion;
        }

        public Recurso build() {
            return new Recurso(this);
        }
    }

    @Override
    public String toString() {
        return "Recurso{"
                + "tipo='" + tipo + '\''
                + ", cantidad='" + cantidad + '\''
                + ", fase de fase de recoleccion='" + faseRecoleccion + '\''
                + '}';
    }
}
