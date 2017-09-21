package app.sample

import grails.persistence.Entity

@Entity
class Person {

    static mapWith = "neo4j"

    String name
    Activity principalActivity

    static hasMany = [phones: Phone]
    
    static constraints = {
        name nullable: false, blank: false
        principalActivity nullable: true
    }

    static mapping = {
        dynamicAssociations true
        phones cascade: "all-delete-orphan"
    }
}
