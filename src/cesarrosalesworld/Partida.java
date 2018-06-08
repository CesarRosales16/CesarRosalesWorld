/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cesarrosalesworld;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Partida {

    public int turno(int turno) {
        if (turno == 0) {
            System.out.println("Turno inicial, generado con random:");
            return ((int) (Math.random() * 2) + 1);
        } else {
            if (turno == 1) {
                System.out.println("Fue el turno de 1, se cambia a 2");
                return 2;
            } else {
                System.out.println("Fue el turno de 2, se cambia a 1");
                return 1;
            }
        }
    }

    public void fase(int turno) {
        //int act = turno(turno);
        Menu menu = Menu.getInstance();
        menu.mostrar();
        turno(turno);
        menu.mostrar();
        System.out.println("Termino una fase");
        //return fase;
    }
}
