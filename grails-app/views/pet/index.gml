import petstore.Pet

model {
    Iterable<Pet> petList
    Long petCount
}
xmlDeclaration()
pets {
    count petCount
    pets tmpl.pet(petList ?: [])
}

