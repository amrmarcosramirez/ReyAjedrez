package org.iesalandalus.programacion.reyajedrez.modelo;

import java.util.Objects;

public class Rey {
    private static int totalMovimientos = 0;
    private Color color;
    private Posicion posicion;

    public Rey(){
        color = Color.BLANCO;
        posicion = new Posicion(1, 'e');
    }

    public Rey(Color color){
        this();
        Objects.requireNonNull(color, "El color no puede ser nulo.");
        if(color == Color.BLANCO){
            posicion = new Posicion(1, 'e');
        } else if (color == Color.NEGRO) {
            posicion = new Posicion(8, 'e');
        }else {
            throw new IllegalArgumentException("El color no es permitido.");
        }
    }

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
