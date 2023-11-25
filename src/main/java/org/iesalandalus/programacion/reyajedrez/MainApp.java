package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Posicion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import static org.iesalandalus.programacion.reyajedrez.Consola.*;

public class MainApp {

    public static void main(String[] args) {


    }


    private Rey rey;

    private static void ejecutarOpcion (int opcion) {
        if (opcion == 1){
            crearReyDefecto();
        } else if (opcion == 2) {
            crearReyColor();
        } else if (opcion == 3) {
            mover();
        } else {
            mostrarRey();
        }
    }

    private static void crearReyDefecto() {
        rey = new Rey();
    }

    private static void crearReyColor() {
        Color color = Consola.elegirColor();
        rey = new Rey(color);
    }

    private static void mover(){
        mostrarMenuDirecciones();
        Direccion direccion = elegirDireccion();
        rey.mover(direccion);
    }


}
