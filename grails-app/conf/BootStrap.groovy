import grails.util.GrailsUtil
import grails.util.Environment
import mentor.*
import grails.plugins.springsecurity.SpringSecurityService
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.StringUtils

class BootStrap {
    def springSecurityService

    def init = { servletContext ->

        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)

        def adminUser = SecUser.findByUsername('changeme') ?: new SecUser(
                username: 'changeme',
                password: 'changeme',
                enabled: true).save(failOnError: true)
        println adminUser.username
        println adminUser.password
        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }

        if ( Environment.getCurrent().equals(Environment.DEVELOPMENT)){
        	def thisQuarter = new TimePeriod(name: 'FY99Q1', startDate: new Date() - 25, endDate: new Date() + 30, goal: 1400).save(failOnError: true)
			def lastQuarter = new TimePeriod(name: 'FY98Q4', startDate: new Date() - 75, endDate: new Date() - 26, goal: 1000).save(failOnError: true)
			
			new Achievement(description: 'unrealized potential', minimumScore: 0, type: AchievementType.PARTICIPATION, imageName: 'egg.svg').save(failOnError: true)
			new Achievement(description: 'level 1 student', minimumScore: 50, maximumScore: 99, type: AchievementType.STUDENT, imageName: 'jogger.png', timePeriod: thisQuarter).save(failOnError: true)
			new Achievement(description: 'level 2 student', minimumScore: 100, type: AchievementType.STUDENT, imageName: 'runner.png', timePeriod: thisQuarter).save(failOnError: true)
			new Achievement(description: 'level 1 teacher', minimumScore: 50, maximumScore: 99, type: AchievementType.INSTRUCTOR, imageName: 'assistantCoach.png', timePeriod: thisQuarter).save(failOnError: true)
			new Achievement(description: 'level 2 teacher', minimumScore: 100, type: AchievementType.INSTRUCTOR, imageName: 'headCoach.png', timePeriod: thisQuarter).save(failOnError: true)

			def ps = new Department(name: 'Product Services').save(failOnError: true)
			def ds = new Department(name: 'Data Services').save(failOnError: true)

			def mike = new Participant(name: 'Mikey Smith', active: true, department: ps).save(failOnError: true)
			def jeff = new Participant(name: 'Jeff Smith', active: true, department: ps).save(failOnError: true)
			def ryan = new Participant(name: 'Ryan Smith', active: true, department: ps).save(failOnError: true)
			def shane = new Participant(name: 'Shane Smith', active: true, department: ds).save(failOnError: true)
			def newGuy = new Participant(name: 'New Smith', active: true, department: ps).save(failOnError: true)
			def superLazyGuy = new Participant(name: 'Lazy Guy', active: true, department: ps).save(failOnError: true)
			def photoshop = new InstructionalSession(title: 'Photoshop', sessionDate: new Date() - 10, minutes: 60, instructor: jeff).save(failOnError: true)
			def groovy = new InstructionalSession(title: 'Groovy', sessionDate: new Date() - 20, minutes: 30, instructor: shane).save(failOnError: true)
			def qunit = new InstructionalSession(title: 'QUnit', sessionDate: new Date() - 30, minutes: 45, instructor: ryan).save(failOnError: true)

			mike.addToLearningOccurances(new LearningOccurance(instructionalSession: groovy))
			mike.addToLearningOccurances(new LearningOccurance(instructionalSession: photoshop))
			mike.addToLearningOccurances(new LearningOccurance(instructionalSession: qunit))
			shane.addToLearningOccurances(new LearningOccurance(instructionalSession: qunit))
			ryan.addToLearningOccurances(new LearningOccurance(instructionalSession: photoshop))

            20.times { createParticipant(ps, photoshop) }
		}
	}

    private static void createParticipant(dept, session) {
        def bob = new Participant(name: 'BOB ' + RandomStringUtils.random(5), active: true, department: dept).save(failOnError: true)
        bob.addToLearningOccurances(new LearningOccurance(instructionalSession: session))
    }

	def destroy = {
	}
}
