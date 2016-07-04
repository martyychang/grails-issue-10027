package com.example.grails

class SearchController extends SimpleCommandController {

    def index(SearchIndexCommand cmd) {
        print(cmd.comments)
        execute(cmd)
    }
}
