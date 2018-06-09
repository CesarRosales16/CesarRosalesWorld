package cesarrosalesworld;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Partida {

    public int turno(int turno, String nombreJ1, String nombreJ2) {
        if (turno == 0) {
            int inicial = ((int) (Math.random() * 2) + 1);
            if (inicial == 1) {
                System.out.println("Turno de " + nombreJ1 + ":\n");
            } else {
                System.out.println("Turno de " + nombreJ2 + ":\n");
            }
            return inicial;
        } else {
            if (turno == 1) {
                System.out.println("Turno de " + nombreJ2 + ":\n");
                return 2;
            } else {
                System.out.println("Turno de " + nombreJ1 + ":\n");
                return 1;
            }
        }
    }

    public int fase(int turno, String nombreJ1, String nombreJ2) {
        Menu menu = Menu.getInstance();
        menu.mostrar();
        turno = turno(turno, nombreJ1, nombreJ2);
        menu.mostrar();
        return turno;
    }
}
