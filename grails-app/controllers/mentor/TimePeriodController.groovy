package mentor

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class TimePeriodController {

	def scaffold = true
}
