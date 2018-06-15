package Razas;

import Edificaciones.CentroMando;
import Edificaciones.DirectorEdificacion;
import Edificaciones.Edificacion;
import Milicia.DirectorMilicia;
import Milicia.Milicia;
import Recursos.DirectorRecurso;
import Recursos.Recurso;
import Vehiculos.DirectorVehiculo;
import Vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Resistencia implements Raza {

    CentroMando cm;
//    ArrayList<Edificacion> edificaciones = new ArrayList<>();
    ArrayList<Edificacion> recRecursosTipo1 = new ArrayList<>();
    ArrayList<Edificacion> recRecursosTipo2 = new ArrayList<>();
    ArrayList<Edificacion> genRecursosTipo3 = new ArrayList<>();
    ArrayList<Edificacion> consVehTipo1Espera = new ArrayList<>();
    ArrayList<Edificacion> consVehTipo2Espera = new ArrayList<>();
    ArrayList<Edificacion> campamentosEspera = new ArrayList<>();
    ArrayList<Edificacion> consVehTipo1 = new ArrayList<>();
    ArrayList<Edificacion> consVehTipo2 = new ArrayList<>();
    ArrayList<Edificacion> campamentos = new ArrayList<>();
    int flagSupersoldado = 0;
    int campSupersoldado = 0;

    /**
     * Metodo que crea el centro de mando al instanciar la raza
     */
    @Override
    public void crear() {
        cm = new CentroMando.Builder(1060, 0, 1000, 950, 713, 10000, 5000, 3000).build();
    }

    /**
     * Modifica lso recursos del centro del mando, ya se para restarle (al
     * comparar algo) o sumarle (cuando se recolectan los recursos y se generan
     * recursos)
     *
     * @param tipo
     * @param R1
     * @param R2
     * @param R3
     */
    @Override
    public void modificarRecursosCM(char tipo, int R1, int R2, int R3) {
        switch (tipo) {
            case '+':
                if ((cm.getCantR1() + R1) > cm.getMaxR1()) {
                    cm.setCantR1(cm.getMaxR1());
                } else {
                    cm.setCantR1(cm.getCantR1() + R1);
                }
                if ((cm.getCantR2() + R2) > cm.getMaxR2()) {
                    cm.setCantR3(cm.getMaxR2());
                } else {
                    cm.setCantR2(cm.getCantR2() + R2);
                }
                if ((cm.getCantR3() + R3) > cm.getMaxR3()) {
                    cm.setCantR3(cm.getMaxR3());
                } else {
                    cm.setCantR3(cm.getCantR3() + R3);
                }
                break;
            case '-':
                cm.setCantR1(cm.getCantR1() - R1);
                cm.setCantR2(cm.getCantR2() - R2);
                cm.setCantR3(cm.getCantR3() - R3);
                break;
        }
    }

    /**
     * Aumenta el nivel del centro de mando siempre y cuando se tengan lso
     * recursos suficientes paara hacerlo
     */
    @Override
    public void subirNivelCM() {

        int totalRecursos, recursoInd;
        switch (cm.getNivel()) {
            case 0:
                totalRecursos = (int) (0.25 * ((cm.getMaxR1() * (1.1)) + (cm.getMaxR2() * (1.1)) + (cm.getMaxR3() * (1.1))));
                recursoInd = (int) totalRecursos / 3;
                if (cm.getCantR1() >= recursoInd && cm.getCantR2() >= recursoInd && cm.getCantR3() >= recursoInd) {
                    modificarRecursosCM('-', recursoInd, recursoInd, recursoInd);
                    cm.setNivel(1);
                    cm.setMaxR1((int) ((cm.getMaxR1()) * (1.1)));
                    cm.setMaxR2((int) ((cm.getMaxR2()) * (1.1)));
                    cm.setMaxR3((int) ((cm.getMaxR3()) * (1.1)));
                    System.out.println("\nSe mejoro el Centro de Mando al nivel 1\n");
                } else {
                    System.out.println("\033[31mRecursos insuficientes\033[30m");
                }
                break;
            case 1:
                totalRecursos = (int) (0.25 * ((cm.getMaxR1() * (1.3)) + (cm.getMaxR2() * (1.3)) + (cm.getMaxR3() * (1.3))));
                recursoInd = (int) totalRecursos / 3;
                if (cm.getCantR1() >= recursoInd && cm.getCantR2() >= recursoInd && cm.getCantR3() >= recursoInd) {
                    modificarRecursosCM('-', recursoInd, recursoInd, recursoInd);
                    cm.setNivel(2);
                    cm.setMaxR1((int) ((cm.getMaxR1()) * (1.3)));
                    cm.setMaxR2((int) ((cm.getMaxR2()) * (1.3)));
                    cm.setMaxR3((int) ((cm.getMaxR3()) * (1.3)));
                    System.out.println("\nSe mejoro el Centro de Mando al nivel 2\n");
                } else {
                    System.out.println("\033[31mRecursos insuficientes\033[30m");
                }
                break;
            case 2:
                totalRecursos = (int) (0.25 * ((cm.getMaxR1() * (1.5)) + (cm.getMaxR2() * (1.5)) + (cm.getMaxR3() * (1.5))));
                recursoInd = (int) totalRecursos / 3;
                if (cm.getCantR1() >= recursoInd && cm.getCantR2() >= recursoInd && cm.getCantR3() >= recursoInd) {
                    modificarRecursosCM('-', recursoInd, recursoInd, recursoInd);
                    cm.setNivel(3);
                    cm.setMaxR1((int) ((cm.getMaxR1()) * (1.5)));
                    cm.setMaxR2((int) ((cm.getMaxR2()) * (1.5)));
                    cm.setMaxR3((int) ((cm.getMaxR3()) * (1.5)));
                    System.out.println("\nSe mejoro el Centro de Mando al nivel 3\n");
                } else {
                    System.out.println("\033[31mRecursos insuficientes\033[30m");
                }
                break;
            default:
                System.out.println("\033[31mEl Centro de Mando ya alcanzo el nivel maximo (Nivel 3)\033[30m");
        }
    }

    /**
     * Construye edificaciones para guardar y crear vechiculos tanto de tipo 1
     * como de tipo 2
     *
     * @param fase
     * @param tipo
     */
    @Override
    public void construirEdificacionVehiculos(int fase, int tipo) {
        DirectorEdificacion directorE = new DirectorEdificacion();
        switch (tipo) {
            case 1:
                ArrayList<Object> vehiculosT1 = new ArrayList<>();
                Edificacion taller1 = directorE.getEdificacion("Taller de carros", 900, 200, 117, 0, fase, vehiculosT1, 3);
                if (cm.getCantR1() >= taller1.getCostoR1() && cm.getCantR2() >= taller1.getCostoR2()) {
                    modificarRecursosCM('-', taller1.getCostoR1(), taller1.getCostoR2(), 0);
                    //edificaciones.add(taller1);
                    consVehTipo1Espera.add(taller1);
                } else {
                    vehiculosT1.clear();
                    taller1 = null;
                    System.out.println("\033[31mRecursos insuficientes\033[30m");
                }
                break;
            case 2:
                ArrayList<Object> vehiculosT2 = new ArrayList<>();
                Edificacion taller2 = directorE.getEdificacion("Taller de avionetas", 900, 135, 69, 0, fase, vehiculosT2, 3);
                if (cm.getCantR1() >= taller2.getCostoR1() && cm.getCantR2() >= taller2.getCostoR2()) {
                    modificarRecursosCM('-', taller2.getCostoR1(), taller2.getCostoR2(), 0);
                    //edificaciones.add(taller2);
                    consVehTipo2Espera.add(taller2);
                } else {
                    vehiculosT2.clear();
                    taller2 = null;
                    System.out.println("\033[31mRecursos insuficientes\033[30m");
                }
                break;
        }
    }

    /**
     * Construye campamentos para entrenar tropas
     *
     * @param fase
     */
    @Override
    public void cosntruirEdificacionMilicia(int fase) {
        DirectorEdificacion directorE = new DirectorEdificacion();
        ArrayList<Object> milicia = new ArrayList<>();
        Edificacion camp1 = directorE.getEdificacion("Campamento de milicia", 750, 100, 40, 15, fase, milicia, 2);
        if (cm.getCantR1() >= camp1.getCostoR1() && cm.getCantR2() >= camp1.getCostoR2() && cm.getCantR3() >= camp1.getCostoR3()) {
            modificarRecursosCM('-', camp1.getCostoR1(), camp1.getCostoR2(), camp1.getCostoR3());
            //edificaciones.add(taller1);
            campamentosEspera.add(camp1);
        } else {
            milicia.clear();
            camp1 = null;
            System.out.println("\033[31mRecursos insuficientes\033[30m");
        }
    }

    /**
     * Construye las edficaciones para recolectar recursos de tipo 1 y 2 y para
     * generar recursos de tipo 3
     *
     * @param fase
     * @param tipo
     */
    @Override
    public void constriurEdificacionRecursos(int fase, int tipo) {
        DirectorEdificacion directorE = new DirectorEdificacion();
        DirectorRecurso directorR = new DirectorRecurso();
        switch (tipo) {
            case 1:
                ArrayList<Object> recolectoresT1 = new ArrayList<>();
                Edificacion recR1 = directorE.getEdificacion("Recolector de metal", 1000, 300, 200, 0, fase, recolectoresT1, 0);
                if (cm.getCantR1() >= recR1.getCostoR1() && cm.getCantR2() >= recR1.getCostoR2() && cm.getCantR3() >= recR1.getCostoR3()) {
                    modificarRecursosCM('-', recR1.getCostoR1(), recR1.getCostoR2(), recR1.getCostoR3());
                    Recurso rec1 = directorR.getRecurso("Metal", 25, fase);
                    recR1.getArrayList().add(rec1);
                    recRecursosTipo1.add(recR1);
                } else {
                    recolectoresT1.clear();
                    recR1 = null;
                    System.out.println("\033[31mRecursos insuficientes\033[30m");
                }
                break;
            case 2:
                ArrayList<Object> recolectoresT2 = new ArrayList<>();
                Edificacion recR2 = directorE.getEdificacion("Recolector de oro", 1000, 150, 200, 0, fase, recolectoresT2, 0);
                if (cm.getCantR1() >= recR2.getCostoR1() && cm.getCantR2() >= recR2.getCostoR2() && cm.getCantR3() >= recR2.getCostoR3()) {
                    modificarRecursosCM('-', recR2.getCostoR1(), recR2.getCostoR2(), recR2.getCostoR3());
                    Recurso rec2 = directorR.getRecurso("Oro", 40, fase);
                    recR2.getArrayList().add(rec2);
                    recRecursosTipo2.add(recR2);
                } else {
                    recolectoresT2.clear();
                    recR2 = null;
                    System.out.println("\033[31mRecursos insuficientes\033[30m");
                }
                break;
            case 3:
                ArrayList<Object> generadoresT3 = new ArrayList<>();
                Edificacion gen1 = directorE.getEdificacion("Generador de energia", 1000, 150, 300, 25, fase, generadoresT3, 0);
                if (cm.getCantR1() >= gen1.getCostoR1() && cm.getCantR2() >= gen1.getCostoR2() && cm.getCantR3() >= gen1.getCostoR3()) {
                    modificarRecursosCM('-', gen1.getCostoR1(), gen1.getCostoR2(), gen1.getCostoR3());
                    Recurso rec3 = directorR.getRecurso("Energia", 60, fase);
                    gen1.getArrayList().add(rec3);
                    genRecursosTipo3.add(gen1);
                } else {
                    generadoresT3.clear();
                    gen1 = null;
                    System.out.println("\033[31mRecursos insuficientes\033[30m");
                }
                break;
        }
    }

    /**
     * Retorna la vida del centro de mando de la raza del jugador en turno
     *
     * @return
     */
    @Override
    public int getVidaCentroMando() {
        return cm.getVida();
    }

    /**
     * Muestra las edificaciones creadas
     */
    @Override
    public void mostrarEdificaciones() {
        System.out.println(cm.toString());
        for (Edificacion e : consVehTipo1) {
            System.out.println(e.toString());
        }
        for (Edificacion e : consVehTipo2) {
            System.out.println(e.toString());
        }
        for (Edificacion e : campamentos) {
            System.out.println(e.toString());
        }
        for (Edificacion e : recRecursosTipo1) {
            System.out.println(e.toString());
        }
        for (Edificacion e : recRecursosTipo2) {
            System.out.println(e.toString());
        }
        for (Edificacion e : genRecursosTipo3) {
            System.out.println(e.toString());
        }
    }

    /**
     * Entrena tropas de escuadron si existen campamentos para guardarlos
     *
     * @param fase
     */
    @Override
    public void entrenarTropaEscuadron(int fase) {
        DirectorMilicia directorM = new DirectorMilicia();
        Milicia tropa1 = directorM.getMilicia("Soldado", 1000, 300, 200, 100, 75, 25, fase, 2);
        if (cm.getCantR1() >= tropa1.getCostoR1() && cm.getCantR2() >= tropa1.getCostoR2() && cm.getCantR3() >= tropa1.getCostoR3()) {
            if (campamentos.isEmpty()) {
                System.out.println("\033[31mNo hay campamentos disponibles, por lo tanto no se puede entrenar milicia\033[30m");
            } else {
                if (campamentos.size() == 1) {
                    modificarRecursosCM('-', tropa1.getCostoR1(), tropa1.getCostoR2(), tropa1.getCostoR3());
                    campamentos.get(0).getArrayList().add(tropa1);
                } else {
                    Scanner input = new Scanner(System.in);
                    int opcionCamp = 0, flag = 0;
                    while (flag == 0) {
                        try {
                            System.out.print("\nTiene disponible " + campamentos.size() + " campamentos de milicia\n¿En cuál desea guardar sus tropas? ");
                            opcionCamp = input.nextInt();
                            if (opcionCamp >= 1 && opcionCamp <= campamentos.size()) {
                                modificarRecursosCM('-', tropa1.getCostoR1(), tropa1.getCostoR2(), tropa1.getCostoR3());
                                campamentos.get(opcionCamp - 1).getArrayList().add(tropa1);
                                flag = 1;
                            } else {
                                System.out.println("\033[31mPor favor ingrese un número del 1 al " + campamentos.size() + "\033[30m");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                            input.nextLine();
                        }
                    }
                }
            }
        } else {
            tropa1 = null;
            System.out.println("\033[31mRecursos insuficientes\033[30m");
        }
    }

    /**
     * Entrena un supersoldado a la vez, siempre y cuando exista al menos un
     * campamento para guardarlo
     *
     * @param fase
     */
    @Override
    public void entrenarSupersoldado(int fase) {
        if (flagSupersoldado == 0) {
            DirectorMilicia directorM = new DirectorMilicia();
            Milicia supersoldado = directorM.getMilicia("General", 1000, 500, 300, 100, 75, 150, fase, 2);
            if (cm.getCantR1() >= supersoldado.getCostoR1() && cm.getCantR2() >= supersoldado.getCostoR2() && cm.getCantR3() >= supersoldado.getCostoR3()) {
                if (campamentos.isEmpty()) {
                    System.out.println("\033[31mNo hay campamentos disponibles, por lo tanto no se puede entrenar milicia\033[30m");
                } else {
                    if (campamentos.size() == 1) {
                        modificarRecursosCM('-', supersoldado.getCostoR1(), supersoldado.getCostoR2(), supersoldado.getCostoR3());
                        campSupersoldado = 0;
                        campamentos.get(campSupersoldado).getArrayList().add(supersoldado);
                        flagSupersoldado = 1;
                    } else {
                        Scanner input = new Scanner(System.in);
                        int opcionCamp = 0, flag = 0;
                        while (flag == 0) {
                            try {
                                System.out.print("\nTiene disponible " + campamentos.size() + " campamentos de milicia\n¿En cuál desea guardar su Supersoldado? ");
                                opcionCamp = input.nextInt();
                                if (opcionCamp >= 1 && opcionCamp <= campamentos.size()) {
                                    modificarRecursosCM('-', supersoldado.getCostoR1(), supersoldado.getCostoR2(), supersoldado.getCostoR3());
                                    campSupersoldado = opcionCamp - 1;
                                    campamentos.get(campSupersoldado).getArrayList().add(supersoldado);
                                    flagSupersoldado = 1;
                                } else {
                                    System.out.println("\033[31mPor favor ingrese un número del 1 al " + campamentos.size() + "\033[30m");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                                input.nextLine();
                            }
                        }
                    }
                }
            } else {
                supersoldado = null;
                System.out.println("\033[31mRecursos insuficientes\033[30m");
            }
        } else {
            System.out.println("\033[31mYa se creo un Supersoldado, solo puede exitir uno a la vez\033[30m");
        }
    }

    /**
     * Contruye vehiculos de tipo 1, si existe al menos un taller de vehiculos
     * de tipo 1
     *
     * @param fase
     */
    @Override
    public void construirVehiculosTipo1(int fase) {
        DirectorVehiculo directorV = new DirectorVehiculo();
        Vehiculo v1 = directorV.getVehiculo("Carro", 1000, 130, 100, 150, 75, fase, 4);
        if (cm.getCantR1() >= v1.getCostoR1() && cm.getCantR2() >= v1.getCostoR2() && cm.getCantR3() >= v1.getCostoR3()) {
            if (consVehTipo1.isEmpty()) {
                System.out.println("\033[31mNo hay talleres de vehiculos de tipo 1 disponibles, por lo tanto no se pueden construir vehiculos\033[30m");
            } else {
                if (consVehTipo1.size() == 1) {
                    modificarRecursosCM('-', v1.getCostoR1(), v1.getCostoR2(), v1.getCostoR3());
                    consVehTipo1.get(0).getArrayList().add(v1);
                } else {
                    Scanner input = new Scanner(System.in);
                    int opcionTaller = 0, flag = 0;
                    while (flag == 0) {
                        try {
                            System.out.print("\nTiene disponible " + consVehTipo1.size() + " talleres de vehiculos de tipo 1\n¿En cuál desea guardar sus vehiculos? ");
                            opcionTaller = input.nextInt();
                            if (opcionTaller >= 1 && opcionTaller <= consVehTipo1.size()) {
                                modificarRecursosCM('-', v1.getCostoR1(), v1.getCostoR2(), v1.getCostoR3());
                                consVehTipo1.get(opcionTaller - 1).getArrayList().add(v1);
                                flag = 1;
                            } else {
                                System.out.println("\033[31mPor favor ingrese un número del 1 al " + consVehTipo1.size() + "\033[30m");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                            input.nextLine();
                        }
                    }
                }
            }
        } else {
            v1 = null;
            System.out.println("\033[31mRecursos insuficientes\033[30m");
        }
    }

    /**
     * Contruye vehiculos de tipo 2, si existe al menos un taller de vehiculos
     * de tipo 2
     *
     * @param fase
     */
    @Override
    public void construirVehiculosTipo2(int fase) {
        DirectorVehiculo directorV = new DirectorVehiculo();
        Vehiculo v2 = directorV.getVehiculo("Avioneta", 1000, 130, 70, 150, 50, fase, 4);
        if (cm.getCantR1() >= v2.getCostoR1() && cm.getCantR2() >= v2.getCostoR2() && cm.getCantR3() >= v2.getCostoR3()) {
            if (consVehTipo2.isEmpty()) {
                System.out.println("\033[31mNo hay talleres de vehiculos de tipo 2 disponibles, por lo tanto no se pueden construir vehiculos\033[30m");
            } else {
                if (consVehTipo2.size() == 1) {
                    modificarRecursosCM('-', v2.getCostoR1(), v2.getCostoR2(), v2.getCostoR3());
                    consVehTipo2.get(0).getArrayList().add(v2);
                } else {
                    Scanner input = new Scanner(System.in);
                    int opcionTaller = 0, flag = 0;
                    while (flag == 0) {
                        try {
                            System.out.print("\nTiene disponible " + consVehTipo2.size() + " talleres de vehiculos de tipo 2\n¿En cuál desea guardar sus vehiculos? ");
                            opcionTaller = input.nextInt();
                            if (opcionTaller >= 1 && opcionTaller <= consVehTipo2.size()) {
                                modificarRecursosCM('-', v2.getCostoR1(), v2.getCostoR2(), v2.getCostoR3());
                                consVehTipo2.get(opcionTaller - 1).getArrayList().add(v2);
                                flag = 1;
                            } else {
                                System.out.println("\033[31mPor favor ingrese un número del 1 al " + consVehTipo2.size() + "\033[30m");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\033[31mPor favor, ingrese un número\033[30m");
                            input.nextLine();
                        }
                    }
                }
            }
        } else {
            v2 = null;
            System.out.println("\033[31mRecursos insuficientes\033[30m");
        }
    }

    /**
     * Metodo que recolecta los recursos tanto de tipo 1 como de tipo 2 llama al
     * metodo de modificar recursos del centro de mando para aumentar sus
     * recursos
     *
     * @param fase
     * @param tipo
     */
    @Override
    public void recolectarRecurso(int fase, int tipo) {
        int cantRecurso = 0;
        switch (tipo) {
            case 1:
                for (int i = 0; i <= (recRecursosTipo1.size() - 1); i++) {
                    Recurso rec = (Recurso) recRecursosTipo1.get(i).getArrayList().get(0);
                    cantRecurso += (int) (fase - rec.getFaseRecoleccion()) * (rec.getCantidad());
                    rec.setFaseRecoleccion(fase);
                }
                modificarRecursosCM('+', cantRecurso, 0, 0);
                break;
            case 2:
                for (int i = 0; i <= (recRecursosTipo2.size() - 1); i++) {
                    Recurso rec = (Recurso) recRecursosTipo2.get(i).getArrayList().get(0);
                    cantRecurso += (int) (fase - rec.getFaseRecoleccion()) * (rec.getCantidad());
                    rec.setFaseRecoleccion(fase);
                }
                modificarRecursosCM('+', 0, cantRecurso, 0);
                break;
            case 3:
                for (int i = 0; i <= (genRecursosTipo3.size() - 1); i++) {
                    Recurso rec = (Recurso) genRecursosTipo3.get(i).getArrayList().get(0);
                    cantRecurso += (int) (fase - rec.getFaseRecoleccion()) * (rec.getCantidad());
                    rec.setFaseRecoleccion(fase);
                }
                modificarRecursosCM('+', 0, 0, cantRecurso);
                break;
        }
    }

    /**
     * Muestra los recursos disponibles en el centro de mando
     */
    @Override
    public void mostrarRecursosDisponibles() {
        System.out.println("Recursos de tipo 1: " + cm.getCantR1() + ", recursos de tipo 2: " + cm.getCantR2() + ", recursos de tipo 3: " + cm.getCantR3());
    }

    /**
     * Reduce el timepo de espera para crea una edificacion de vehiculos de tipo
     * 1 al llegar ese tiempo a cero se crea en el ArrayList y se puede acceder
     * a el dentro de la raza
     */
    @Override
    public void cambiarTiempoEsperaEdificacionVehiculosTipo1() {
        for (int i = 0; i <= (consVehTipo1Espera.size() - 1); i++) {
            Edificacion c = consVehTipo1Espera.get(i);
            if (c.getTiempoEspera() == 0) {
                consVehTipo1.add(c);
                consVehTipo1Espera.remove(i);
            } else {
                c.setTiempoEspera(c.getTiempoEspera() - 1);
            }
        }
    }

    /**
     * Reduce el timepo de espera para crea una edificacion de vehiculos de tipo
     * 2 al llegar ese tiempo a cero se crea en el ArrayList y se puede acceder
     * a el dentro de la raza
     */
    @Override
    public void cambiarTiempoEsperaEdificacionVehiculosTipo2() {
        for (int i = 0; i <= (consVehTipo2Espera.size() - 1); i++) {
            Edificacion c = consVehTipo2Espera.get(i);
            if (c.getTiempoEspera() == 0) {
                consVehTipo2.add(c);
                consVehTipo2Espera.remove(i);
            } else {
                c.setTiempoEspera(c.getTiempoEspera() - 1);
            }
        }
    }

    /**
     * Reduce el timepode espera para crea un campamento al llegar ese tiempo a
     * cero se crea en el ArrayList y se puede acceder a el dentro de la raza
     */
    @Override
    public void cambiarTiempoEsperaCampamentos() {
        for (int i = 0; i <= (campamentosEspera.size() - 1); i++) {
            Edificacion c = campamentosEspera.get(i);
            if (c.getTiempoEspera() == 0) {
                campamentos.add(c);
                campamentosEspera.remove(i);
            } else {
                c.setTiempoEspera(c.getTiempoEspera() - 1);
            }
        }
    }

    /**
     * Cambia el valor actual de la vida del centro de mando
     *
     * @param vida
     */
    @Override
    public void setVidaCentroMando(int vida) {
        cm.setVida(vida);
    }
}
