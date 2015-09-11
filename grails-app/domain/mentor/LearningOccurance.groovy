package mentor

class LearningOccurance {
	static belongsTo = [student: Participant, instructionalSession: InstructionalSession]
	
    static constraints = {
    }
	
	static mapping = {
		table 'mentor_learning_occurance'
		version false
	}

	String toString() {
		instructionalSession.toString() + " : " + student.toString()
	}
	
	int score() {
		Math.round(instructionalSession.minutes * scorePerMinute())
	}
	
	private scorePerMinute() {
		10 / 15
	}
}
