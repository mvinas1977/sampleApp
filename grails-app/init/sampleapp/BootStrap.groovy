package sampleapp

import app.sample.Person
import app.sample.Phone

class BootStrap {

    def init = { servletContext ->

        Phone phone2 = new Phone(number: '2212-1212')
        Phone phone3 = new Phone(number: '4452-1227')
        Phone phone4 = new Phone(number: '4452-1227')

        Person p1 = new Person(name: 'Person 1')
        p1.addToPhones(number: '3333-2122')

        Person p2 = new Person(name: 'Person 2')
        p2.addToPhones(phone2)
        p2.addToPhones(phone3)

        Person p3 = new Person(name: 'Person 3')

        Person p4 = new Person(name: 'Person 4')
        //Creates a dynamic association one to one
        p4.mainPhone = phone4

        p1.save()
        p2.save()
        p3.save()
        p4.save()
    }
    def destroy = {
    }
}
