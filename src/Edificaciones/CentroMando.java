package Edificaciones;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class CentroMando {

    private int vida;
    private int nivel;
    private int cantR1;
    private int cantR2;
    private int cantR3;
    private int maxR1;
    private int maxR2;
    private int maxR3;

    public CentroMando() {
    }

    private CentroMando(Builder b) {
        this.vida = b.vida;
        this.nivel = b.nivel;
        this.cantR1 = b.cantR1;
        this.cantR2 = b.cantR2;
        this.cantR3 = b.cantR3;
        this.maxR1 = b.maxR1;
        this.maxR2 = b.maxR2;
        this.maxR3 = b.maxR3;
    }

    public int getNivel() {
        return nivel;
    }

    public int getCantR1() {
        return cantR1;
    }

    public int getCantR2() {
        return cantR2;
    }

    public int getCantR3() {
        return cantR3;
    }

    public int getMaxR1() {
        return maxR1;
    }

    public int getMaxR2() {
        return maxR2;
    }

    public int getMaxR3() {
        return maxR3;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setCantR1(int cantR1) {
        this.cantR1 = cantR1;
    }

    public void setCantR2(int cantR2) {
        this.cantR2 = cantR2;
    }

    public void setCantR3(int cantR3) {
        this.cantR3 = cantR3;
    }

    public void setMaxR1(int maxR1) {
        this.maxR1 = maxR1;
    }

    public void setMaxR2(int maxR2) {
        this.maxR2 = maxR2;
    }

    public void setMaxR3(int maxR3) {
        this.maxR3 = maxR3;
    }

    public static class Builder {

        private int vida;
        private int nivel;
        private int cantR1;
        private int cantR2;
        private int cantR3;
        private int maxR1;
        private int maxR2;
        private int maxR3;

        public Builder(int vida, int nivel, int cantR1, int cantR2, int cantR3, int maxR1, int maxR2, int maxR3) {
            this.vida = vida;
            this.nivel = nivel;
            this.cantR1 = cantR1;
            this.cantR2 = cantR2;
            this.cantR3 = cantR3;
            this.maxR1 = maxR1;
            this.maxR2 = maxR2;
            this.maxR3 = maxR3;
        }

        public CentroMando build() {
            return new CentroMando(this);
        }
    }

    @Override
    public String toString() {
                return "CentroMando{"
                + "vida='" + vida + '\''
                + ", nivel='" + nivel + '\''
                + ", cantR1='" + cantR1 + '\''
                + ", cantR2='" + cantR2 + '\''
                + ", cantR3='" + cantR3 + '\''
                + ", maxR1='" + maxR1 + '\''
                + ", maxR2='" + maxR2 + '\''
                + ", maxR3='" + maxR3 + '\''
                + '}';
    }
    
}
