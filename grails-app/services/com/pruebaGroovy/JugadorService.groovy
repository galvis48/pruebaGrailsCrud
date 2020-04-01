package com.pruebaGroovy

import grails.gorm.services.Service

@Service(Jugador)
interface JugadorService {

    Jugador get(Serializable id)

    List<Jugador> list(Map args)

    Long count()

    void delete(Serializable id)

    Jugador save(Jugador jugador)

}