package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;

import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;


public class Consola {

    private Consola(){}

    public static void mostrarMenu() {
        System.out.println("1. Crear rey por defecto" + "\n" + "2. Crear rey eligiendo el color" +
                "\n" + "3. Mover" + "\n" + "4. Salir");
    }

    public static int elegirOpcionMenu() {
        int numOpcion;
        do {
            System.out.println("Introduzca opción:");
            numOpcion = Entrada.entero();
        } while (numOpcion < 1 || numOpcion > 4);
        return numOpcion;
    }

    public static Color elegirColor() {

        int color;
        Color colorElegido=Color.BLANCO;

        do
        {
            System.out.println("De las siguientes opciones, elija un color: ");
            System.out.println("1. " + Color.BLANCO + "/n" + "2. " + Color.NEGRO);
            color=Entrada.entero();
        }while (color<1 || color>2);

        switch (color)
        {
            case 0 -> colorElegido=Color.BLANCO;
            case 1 -> colorElegido=Color.NEGRO;
        }
        return colorElegido;
    }

    public static void mostrarMenuDirecciones() {
            System.out.println("Estas son las direcciones que se pueden elegir: ");
            System.out.println(Direccion.values().toString());
    }

    public static String elegirDireccion() {
        String direccion;

        do {
            System.out.println("De las opciones anteriores, elija una dirección: ");
            System.out.println(Direccion.values().toString());
            direccion = Entrada.cadena();

        } while (direccion != Direccion.values().toString());
        return direccion;
    }

    public static void despedirse() {
        System.out.println("Adiós.");
    }
}
