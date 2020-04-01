package com.pruebaGroovy

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:'equipo')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
