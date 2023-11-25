package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Posicion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

import java.util.Objects;

import static org.iesalandalus.programacion.reyajedrez.Consola.*;

public class MainApp {

    private static Rey rey;

    public static void main(String[] args) {

        int numOpcion;
        do {
            mostrarMenu();
            numOpcion = elegirOpcionMenu();
            ejecutarOpcion(numOpcion);
        } while (numOpcion != 4);

    }

    private static void ejecutarOpcion (int opcion) {
        switch (opcion) {
            case 1 -> crearReyDefecto();
            case 2 -> crearReyColor();
            case 3 -> mover();
            case 4 -> despedirse();
        }
    }

    private static void crearReyDefecto() {
        rey = new Rey();
        mostrarRey();
    }

    private static void crearReyColor() {
        Color color = Consola.elegirColor();
        rey = new Rey(color);
        mostrarRey();
    }

    private static void mover(){
        mostrarRey();
        mostrarMenuDirecciones();
        Direccion direccion = elegirDireccion();
        try
        {
            rey.mover(direccion);
        }
        catch(OperationNotSupportedException | NullPointerException | IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarRey(){
        //Rey rey = new Rey();
        Objects.requireNonNull(rey, "El rey aún no se ha creado.");
        System.out.println(rey);
    }

}
