package cesarrosalesworld;


/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Partida {

    public int turno(int turno) {
        if (turno == 0) {
            int inicial = ((int) (Math.random() * 2) + 1);
            return inicial;
        } else {
            if (turno == 1) {
                return 2;
            } else {
                return 1;
            }
        }
    }
}
