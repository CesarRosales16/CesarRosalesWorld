package Vehiculos;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Vehiculo {

    private String tipo;
    private int vida;
    private int danio;
    private int costoR1;
    private int costoR2;
    private int faseCreacion;
    private int costoR3;

    public Vehiculo() {
    }

    private Vehiculo(Builder b) {
        this.tipo = b.tipo;
        this.vida = b.vida;
        this.danio = b.danio;
        this.costoR1 = b.costoR1;
        this.costoR2 = b.costoR2;
        this.faseCreacion = b.faseCreacion;
        this.costoR3 = b.costoR3;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getDanio() {
        return danio;
    }
    public int getCostoR1() {
        return costoR1;
    }

    public int getCostoR2() {
        return costoR2;
    }

    public int getFaseCreacion() {
        return faseCreacion;
    }


    public int getCostoR3() {
        return costoR3;
    }

    public static class Builder {

        private String tipo;
        private int vida;
        private int danio;
        private int costoR1;
        private int costoR2;
        private int faseCreacion;
        private int costoR3;

        public Builder(String tipo, int vida, int danio, int costoR1, int costoR2) {
            this.tipo = tipo;
            this.vida = vida;
            this.danio = danio;
            this.costoR1 = costoR1;
            this.costoR2 = costoR2;
        }

        public Builder faseCreacion(int faseCreacion) {
            this.faseCreacion = faseCreacion;
            return this;
        }
        
        public Builder costoR3(int costoR3) {
            this.costoR3 = costoR3;
            return this;
        }

        public Vehiculo build() {
            return new Vehiculo(this);
        }
    }

    @Override
    public String toString() {
        return "Vehiculo{"
                + "tipo='" + tipo + '\''
                + ", vida='" + vida + '\''
                + ", daño='" + danio + '\''
                + ", fase de creacion='" + faseCreacion + '\''
                + ", costo recurso 1='" + costoR1 + '\''
                + ", costo recurso 2='" + costoR2 + '\''
                + ", costo recurso 3='" + costoR3 + '\''
                + '}';
    }
}
