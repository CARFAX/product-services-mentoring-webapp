import grails.converters.JSON
import mentor.Department
import mentor.InstructionalSession
import mentor.LearningOccurance
import mentor.Participant

class ExportController {

    def department = {
        render Department.list() as JSON
    }
    def participant={
        render Participant.list() as JSON
    }
    def instructionalSession={
        render InstructionalSession.list() as JSON
    }
    def learningOccurance={
        render  LearningOccurance.list() as JSON
    }
    def index={}


}
