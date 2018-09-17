package petstore

import com.iai.auth.*

class BootStrap {

    def init = { servletContext ->
    	def roleAdmin = SecRole.findOrCreateByAuthority("ROLE_ADMIN").save();
    	def roleUser = SecRole.findOrCreateByAuthority("ROLE_USER").save();

    	SecRole.findByAuthority("ROLE_ADMIN") ?: new SecRole(authority: "ROLE_ADMIN").save(failOnError: true)

    	def admin = SecUser.findByUsername("admin@petstore-iai.com") ?: new SecUser(
    		username: "admin@petstore-iai.com",
    		email: "admin@petstore-iai.com",
    		password: "#petstore#admin!",
    		enabled: true
    	).save(failOnError: true)
    	
    	def userRole = new SecUserSecRole(secUser: admin, secRole: roleUser).save()

    	if (!admin.authorities.contains(userRole)) {
    		SecUserSecRole.create(admin, roleAdmin).save()
    		SecUserSecRole.create(admin, roleUser).save()
    	}


    }
    def destroy = {
    }
}
