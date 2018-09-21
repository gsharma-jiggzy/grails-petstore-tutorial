package petstore

import com.iai.auth.*

class BootStrap {

    def init = { servletContext ->
        def roleAdmin = SecRole.findOrCreateByAuthority("ROLE_ADMIN").save();
        def roleUser = SecRole.findOrCreateByAuthority("ROLE_USER").save();

        def admin = SecUser.findByUsername("admin@petstore.com") ?: new SecUser(
            username: "admin@petstore.com",
            password: "#petstore#admin!",
            enabled: true
        ).save(failOnError: true)

        def user = SecUser.findByUsername("petstore@petstore.com") ?: new SecUser(
            username: "petstore@petstore.com",
            password: "#petstore!",
            enabled: true
        ).save(failOnError: true)

        if (!admin.authorities.contains(roleAdmin)) {
            SecUserSecRole.create(admin, roleAdmin).save()
            SecUserSecRole.create(admin, roleUser).save()
        }

        if (!user.authorities.contains(roleAdmin)) {
            SecUserSecRole.create(user, roleUser).save()
        }


    }
    def destroy = {
    }
}
