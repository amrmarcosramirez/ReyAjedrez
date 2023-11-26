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

    public static int getTotalMovimientos() {
        return totalMovimientos;
    }

    public static void setTotalMovimientos(int totalMovimientos) {
        Rey.totalMovimientos = totalMovimientos;
    }

    public void mover(Direccion direccion) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("La dirección no puede ser nula.");
        }

        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();
        switch (direccion) {
            case NORTE, NORESTE, NOROESTE -> nuevaFila += 1;
            case SUR, SURESTE, SUROESTE -> nuevaFila -= 1;
            case ENROQUE_CORTO -> nuevaColumna = 'g';
            case ENROQUE_LARGO -> nuevaColumna = 'b';
            case OESTE -> {
                if (nuevaColumna == 'h'){
                    nuevaColumna = 'g';
                } else if (nuevaColumna == 'g'){
                    nuevaColumna = 'f';
                } else if (nuevaColumna == 'f'){
                    nuevaColumna = 'e';
                } else if (nuevaColumna == 'e'){
                    nuevaColumna = 'd';
                } else if (nuevaColumna == 'd'){
                    nuevaColumna = 'c';
                } else if (nuevaColumna == 'c'){
                    nuevaColumna = 'b';
                } else if (nuevaColumna == 'b'){
                    nuevaColumna = 'a';
                } else {
                    nuevaColumna = 'z';
                }
            }
            case ESTE -> {
                if (nuevaColumna == 'a'){
                    nuevaColumna = 'b';
                } else if (nuevaColumna == 'b'){
                    nuevaColumna = 'c';
                } else if (nuevaColumna == 'c'){
                    nuevaColumna = 'd';
                } else if (nuevaColumna == 'd'){
                    nuevaColumna = 'e';
                } else if (nuevaColumna == 'e'){
                    nuevaColumna = 'f';
                } else if (nuevaColumna == 'f'){
                    nuevaColumna = 'g';
                } else if (nuevaColumna == 'g') {
                    nuevaColumna = 'h';
                } else{
                    nuevaColumna = 'z';
                }
            }
        }
        try {
            comprobarEnroque(direccion);
            posicion = new Posicion(nuevaFila, nuevaColumna);
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException(e.getMessage());
        }
        setPosicion(posicion);
        setTotalMovimientos(totalMovimientos+1);
    }

    private void comprobarEnroque(Direccion direccion){
         if ((direccion == Direccion.ENROQUE_CORTO ||
                 direccion == Direccion.ENROQUE_LARGO) && getTotalMovimientos() > 0){
            throw new IllegalArgumentException("Movimiento no válido.");
         }
    }

    @Override
    public String toString() {
        return String.format("Rey[color=%s, posición=%s]", this.color, this.posicion);
    }
}
