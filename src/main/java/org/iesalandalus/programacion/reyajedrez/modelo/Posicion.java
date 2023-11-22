package org.iesalandalus.programacion.reyajedrez.modelo;

import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    public int getFila() {
        return fila;
    }

    public Posicion(Posicion posicion) {
        Objects.requireNonNull(posicion, "No puedo copiar una posición nula.");
        fila = posicion.fila;
        columna = posicion.columna;
    }

    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    public void setFila(int fila) {
        if (fila < 1) {
            throw new IllegalArgumentException("El valor de la fila es menor que el mínimo permitido.");
        } else if (fila > 8) {
            throw new IllegalArgumentException("El valor de la fila es mayor que el máximo permitido.");
        } else {
            this.fila = fila;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicion posicion2)) return false;
        return fila == posicion2.fila && columna == posicion2.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return String.format("Posicion[x=%s, y=%s]", this.fila, this.columna);
    }

}
