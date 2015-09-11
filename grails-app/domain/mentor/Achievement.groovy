package mentor

class Achievement {
	String description
	Integer minimumScore
	Integer maximumScore
	AchievementType type
	String imageName
	TimePeriod timePeriod
    byte[] image
	
    static constraints = {
		description()
		type()
		timePeriod nullable:true
		minimumScore()
		maximumScore nullable:true
		imageName()
        image maxSize: 1024 * 1024 * 2, nullable: true
    }
	
	static mapping = {
		table 'mentor_achievement'
		version false
	}
	
	String toString() {
		description
	}
	
	boolean isEarned(Participant participant) {
		if (type == AchievementType.PARTICIPATION) {
			return false
		}
		def pointsInTimePeriod = type == AchievementType.STUDENT ? participant.studentScore(timePeriod) : participant.instructorScore(timePeriod)
		pointsInTimePeriod >= minimumScore && (pointsInTimePeriod <= maximumScore || !maximumScore)
	}
	
	static Achievement participationAward() {
		Achievement.findByType(AchievementType.PARTICIPATION)
	}
}

enum AchievementType {
	STUDENT, INSTRUCTOR, PARTICIPATION
}
