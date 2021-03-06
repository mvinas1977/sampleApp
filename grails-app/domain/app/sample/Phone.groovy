package app.sample

import grails.neo4j.Neo4jEntity
import grails.persistence.Entity

@Entity
class Phone implements Neo4jEntity<Phone> {

    static mapWith = "neo4j"
    
    String number

    static belongsTo = [person:Person]

    static constraints = {
        number nullable: false, blank: false
    }
}
