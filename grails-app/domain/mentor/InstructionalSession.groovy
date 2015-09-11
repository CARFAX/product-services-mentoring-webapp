package mentor

class InstructionalSession {
	String title
	Date sessionDate
	int minutes

	static belongsTo = [instructor: Participant]
	
	static hasMany = [learningOccurances: LearningOccurance]


    static constraints = {
    }
	
	static mapping = {
		table 'mentor_instructional_session'

		version false
	}

	String toString() {
		"${title} - ${instructor.toString()} - ${sessionDate.format('MM/dd/yyyy')}"
	}
	
	int score() {
		def learningOccurances = LearningOccurance.findAllByInstructionalSession(this)
		learningOccurances*.score()?.sum()?:0
	}
}
