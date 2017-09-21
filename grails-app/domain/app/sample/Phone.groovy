package app.sample

import grails.persistence.Entity

@Entity
class Phone {

    static mapWith = "neo4j"
    
    String number

    static belongsTo = [person:Person]

    static constraints = {
        number nullable: false, blank: false
    }
}
