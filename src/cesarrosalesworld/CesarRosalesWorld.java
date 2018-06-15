package cesarrosalesworld;

import Razas.Raza;
import Razas.RazaFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class CesarRosalesWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int turno = 0, fase = 1, r1 = 0, r2 = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Cesar Rosales's World ®\nBienvenido!\n");
        while (true) {
            try {
                System.out.println("\033[34m\nJUGADOR 1: \033[30m");
                System.out.print("Razas disponibles:\n1. Los Sectarios\n2. La Resistencia\n3. La manada\nIngrese la raza que desea para el \033[34mJUGADOR 1\033[30m: ");
                r1 = input.nextInt();
                if (r1 >= 1 && r1 <= 3) {
                    break;
                } else {
                    System.out.println("\033[31mPor favor ingrese un número del 1 al 3\033[30m");
                    input.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                input.nextLine();
            }
        }
        while (true) {
            try {
                System.out.println("\033[32m\nJUGADOR 2: \033[30m");
                System.out.print("Razas disponibles:\n1. Los Sectarios\n2. La Resistencia\n3. La manada\nIngrese la raza que desea para el \033[32mJUGADOR 2\033[30m: ");
                r2 = input.nextInt();
                if (r2 >= 1 && r2 <= 3) {
                    break;
                } else {
                    System.out.println("\033[31mPor favor ingrese un número del 1 al 3\033[30m");
                    input.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                input.nextLine();
            }
        }

        System.out.println("\nIniciando el juego");
        Raza razaJ1 = RazaFactory.getRaza(r1);
        razaJ1.crear();
        Menu menu = Menu.getInstance();
        Raza razaJ2 = RazaFactory.getRaza(r2);
        razaJ2.crear();
        Partida partida = new Partida();
        while (razaJ1.getVidaCentroMando()>0 && razaJ2.getVidaCentroMando()>0) {
            System.out.println("\033[31m\nFase " + fase + ":\033[30m");
            for (int i = 1; i <= 2; i++) {
                turno = partida.turno(turno);
                if (turno == 1) {
                    System.out.println("\033[34mJUGADOR 1: \033[30m");
                    menu.mostrar(fase, razaJ1);
                } else {
                    System.out.println("\033[32mJUGADOR 2: \033[30m");
                    menu.mostrar(fase, razaJ2);
                }
            }
            razaJ1.recolectarRecurso(fase, 3);
            razaJ2.recolectarRecurso(fase, 3);
            razaJ1.cambiarTiempoEsperaEdificacionVehiculosTipo1();
            razaJ1.cambiarTiempoEsperaEdificacionVehiculosTipo2();
            razaJ1.cambiarTiempoEsperaCampamentos();
            razaJ2.cambiarTiempoEsperaEdificacionVehiculosTipo1();
            razaJ2.cambiarTiempoEsperaEdificacionVehiculosTipo2();
            razaJ2.cambiarTiempoEsperaCampamentos();
            fase++;
            razaJ1.setVidaCentroMando(razaJ1.getVidaCentroMando()-89);
            razaJ2.setVidaCentroMando(razaJ1.getVidaCentroMando()-93);
        }
        if(razaJ1.getVidaCentroMando()<=0){
            razaJ1.setVidaCentroMando(0);
            System.out.println("\033[32mHA GANADO EL JUGADOR 2\033[30m");
        } else {
            razaJ2.setVidaCentroMando(0);
            System.out.println("\033[34mHA GANADO EL JUGADOR 1\033[30m");
        }
        System.out.println("Edificacione J1: ");
        razaJ1.mostrarEdificaciones();
        System.out.println("Edificacione J2: ");
        razaJ2.mostrarEdificaciones();
        System.out.println("\033[31mJUEGO TERMINADO\033[30m");

    }
}
