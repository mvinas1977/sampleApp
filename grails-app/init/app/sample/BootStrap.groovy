package app.sample

class BootStrap {

    def init = { servletContext ->

        Person.withNewSession {
            Person.withNewTransaction {
                List<Phone> phones = Phone.list()
                List<Activity> activities = Activity.list()
                List<Person> persons = Person.list()

                if (phones) {
                    Phone.deleteAll(phones)
                }

                if (activities) {
                    Activity.deleteAll(activities)
                }

                if (persons) {
                    Person.deleteAll(persons)
                }

                Phone phone3 = new Phone(number: '4451-1227')
                Phone phone4 = new Phone(number: '4452-1227')
                Phone phone5 = new Phone(number: '4453-1227')

                Person p1 = new Person(name: 'Person 1', principalActivity: new Activity(description: 'Jobless'))
                p1.addToPhones(number: '3333-2122')
                p1.secondaryActivies = [new Activity(description: 'fishing'), new Activity(description: 'photography')]
                p1.save(failOnError: true)

                Person p2 = new Person(name: 'Person 2')
                p2.addToPhones(phone3)
                p2.addToPhones(phone4)

                Person p3 = new Person(name: 'Person 3')

                Person p4 = new Person(name: 'Person 4')

                //Creates a dynamic association one to one
                p4.mainPhone = phone5

                p2.save()
                p3.save()
                p4.save()
            }
        }
    }

    def destroy = {
    }
}
