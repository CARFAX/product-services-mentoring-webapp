package mentor

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class LearningOccuranceController {

    def scaffold = true
}
