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

        def store1 = new Store(
            name: 'Petsmart',
            address: '1 way'
        ).save()
        def store2 = new Store(
            name: 'Pet Center',
            address: '2 rd'
        ).save()
        def store3 = new Store(
            name: 'Pet World',
            address: '3 Loop'
        ).save()

        new Pet(
            name: 'Luke',
            type: 'Jedi',
            store: store1
        ).save()
        new Pet(
            name: 'Yoda',
            type: 'Jedi',
            store: store1
        ).save()
        new Pet(
            name: 'Vader',
            type: 'Sith',
            store: store2
        ).save()
        new Pet(
            name: 'Palpatine',
            type: 'Sith',
            store: store2
        ).save()
        new Pet(
            name: 'Death Star',
            type: 'Starship',
            store: store3
        ).save()
        new Pet(
            name: 'Millenium Falcon',
            type: 'Starship',
            store: store3
        ).save()
    }
    def destroy = {
    }
}
