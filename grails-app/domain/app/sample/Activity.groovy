package app.sample

import grails.neo4j.Neo4jEntity
import grails.persistence.Entity

@Entity
class Activity implements Neo4jEntity<Activity> {

    static mapWith = "neo4j"

    String description

    static constraints = {
        description nullable: false
    }
}
