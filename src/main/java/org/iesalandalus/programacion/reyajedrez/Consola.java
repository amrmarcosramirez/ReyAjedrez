package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.*;

//import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
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
        } while (numOpcion < 1 || numOpcion > 4);
        return numOpcion;
    }

    public static Color elegirColor() {
        int color;
        Color colorElegido=Color.BLANCO;

        do
        {
            System.out.println("De las siguientes opciones, elija un color: ");
            System.out.println("1. " + Color.BLANCO );
            System.out.println("2. " + Color.NEGRO);
            color=Entrada.entero();
        }while (color<1 || color>2);

        switch (color)
        {
            case 1 -> colorElegido=Color.BLANCO;
            case 2 -> colorElegido=Color.NEGRO;
        }
        return colorElegido;
    }

    public static void mostrarMenuDirecciones() {
        System.out.println("Estas son las direcciones que se pueden elegir: ");
        System.out.println("1. " +  Direccion.NORTE);
        System.out.println("2. " +  Direccion.SUR );
        System.out.println("3. " +  Direccion.ESTE);
        System.out.println("4. " +  Direccion.OESTE);
        System.out.println("5. " +  Direccion.NORESTE);
        System.out.println("6. " +  Direccion.NOROESTE);
        System.out.println("7. " +  Direccion.SURESTE);
        System.out.println("8. " +  Direccion.SUROESTE);
        System.out.println("9. " +  Direccion.ENROQUE_CORTO);
        System.out.println("10. " + Direccion.ENROQUE_LARGO);
    }


    public static Direccion elegirDireccion() {
        int direccion;
        Direccion direccionElegida=Direccion.NORTE;

        do
        {
            System.out.println("De las opciones mostradas, elija una: ");
            direccion=Entrada.entero();
        }while (direccion<1 || direccion>10);

        switch (direccion)
        {
            case 1 -> direccionElegida=Direccion.NORTE ;
            case 2 -> direccionElegida=Direccion.SUR;
            case 3 -> direccionElegida=Direccion.ESTE;
            case 4 -> direccionElegida=Direccion.OESTE;
            case 5 -> direccionElegida=Direccion.NORESTE;
            case 6 -> direccionElegida=Direccion.NOROESTE;
            case 7 -> direccionElegida=Direccion.SURESTE;
            case 8 -> direccionElegida=Direccion.SUROESTE;
            case 9 -> direccionElegida=Direccion.ENROQUE_CORTO;
            case 10 -> direccionElegida=Direccion.ENROQUE_LARGO;
        }
        return direccionElegida;
    }

    public static void despedirse() {
        System.out.println("Adiós.");
    }
}
