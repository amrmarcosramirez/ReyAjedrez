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
        Objects.requireNonNull(color, "El color no puede ser nulo.");
        if(color == Color.BLANCO){
            posicion = new Posicion(1, 'e');
        } else if (color == Color.NEGRO) {
            posicion = new Posicion(8, 'e');
        } else {
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

    /*Crea el método mover que acepte como parámetro una Direccion.
    La dirección no puede ser nula o de lo contrario debe lanzar una
    excepción adecuada (NullPointerException o IllegalArgumentException)
    con el mensaje adecuado. Si no puede realizar dicho movimiento,
    debido a que el rey se sale del tablero o que no está permitido
    (mira las condiciones del enroque), se debe lanzar una excepción del
    tipo OperationNotSupportedException con un mensaje adecuado y no
    modificarán los atributos del rey. Si el movimiento si es válido,
    se modificará la posición actual del rey y se incrementará en uno
    el total de movimientos. Realiza un commit.

    El rey siempre debe estar en su posición original.
    El rey nunca debe haberse movido previamente, es decir, el total de
    movimientos realizados debe ser 0.
     */
    public void mover(Direccion direccion) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("La dirección no puede ser nula.");
        }

        if ((direccion == Direccion.ENROQUE_CORTO ||
                direccion == Direccion.ENROQUE_LARGO) && totalMovimientos > 0){
            throw new IllegalArgumentException("Movimiento no válido.");
        }

        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();
        try {
            posicion = new Posicion(nuevaFila, nuevaColumna);
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("Movimiento no válido: " + e.getMessage());
        }

        totalMovimientos++;
    }
}
