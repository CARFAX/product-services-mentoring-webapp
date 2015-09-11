package mentor

class TimePeriod {
	String name
	Date startDate
	Date endDate
	int goal
	
	String toString() {
		name
	}
	static constraints= {
		name()
		goal() 
		startDate()
		endDate()
	}
	
	static mapping = {
		table 'mentor_time_period'
		version false
	}
	
	boolean contains(Date date) {
		date >= startDate && date <= endDate
	}
	
	static TimePeriod currentQuarter() {
		TimePeriod.findAllByStartDateLessThanEqualsAndEndDateGreaterThanEquals(new Date(), new Date()).find{it.name.contains('Q')}
	}
}
