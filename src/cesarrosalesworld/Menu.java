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
        System.out.print("\n----- MENU -----\n"
                + "1. Construir edificaciones\n"
                + "2. Entrenar tropas\n"
                + "3. Construir vehiculos\n"
                + "4. Atacar\n"
                + "5. Terminar turno\n"
                + "¿Qué opcion desea? ");
    }

    public void mostrar() {
        int opcion = 0, opcionInterna = 0;
        Scanner input = new Scanner(System.in);

        while (opcion != 5) {
            opciones();
            try {
                opcion = input.nextInt();
                switch (opcion) {
                    case 1:
                        opcionInterna = 0;
                        while (opcionInterna != 7) {
                            try {
                                System.out.print("\n----- EDIFICACIONES -----\n"
                                        + "1. Contruir recolector de recuros 1\n"
                                        + "2. Contruir recolector de recuros 2 \n"
                                        + "3. Generador de recursos\n"
                                        + "4. Campamento para entrenar tropas\n"
                                        + "5. Taller de vehiculos de tipo 1\n"
                                        + "6. Taller de vehiculos de tipo 2\n"
                                        + "7. Regresar al menu principal"
                                        + "\n¿Qué opcion desea? ");
                                opcionInterna = input.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println("se contruyo el Rec r1");
                                        break;
                                    case 2:
                                        System.out.println("se contruyo el Rec r2");
                                        break;
                                    case 3:
                                        System.out.println("se contruyo el gen r");
                                        break;
                                    case 4:
                                        System.out.println("se contruyo el camp");
                                        break;
                                    case 5:
                                        System.out.println("se contruyo el gar v1");
                                        break;
                                    case 6:
                                        System.out.println("se contruyo el gar v2");
                                        break;
                                    case 7:
                                        break;
                                    default:
                                        System.err.println("Por favor ingrese un número del 1 al 7");
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Por favor, ingrese un número");
                                input.nextLine();
                            }
                        }
                        break;
                    case 2:
                        opcionInterna = 0;
                        while (opcionInterna != 3) {
                            try {
                                System.out.print("\n----- MILICIA -----\n"
                                        + "1. Entrenar escuadron\n"
                                        + "2. Entrenar supersoldado\n"
                                        + "3. Regresar al menu principal\n"
                                        + "¿Qué opcion desea? ");
                                opcionInterna = input.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println("Se entreno escuadron");
                                        break;
                                    case 2:
                                        System.out.println("Se entreno supersoldado");
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.err.println("Por favor ingrese un número del 1 al 3");
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Por favor, ingrese un número");
                                input.nextLine();
                            }
                        }
                        break;
                    case 3:
                        opcionInterna = 0;
                        while (opcionInterna != 3) {
                            try {
                                System.out.print("\n----- VEHICULOS -----\n"
                                        + "1. Construir vehiculo de tipo 1\n"
                                        + "2. Construir vehiculo de tipo 2\n"
                                        + "3. Regresar al menu principal\n"
                                        + "¿Qué opcion desea? ");
                                opcionInterna = input.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println("Se construyo vehiculo de tipo 1");
                                        break;
                                    case 2:
                                        System.out.println("Se construyo vehiculo de tipo 2");
                                        break;
                                    case 3:
                                        break;                                        
                                    default:
                                        System.err.println("Por favor ingrese un número del 1 al 3");
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Por favor, ingrese un número");
                                input.nextLine();
                            }
                        }
                        break;
                    case 4:
                        opcionInterna = 0;
                        while (opcionInterna != 3) {
                            try {
                                System.out.print("\n----- ATAQUE -----\n"
                                        + "1. Atacar contruccion enemiga\n"
                                        + "2. Defender de ataque enemigo\n"
                                        + "3. Regresar al menu principal\n"
                                        + "¿Qué opcion desea? ");
                                opcionInterna = input.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println("Se mando a atacar enemigo");
                                        break;
                                    case 2:
                                        System.out.println("Se mado a defender");
                                        break;
                                    case 3:
                                        break;                                        
                                    default:
                                        System.err.println("Por favor ingrese un número del 1 al 3");
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Por favor, ingrese un número");
                                input.nextLine();
                            }
                        }
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
