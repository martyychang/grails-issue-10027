package com.example.grails

import grails.validation.Validateable

/**
 * Created by marty on 7/5/16.
 */
@Validateable
class SearchIndexCommand extends AbstractSimpleCommand {

    String comments

    @Override
    protected void process() {
        print "From the peanut gallery: ${comments}"
        print "TODO: grails run-app, then remove this line while running"
    }

    @Override
    protected void renderSuccess() {
        delegate.render status: 501
    }
}
