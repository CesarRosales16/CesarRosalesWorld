package cesarrosalesworld;

import Razas.Raza;
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
                + "1. Aumentar nivel de Centro de Mando\n"
                + "2. Construir edificaciones\n"
                + "3. Entrenar tropas\n"
                + "4. Construir vehiculos\n"
                + "5. Recolectar recursos\n"
                + "6. Atacar\n"
                + "7. Terminar turno\n"
                + "¿Qué opcion desea? ");
    }

    public void mostrar(int fase, Raza raza) {
        int opcion = 0, opcionInterna = 0;
        Scanner input = new Scanner(System.in);

        while (opcion != 7) {
            opciones();
            try {
                opcion = input.nextInt();
                switch (opcion) {
                    case 1:
                        raza.subirNivelCM();
                        break;
                    case 2:
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
                                        raza.constriurEdificacionRecursos(fase, 1);
                                        System.out.println("se contruyo el Rec r1");
                                        break;
                                    case 2:
                                        raza.constriurEdificacionRecursos(fase, 2);
                                        System.out.println("se contruyo el Rec r2");
                                        break;
                                    case 3:
                                        raza.constriurEdificacionRecursos(fase, 3);
                                        System.out.println("se contruyo el gen r");
                                        break;
                                    case 4:
                                        raza.cosntruirEdificacionMilicia(fase);
                                        System.out.println("se contruyo el camp");
                                        break;
                                    case 5:
                                        raza.construirEdificacionVehiculos(fase, 1);
                                        System.out.println("se contruyo el gar v1");
                                        break;
                                    case 6:
                                        raza.construirEdificacionVehiculos(fase, 2);
                                        System.out.println("se contruyo el gar v2");
                                        break;
                                    case 7:
                                        break;
                                    default:
                                        System.out.println("\033[31mPor favor ingrese un número del 1 al 7\033[30m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                                input.nextLine();
                            }
                        }
                        break;
                    case 3:
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
                                        raza.entrenarTropaEscuadron(fase);
                                        System.out.println("Se entreno escuadron");
                                        break;
                                    case 2:                                        
                                        raza.entrenarSupersoldado(fase);
                                        System.out.println("Se entreno supersoldado");
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("\033[31mPor favor ingrese un número del 1 al 3\033[30m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                                input.nextLine();
                            }
                        }
                        break;
                    case 4:
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
                                        raza.construirVehiculosTipo1(fase);
                                        System.out.println("Se construyo vehiculo de tipo 1");
                                        break;
                                    case 2:
                                        raza.construirVehiculosTipo2(fase);
                                        System.out.println("Se construyo vehiculo de tipo 2");
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("\033[31mPor favor ingrese un número del 1 al 3\033[30m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                                input.nextLine();
                            }
                        }
                        break;
                    case 5:
                        opcionInterna = 0;
                        while (opcionInterna != 4) {
                            try {
                                System.out.print("\n----- RECURSOS -----\n"
                                        + "1. Recolectar recursos tipo 1\n"
                                        + "2. Recolectar recursos tipo 2\n"
                                        + "3. Ver recursos disponibles\n"
                                        + "4. Regresar al menu principal\n"
                                        + "¿Qué opcion desea? ");
                                opcionInterna = input.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        raza.recolectarRecurso(fase, 1);
                                        System.out.println("Se recolectaron los recursos de tipo 1");
                                        break;
                                    case 2:
                                        raza.recolectarRecurso(fase, 2);
                                        System.out.println("Se recolectaron los recursos de tipo 2");
                                        break;
                                    case 3:
                                        raza.mostrarRecursosDisponibles();
                                        System.out.println("Se mostraron recursos");
                                        break;
                                    case 4:
                                        break;
                                    default:
                                        System.out.println("\033[31mPor favor ingrese un número del 1 al 4\033[30m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                                input.nextLine();
                            }
                        }
                        break;
                    case 6:
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
                                        System.out.println("\033[31mPor favor ingrese un número del 1 al 3\033[30m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                                input.nextLine();
                            }
                        }
                        break;
                    case 7:
                        System.out.println("\033[31mTurno terminado\033[30m");
                        break;
                    default:
                        System.out.println("\033[31mPor favor ingrese una opcion valida\033[30m");
                }
            } catch (InputMismatchException e) {
                System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                input.nextLine();
            }
        }
    }
}
