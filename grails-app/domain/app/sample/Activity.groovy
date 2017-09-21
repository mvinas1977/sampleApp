package app.sample

import grails.persistence.Entity

@Entity
class Activity {

    static mapWith = "neo4j"

    String description

    static constraints = {
        description nullable: false
    }
}
