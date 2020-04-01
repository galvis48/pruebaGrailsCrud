package com.pruebaGroovy

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class JugadorServiceSpec extends Specification {

    JugadorService jugadorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Jugador(...).save(flush: true, failOnError: true)
        //new Jugador(...).save(flush: true, failOnError: true)
        //Jugador jugador = new Jugador(...).save(flush: true, failOnError: true)
        //new Jugador(...).save(flush: true, failOnError: true)
        //new Jugador(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //jugador.id
    }

    void "test get"() {
        setupData()

        expect:
        jugadorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Jugador> jugadorList = jugadorService.list(max: 2, offset: 2)

        then:
        jugadorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        jugadorService.count() == 5
    }

    void "test delete"() {
        Long jugadorId = setupData()

        expect:
        jugadorService.count() == 5

        when:
        jugadorService.delete(jugadorId)
        sessionFactory.currentSession.flush()

        then:
        jugadorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Jugador jugador = new Jugador()
        jugadorService.save(jugador)

        then:
        jugador.id != null
    }
}
