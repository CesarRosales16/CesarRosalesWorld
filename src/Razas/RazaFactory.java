package Razas;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class RazaFactory {

    public static Raza getRaza(int tipo) {
        switch (tipo) {
            case 1:
                return new Sectario();
            case 2:
                return new Resistencia();
            case 3:
                return new Manada();
        }
        return null;
    }
}