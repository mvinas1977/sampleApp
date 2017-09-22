package app.sample

import grails.gorm.transactions.Transactional

@Transactional
class PersonController {

    def index() {}

    def removePerson1Phone() {

        Person person1 = Person.findByName('Person 1')
        assert person1

        Phone phone = person1.phones.first()
        assert phone

        person1.removeFromPhones(phone)
        person1.save()

    }

    def removeOneToOneAssociation() {

        Person person1 = Person.findByName('Person 1')
        assert person1

        assert person1.principalActivity

        person1.principalActivity = null
        person1.save()
    }

    def addsANewPhoneToPerson1() {

        Person person1 = Person.findByName('Person 1')
        assert person1

        Phone aPhone = Phone.findByNumber('4452-1227')
        assert aPhone

        assert person1.principalActivity

        person1.addToPhones(number: '6777-8821')
        person1.addToPhones(aPhone)
        person1.save()
    }

    def changeOneToOneAssociation() {

        Person person1 = Person.findByName('Person 1')
        assert person1

        assert person1.principalActivity

        person1.principalActivity = new Activity(description: "other activity")
        person1.save()
    }

    def setsRemoveADynamicOneToOneAssociation() {

        Person person4 = Person.findByName('Person 4')
        assert person4

        assert person4.mainPhone

        person4.mainPhone = null
        person4.save()

    }

    def removesADynamicOneToManyAssociationSettingToNull() {

        Person person4 = Person.findByName('Person 1')
        assert person4

        assert person4.secondaryActivies

        person4.secondaryActivies = null
        person4.save()

    }

    def updatesPerson1Name() {
        Person person1 = Person.findByName('Person 1')

        person1.name = 'Person One'
        person1.save()
    }

    /*
     * Validates issue 
     */

    def removesADynamicOneToManyAssociationClearingIt() {

        Person person4 = Person.findByName('Person 1')
        assert person4

        assert person4.secondaryActivies

        person4.secondaryActivies.clear()
        person4.save()

    }

    def checkLazyLoading() {

        log.debug("Starting lazy loading check....")
        Person person1 = Person.findByName('Person 1')
        assert person1
        log.debug('person1 loaded')
        log.debug("\naccessing principalActivity (one to one defined by a property) ...\n")
        log.debug(person1.principalActivity.toString())
        log.debug("\naccessing phones (one to many defined by a property) ...\n")
        log.debug(person1.phones.toString())
        log.debug("\naccessing secondaryActivies (one to many dynamic)...\n")
        log.debug(person1.secondaryActivies.toString())
        log.debug("\nend first run accessing properties again to validate that there is no additional queries executed\n")
        log.debug(person1.principalActivity.toString())
        log.debug(person1.phones.toString())
        log.debug(person1.secondaryActivies.toString())
        log.debug("END. Good Bye")
        respond(message: 'ok')
    }
}