package mentor

class ReportController {

	def index = {
		def stats = [:]
		def timePeriods = TimePeriod.list(sort:"endDate", order:"desc")
		def participants
		def reportTitle
		
		if (params.id) {
			def department = Department.findByName(params.id)
			reportTitle = department.name
			participants = department ? Participant.findAllByDepartment(department) : []
		} else {
			reportTitle = 'All Departments'
			participants = Participant.list()
		}
		timePeriods.each {
			stats["${it.name}"] = [studentScore: participants*.studentScore(it).sum(), instructorScore: participants*.instructorScore(it).sum()]
		}
		[reportTitle: reportTitle, stats: stats]
	}
	
	def departmentLeaderboard = {
		def stats = [:]
		def currentQuarter = TimePeriod.currentQuarter()
		def departments = Department.list()
		def reportTitle = "${params.id.capitalize()} Leaderboard by Department for ${currentQuarter.name}"
		departments.each { department ->
			def participants = Participant.findAllByDepartment(department)
			def score
			if (params.id == 'instructor') {
				score = participants*.instructorScore(currentQuarter).sum()
			} else {
				score = participants*.studentScore(currentQuarter).sum()
			}
			stats["${department.name}"] = score
		}
		[reportTitle: reportTitle, stats:stats.sort{-it.value}]
	}
}
