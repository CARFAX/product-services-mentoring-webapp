package mentor

import grails.plugins.springsecurity.Secured
@Secured(['ROLE_ADMIN'])
class AdminController {

    def index = { }
}
