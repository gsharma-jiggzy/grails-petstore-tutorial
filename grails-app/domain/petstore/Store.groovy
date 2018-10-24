package petstore

class Store {

	String address
	String name

    static constraints = {
    	name(blank: false, nullable: false)
    	address(blank: false, nullable: false)
    }

    static mapping = {

    }
}
