package app.sample

class PersonController {

    def index() { }

    def removePerson1Phone() {

        Person person1 = Person.findByName('Person 1')
        assert person1

        Phone phone = person1.phones.first()
        assert phone

        person1.removeFromPhones(phone)
        person1.save()

    }

    def setsToNullADynamicAssociation() {

        Person person1 = Person.findByName('Person 4')
        assert person1

        person1.mainPhone = null
        person1.save()

    }
}
