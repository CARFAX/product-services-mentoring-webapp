<html>
    <head>
    </head>
    <body>
        <ul>
            <h2>Mentor Program World:</h2>
            <li>
                <g:link controller="dashboard">Overall Dashboard</g:link>
            </li>
            <li>
                <g:link controller="report">Overall Quarterly Report</g:link>
            </li>
            <li>
                <g:link controller="report" action="departmentLeaderboard" id="instructor">Instructor Leaderboard by Department</g:link>
            </li>
            <li>
                <g:link controller="report" action="departmentLeaderboard" id="student">Student Leaderboard by Department</g:link>
            </li>
            
            <h2>Departments:</h2>
            <g:each in="${mentor.Department.list()}" var="department">
                <li> ${department.name}
                (
                    <g:link controller="dashboard" action="index" id="${department.name}">Dashboard</g:link> ,
                    <g:link controller="report" action="index" id="${department.name}">Report</g:link> 
                )
                </li>
            </g:each>
            <h2>Data Entry:</h2>
            <li><g:link controller="department">Department</g:link></li>
            <li><g:link controller="participant">Participants</g:link></li>
            <li><g:link controller="instructionalSession">Instructional Sessions</g:link></li>
            <li><g:link controller="learningOccurance">Learning Occurances</g:link></li>
            <li><g:link controller="achievement">Achievements</g:link></li>
            <li><g:link controller="timePeriod">Time Periods</g:link></li>
            <li><g:link controller="export">Export</g:link></li>
        </ul>
    </body>
</html>