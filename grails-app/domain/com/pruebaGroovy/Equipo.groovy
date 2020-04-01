package com.pruebaGroovy

class Equipo {

    String nombre
    String ciudad
    String estadio
    String escudo
    String entrenador
    static hasMany = [jugadores: Jugador]

    String toString() {
        nombre
    }

    static constraints = {
        nombre size: 5..40, blank: false, unique: true
        ciudad size: 5..30, blank: false
        estadio size: 5..30, blank: false
        escudo size: 5..255, blank: false
        entrenador size: 5..30, blank: false
    }
}
