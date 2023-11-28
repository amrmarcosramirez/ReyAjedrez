package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Rey {
    private static int totalMovimientos;
    private Color color;
    private Posicion posicion;

    public Rey(){
        totalMovimientos = 0;
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
            case NORTE -> nuevaFila += 1;
            case SUR -> nuevaFila -= 1;
            case ESTE -> nuevaColumna += 1;
            case OESTE -> nuevaColumna -= 1;
            case NORESTE -> {nuevaFila += 1; nuevaColumna += 1;}
            case NOROESTE -> {nuevaFila += 1; nuevaColumna -= 1;}
            case SURESTE -> {nuevaFila -= 1; nuevaColumna += 1;}
            case SUROESTE -> {nuevaFila -= 1; nuevaColumna -= 1;}
            case ENROQUE_CORTO -> nuevaColumna = 'g';
            case ENROQUE_LARGO -> nuevaColumna = 'c';
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
