package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Posicion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola(){}

    public static void mostrarMenu() {
        System.out.println("1. Crear rey por defecto");
        System.out.println("2. Crear rey eligiendo el color");
        System.out.println("3. Mover");
        System.out.println("4. Salir");
    }

    public static int elegirOpcionMenu() {
        int numopcion;
        do {
            System.out.println(" Introduzca opción:");
            numopcion = Entrada.entero();
        } while (numopcion != 1 && numopcion != 2 && numopcion != 3 && numopcion != 4);
        return numopcion;
    }
}
