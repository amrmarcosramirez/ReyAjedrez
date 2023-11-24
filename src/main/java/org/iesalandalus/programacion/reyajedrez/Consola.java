package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
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
        int numOpcion;
        do {
            System.out.println("Introduzca opción:");
            numOpcion = Entrada.entero();
        } while (numOpcion != 1 && numOpcion != 2 && numOpcion != 3 && numOpcion != 4);
        return numOpcion;
    }

    public static int elegirOpcion() {
        int numOpcion;

        do {
            System.out.println("De las siguientes opciones, elija un color ");
            System.out.println("1. " + Color.BLANCO);
            System.out.println("2. " + Color.NEGRO);
            numOpcion = Entrada.entero();
        } while (numOpcion != 1 && numOpcion != 2);
        return numOpcion;
    }
}
