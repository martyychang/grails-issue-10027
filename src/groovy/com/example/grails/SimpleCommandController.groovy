package com.example.grails

import grails.artefact.Artefact

/**
 * Created by marty on 7/5/16.
 */
@Artefact("Controller")
class SimpleCommandController {
    static responseFormats = ['json']

    void execute(AbstractSimpleCommand cmd) {

        // When this line below is present, the project builds for the first
        // time with `grails run-app`. But if any modifications are made to
        // a command object while the app is running, the compilation will
        // appear to succeed, but then when the app hits this line of code it
        // will throw the "Cannot set readonly property: properties" exception.
        cmd.properties = params

        try {
            if (cmd.validate()) {
                cmd.withController(this).run()
            }
            else {
                respond cmd.errors
            }
        }
        catch (Exception e) {
            print e.getStackTrace()
            render status: 500
        }
    }
}
