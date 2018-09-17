package petstore

class Store {

	//String uuid = UUID.getRandomUUID().toString()
	String address
	String name

    static constraints = {
    	name(blank: false, nullable: false)
    	address(blank: false, nullable: false)
    }

    static hasHany = [
    	inventory: Pet
    ]

    static mapping = {

    }
}
