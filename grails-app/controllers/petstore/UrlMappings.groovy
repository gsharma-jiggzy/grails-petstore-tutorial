package petstore

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/api/pet(.$format)?"(resources:'pet')
        "/api/store(.$format)?"(resources:'store') {
            "/pet"(resources:'pet')
        }


        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
