package sampleapp

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = ['app.sample'])
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }
}