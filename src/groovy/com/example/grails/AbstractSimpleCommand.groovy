package com.example.grails

import grails.validation.Validateable

/**
 * Created by marty on 7/5/16.
 */
@Validateable
abstract class AbstractSimpleCommand {

    /**
     * The controller providing context for the command, and serving as a
     * delegate to render a success response upon successful processing.
     */
    protected SimpleCommandController delegate

    /**
     * Do something interesting to process the command.
     */
    abstract protected void process()

    /**
     * Render a success response, including the status code, headers, response
     * body, etc. using the controller in the current command context.
     */
    abstract protected void renderSuccess()

    /**
     * Used to execute the command in a controller context, typically
     * from a SimpleCommandController instance.
     *
     * @throws Exception
     */
    public void run() throws Exception {
        process()
        renderSuccess()
    }

    public AbstractSimpleCommand withController(SimpleCommandController controller) {
        this.delegate = controller
        return this
    }
}
