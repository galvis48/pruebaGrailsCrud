package com.pruebaGroovy

class Jugador {

    static belongsTo = [equipo: Equipo]
    String nombre
    Integer edad
    String posicion

    String toString(){
        nombre
    }


    static constraints = {
        nombre size: 5..40, blank: false
        edad min: 16
        posicion size: 5..40, blank: false
    }
}
