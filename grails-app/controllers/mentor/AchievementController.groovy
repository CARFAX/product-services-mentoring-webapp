package mentor

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class AchievementController {

    def scaffold = true
@Secured(['ROLE_ADMIN','ROLE_ANONYMOUS'])
    def viewImage = {
        def achievement = Achievement.get( params.id )
        byte[] image = achievement.image
        response.outputStream << image
    }
}
