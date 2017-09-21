package app.sample

import grails.persistence.Entity

@Entity
class Person {

    static mapWith = "neo4j"

    String name

    static hasMany = [phones: Phone]
    
    static constraints = {
        name nullable: false, blank: false
    }

    static mapping = {
        dynamicAssociations true
        phones cascade: "all-delete-orphan"
    }
}
