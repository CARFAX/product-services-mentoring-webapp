package mentor

class Participant {

	String name
	boolean active = true
	Department department
	
	static hasMany = [
		learningOccurances: LearningOccurance,
		teachingOccurances: InstructionalSession
	]

    static constraints = {
    }

	static mapping = {

        sort "name"
    	learningOccurances: lazy: false
		teachingOccurances: lazy: false
		table 'mentor_participant'
		version false

	}

	int studentScore(TimePeriod timePeriod = null) {
		def occurances = timePeriod ? learningOccurances.findAll{timePeriod.contains(it.instructionalSession.sessionDate)} : learningOccurances
		occurances*.score()?.sum()?:0
	}

	int instructorScore(TimePeriod timePeriod = null) {
		def occurances = timePeriod ? teachingOccurances.findAll{timePeriod.contains(it.sessionDate)} : teachingOccurances
		occurances*.score()?.sum()?:0
	}

	List<Achievement> achievements() {
        lifetimeAchievements() ?: (isCurrentParticipation() ? [Achievement.participationAward()] : [])
	}

    List<Achievement> lifetimeAchievements() {
        Achievement.list().findAll{it.isEarned(this)}
    }

    boolean isCurrentParticipation() {
        def thisQuarter = TimePeriod.currentQuarter()
        studentScore(thisQuarter) || instructorScore(thisQuarter)
    }

	String toString() {
		name
	}
    InstructionalSession mostRecentSession() {
        def studentSessions = learningOccurances*.instructionalSession
        def teachingSessions = teachingOccurances
        studentSessions || teachingSessions ? (studentSessions + teachingSessions).sort { -it.sessionDate.time }.first() : null
    }
}
