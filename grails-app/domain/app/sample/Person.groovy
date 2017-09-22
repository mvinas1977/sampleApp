package app.sample

import grails.neo4j.Neo4jEntity
import grails.persistence.Entity

@Entity
class Person implements Neo4jEntity<Person> {

    static mapWith = "neo4j"

    String name
    Activity principalActivity
    Date lastUpdated
    Date dateCreated
    
    static hasMany = [phones: Phone]

    static constraints = {
        name nullable: false, blank: false
        principalActivity nullable: true
    }

    static mapping = {
        dynamicAssociations true
        phones cascade: "all-delete-orphan" //, lazy: false, fetch: "eager"
    }
}
