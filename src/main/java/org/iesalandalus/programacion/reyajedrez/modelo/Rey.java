package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;
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
        //Objects.requireNonNull(color, "El color no puede ser nulo.");
        setColor(color);
        if(color == Color.BLANCO){
            posicion = new Posicion(1, 'e');
        } else {
            posicion = new Posicion(8, 'e');
        }
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        this.color = Objects.requireNonNull(color, "El color del Rey no puede ser nulo.");
        if (color != Color.BLANCO && color != Color.NEGRO) {
            throw new IllegalArgumentException("El color del Rey no es válido.");
        }
    }

    public Posicion getPosicion() {
        return posicion;
    }

    private void setPosicion(Posicion posicion) {
        this.posicion = Objects.requireNonNull(posicion, "La posición del Rey no puede ser nula.");

    }

    public void mover(Direccion direccion) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("La dirección no puede ser nula.");
        }

        comprobarEnroque(direccion);
        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();
        try {
            posicion = new Posicion(nuevaFila, nuevaColumna);
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("Movimiento no válido: " + e.getMessage());
        }

        totalMovimientos++;
    }

    private void comprobarEnroque(Direccion direccion){
         if ((direccion == Direccion.ENROQUE_CORTO ||
                 direccion == Direccion.ENROQUE_LARGO) && totalMovimientos > 0){
            throw new IllegalArgumentException("Movimiento no válido.");
         }
    }

    @Override
    public String toString() {
        return String.format("Rey[color=%s, posición=%s]", this.color, this.posicion);
    }
}
