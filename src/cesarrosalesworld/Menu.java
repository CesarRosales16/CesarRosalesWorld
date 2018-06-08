package cesarrosalesworld;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Menu {

    private static Menu instance;

    private Menu() {
    }

    public synchronized static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void opciones() {
        System.out.println("----- Menu -----");
        System.out.println("1. Construir edificaciones");
        System.out.println("2. Entrenar Tropas");
        System.out.println("3. Construir Vehiculos");
        System.out.println("4. Atacar");
        System.out.println("5. Salir");
    }

    public void mostrar() {
        int opcion = 100;
        Scanner input = new Scanner(System.in);

        while (opcion != 5) {
            opciones();
            try {
                opcion = input.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Construit edificios");
                        break;
                    case 2:
                        System.out.println("entrenar tropas");
                        break;
                    case 3:
                        System.out.println("Construir vehiculos");
                        break;
                    case 4:
                        System.out.println("atacar");
                        break;
                    case 5:
                        System.out.println("Turno terminado");
                        break;
                    default:
                        System.err.println("Por favor ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, ingrese un número");
                input.nextLine();
            }
        }
    }
}
