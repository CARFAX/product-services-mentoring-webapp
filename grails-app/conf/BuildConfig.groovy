//import org.apache.ivy.plugins.resolver.*
//import org.apache.ivy.core.settings.*

grails.project.work.dir = "C:\\grails-cache\\product-services-mentoring-webapp\\"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.dependency.resolution = {
    inherits("global") {
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
		grailsPlugins()
		grailsHome()
		grailsCentral()
    }
    dependencies {
        provided 'org.apache.ivy:ivy:2.2.0'
        runtime 'com.oracle:ojdbc5:11.1.0.7.0'
		runtime 'hsqldb:hsqldb:1.8.0.10'
    }
	plugins {
		runtime ":hibernate:$grailsVersion"
		runtime ":jquery:1.8.3"
		runtime ":resources:1.1.6"
		build ":tomcat:$grailsVersion"

		runtime ":database-migration:1.3.2"

		compile ':cache:1.0.1'

		compile ':spring-security-core:1.2.7.3'
		build ":tomcat:$grailsVersion"
		
	}

}

