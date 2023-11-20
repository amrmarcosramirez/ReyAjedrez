package org.iesalandalus.programacion.reyajedrez.modelo;

public enum Direccion {
    NORTE("Norte"),
    NORESTE("Noreste"),
    ESTE("Este"),
    SURESTE("Sureste"),
    SUR("Sur"),
    SUROESTE("Suroeste"),
    OESTE("Oeste"),
    NOROESTE("Noroeste"),
    ENROQUE_CORTO("Enroque corto"),
    ENROQUE_LARGO("Enroque largo");

    private String cadenaAMostrar;

    private Direccion(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
