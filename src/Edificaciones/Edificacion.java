package Edificaciones;

import java.util.ArrayList;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Edificacion {

    private String tipo;
    private int vida;
    private int costoR1;
    private int costoR2;
    private int faseCreacion;
    private int costoR3;
    private ArrayList<Object> ArrayList;
    private int tiempoEspera;

    public Edificacion() {
    }

    private Edificacion(Builder b) {
        this.tipo = b.tipo;
        this.vida = b.vida;
        this.costoR1 = b.costoR1;
        this.costoR2 = b.costoR2;
        this.faseCreacion = b.faseCreacion;
        this.costoR3 = b.costoR3;
        this.ArrayList = b.ArrayList;
        this.tiempoEspera = b.tiempoEspera;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
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

    public ArrayList<Object> getArrayList() {
        return ArrayList;
    }

    public void setArrayList(ArrayList<Object> ArrayList) {
        this.ArrayList = ArrayList;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public static class Builder {

        private String tipo;
        private int vida;
        private int costoR1;
        private int costoR2;
        private int faseCreacion;
        private int costoR3;
        private ArrayList<Object> ArrayList;
        private int tiempoEspera;

        public Builder(String tipo, int vida, int costoR1, int costoR2) {
            this.tipo = tipo;
            this.vida = vida;
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

        public Builder ArrayList(ArrayList<Object> ArrayList) {
            this.ArrayList = ArrayList;
            return this;
        }

        public Builder tiempoEspera(int tiempoEspera) {
            this.tiempoEspera = tiempoEspera;
            return this;
        }

        public Edificacion build() {
            return new Edificacion(this);
        }
    }

    @Override
    public String toString() {
        return "Edificacion{"
                + "tipo='" + tipo + '\''
                + ", vida='" + vida + '\''
                + ", fase de creacion='" + faseCreacion + '\''
                + ", costo recurso 1='" + costoR1 + '\''
                + ", costo recurso 2='" + costoR2 + '\''
                + ", costo recurso 3='" + costoR3 + '\''
                + ", tiempoEspera='" + tiempoEspera + '\''
                + ", cantidad de elementos del ArrayList='" + ArrayList.size() + '\''
                + '}';
    }
}
