package petstore

import grails.gorm.services.Service

@Service(Pet)
interface PetService {

    Pet get(Serializable id)

    Pet findByName(String name)

    List<Pet> list(Map args)

    Long count()

    void delete(Serializable id)

    Pet save(Pet pet)

}
