package cesarrosalesworld;

import Razas.Raza;
import Razas.RazaFactory;
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
        int turno = 0, fase = 0;
        String nombreJ1, nombreJ2;
        Scanner input = new Scanner(System.in);

        System.out.print("Cesar Rosales's World ®\nBienvenido!\nIngrese el nombre del jugador 1: ");
        nombreJ1 = input.next();
        System.out.print("Ingrese el nombre del jugador 2: ");
        nombreJ2 = input.next();
        System.out.print("\nRazas disponibles:\n1. Los Sectarios\n2. La Resistencia\n3. La manada\nIngrese la raza que desea " + nombreJ1 + ": ");
        int r1 = input.nextInt();
        System.out.print("\nRazas disponibles:\n1. Los Sectarios\n2. La Resistencia\n3. La manada\nIngrese la raza que desea " + nombreJ2 + ": ");
        int r2 = input.nextInt();

        System.out.println("\nIniciando el juego");
        Raza razaJ1 = RazaFactory.getRaza(r1);
        razaJ1.crear();
        Raza razaJ2 = RazaFactory.getRaza(r2);
        razaJ2.crear();
        Partida partida = new Partida();
        System.out.println("Vida cm raza j1: " + razaJ1.getVidaCentroMando());
        razaJ1.construirEdificacion();
        //da error NULL POINER EXEPCTION
        razaJ1.mostrarEdificaciones();
//        while (fase < 10) {
//            System.out.println("Fase " + fase + ":");
//            turno = partida.turno(turno);
//            partida.fase(turno);
//            fase++;
//        }
    }
}
