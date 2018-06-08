package Milicia;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Milicia {

    private String tipo;
    private int vida;
    private int danioEdificacion;
    private int danioEnemigos;
    private int costoR1;
    private int costoR2;
    private int faseCreacion;
    private int costoR3;

    public Milicia() {
    }

    private Milicia(Builder b) {
        this.tipo = b.tipo;
        this.vida = b.vida;
        this.danioEdificacion = b.danioEdificacion;
        this.danioEnemigos = b.danioEnemigos;
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

    public int getDanioEdificacion() {
        return danioEdificacion;
    }

    public int getDanioEnemigos() {
        return danioEnemigos;
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
        private int danioEdificacion;
        private int danioEnemigos;
        private int costoR1;
        private int costoR2;
        private int faseCreacion;
        private int costoR3;

        public Builder(String tipo, int vida, int danioEdificacion, int danioEnemigos, int costoR1, int costoR2, int faseCreacion) {
            this.tipo = tipo;
            this.vida = vida;
            this.danioEdificacion = danioEdificacion;
            this.danioEnemigos = danioEnemigos;
            this.costoR1 = costoR1;
            this.costoR2 = costoR2;
            this.faseCreacion = faseCreacion;
        }

        public Builder costoRecurso3(int costoR3) {
            this.costoR3 = costoR3;
            return this;
        }

        public Milicia build() {
            return new Milicia(this);
        }
    }

    @Override
    public String toString() {
        return "Milicia{"
                + "tipo='" + tipo + '\''
                + ", vida='" + vida + '\''
                + ", danioEdificacion='" + danioEdificacion + '\''
                + ", danioEnemigos='" + danioEnemigos + '\''
                + ", costoR1='" + costoR1 + '\''
                + ", costoR2='" + costoR2 + '\''
                + ", costoR3='" + costoR3 + '\''
                + ", faseCreacion='" + faseCreacion + '\''             
                + '}';
    }

}
