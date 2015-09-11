package mentor

class SecRole {

	String authority

	static mapping = {
		table 'mentor_sec_role'
        cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
