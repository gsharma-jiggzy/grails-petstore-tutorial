package petstore

class Pet {

	String name
	String dateOfBirth
	String type
	String breed
	boolean isMale
	double weight
	double cost

    static constraints = {
    	name(blank: true, nullable: true)
    	dateOfBirth(blank: true, nullable: true)
    	type(blank: false, nullable: false)
    	breed(blank: true, nullable: true)
    	isMale(blank: false, nullable: false)
    	weight(blank: false, nullable: false)
    	cost(blank: false, nullable: false)
    }

    static mapping = {
    	// dateOfBirth defaultValue: 'CURRENT_TIMESTAMP'
    	isMale defaultValue: false
    	weight defaultValue: 0.0
    	cost defaultValue: 0.0
    }
}
