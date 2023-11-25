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
            switch (numOpcion) {
                case 1 -> crearReyDefecto();
                case 2 -> crearReyColor();
                case 3 -> mover();
                case 4 -> despedirse();
            }
        } while (numOpcion != 4);

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
