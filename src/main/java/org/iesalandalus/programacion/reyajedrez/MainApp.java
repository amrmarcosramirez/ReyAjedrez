package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Posicion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import static org.iesalandalus.programacion.reyajedrez.Consola.*;

public class MainApp {
    private Rey rey;

    public static void main(String[] args) {


    }

    private static void crearReyDefecto() {
        Rey rey = new Rey();
    }

    private static void crearReyColor() {
        Color color = Consola.elegirColor();
        Rey rey = new Rey(color);
    }

    
}
