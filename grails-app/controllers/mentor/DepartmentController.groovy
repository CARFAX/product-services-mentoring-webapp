package mentor

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class DepartmentController {
	def scaffold = true
}
