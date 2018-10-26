import petstore.Pet

model {
	Pet pet
}
xmlDeclaration()
pet {
	name pet.name
	dateOfBirth pet.dateOfBirth
	type pet.type
	breed pet.breed
	isMale pet.isMale
	weight pet.weight
	cost pet.cost
	store pet.store
}
