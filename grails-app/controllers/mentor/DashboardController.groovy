package mentor

class DashboardController {

    def index = {
		def participants
		
		if (params.id) {
			def department = Department.findByName(params.id)
			participants = department ? Participant.findAllByDepartment(department) : []
		} else {
			participants = Participant.list()
		}

        def participantsWithAchievements = participants.findAll{it.active && it.achievements().size() > 0}
        def relevantParticipants = params.filter == 'current' ? currentParticipants(participantsWithAchievements) : participantsWithAchievements
        def sortedParticipants = relevantParticipants.sort{ -(it.mostRecentSession()?.sessionDate?.time ?: 0 ) }
		[participants: sortedParticipants, graphStats: getGraphStats(), currentQuarter: TimePeriod.currentQuarter()]
	}

    private currentParticipants(participantsWithAchievements) {
        participantsWithAchievements.findAll{it.isCurrentParticipation()}
    }

	private getGraphStats() {
		def timePeriod = TimePeriod.currentQuarter()
		def goal = timePeriod.goal
		def firstThird = Math.round(goal/3)
		def secondThird = firstThird * 2
		[max: goal, redFrom: 0, redTo: firstThird, yellowFrom: firstThird, yellowTo: secondThird, greenFrom: secondThird, greenTo: goal]
	}
}
