package org.iesalandalus.programacion.reyajedrez.modelo;

import java.util.Objects;

public class Rey {
    private int totalMovimientos;
    private Color color;
    private Posicion posicion;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = Objects.requireNonNull(color, "El color del Rey no puede ser nulo.");
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = Objects.requireNonNull(posicion, "La posición del Rey no puede ser nula.");
    }
}
