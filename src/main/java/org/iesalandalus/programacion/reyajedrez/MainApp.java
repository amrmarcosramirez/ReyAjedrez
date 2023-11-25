package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import static org.iesalandalus.programacion.reyajedrez.Consola.elegirColor;

public class MainApp {
    private Rey rey;

    public static void main(String[] args) {


    }

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
}
