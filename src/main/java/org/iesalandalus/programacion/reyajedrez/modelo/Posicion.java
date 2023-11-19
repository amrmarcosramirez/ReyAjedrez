package org.iesalandalus.programacion.reyajedrez.modelo;

public class Posicion {
    private int fila;
    private char columna;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila < 1) {
            throw new IllegalArgumentException("El valor de la fila es menor que el mínimo permitido.");
        } else if (fila > 8) {
            throw new IllegalArgumentException("El valor de la fila es mayor que el máximo permitido.");
        }
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        this.columna = switch (columna) {
            case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' -> columna;
            default -> throw new IllegalArgumentException("La columna no es correcta. Está fuera de rango permitido.");
        };
    }
}
