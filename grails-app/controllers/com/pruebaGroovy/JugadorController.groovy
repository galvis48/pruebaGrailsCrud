package com.pruebaGroovy

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class JugadorController {

    JugadorService jugadorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond jugadorService.list(params), model:[jugadorCount: jugadorService.count()]
    }

    def show(Long id) {
        respond jugadorService.get(id)
    }

    def create() {
        respond new Jugador(params)
    }

    def save(Jugador jugador) {
        if (jugador == null) {
            notFound()
            return
        }

        try {
            jugadorService.save(jugador)
        } catch (ValidationException e) {
            respond jugador.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'jugador.label', default: 'Jugador'), jugador.id])
                redirect jugador
            }
            '*' { respond jugador, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond jugadorService.get(id)
    }

    def update(Jugador jugador) {
        if (jugador == null) {
            notFound()
            return
        }

        try {
            jugadorService.save(jugador)
        } catch (ValidationException e) {
            respond jugador.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'jugador.label', default: 'Jugador'), jugador.id])
                redirect jugador
            }
            '*'{ respond jugador, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        jugadorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'jugador.label', default: 'Jugador'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'jugador.label', default: 'Jugador'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
