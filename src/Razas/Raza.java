package Razas;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public interface Raza {

    void crear();
    void modificarRecursosCM(char tipo, int R1, int R2, int R3);
    void subirNivelCM();
    void construirEdificacionVehiculos(int fase, int tipo);
    void cosntruirEdificacionMilicia(int fase);
    void constriurEdificacionRecursos(int fase, int tipo);
    int getVidaCentroMando();
    void setVidaCentroMando(int ataque);
    void mostrarEdificaciones();
    void entrenarTropaEscuadron(int fase);
    void entrenarSupersoldado(int fase);
    void construirVehiculosTipo1(int fase);
    void construirVehiculosTipo2(int fase);
    void recolectarRecurso(int fase, int tipo);
    void mostrarRecursosDisponibles();
    void cambiarTiempoEsperaEdificacionVehiculosTipo1();
    void cambiarTiempoEsperaEdificacionVehiculosTipo2();
    void cambiarTiempoEsperaCampamentos();
//    void cambiarEstadoEdificios(int fase);
//    void cambiarEstadoMiliciaVehiculos(int fase);
//    int getAtaque(int opcion);
//    int bajarVidaEdificacion(int ataque);
//    void atacarEdificacion();
//    void atacarInvasores();
//    void mandarAtaque();
}
