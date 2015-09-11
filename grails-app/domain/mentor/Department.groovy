package mentor

class Department {
	String name
	
    static constraints = {
    }
	
	static mapping = {
        sort "name"
		table 'mentor_department'
		version false
	}
	
	String toString() {
		name
	}
}
