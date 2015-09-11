<html>
<head>
    <meta name='layout' content='main'/>
    <title>Department Report</title>
</head>

<body>
<div>
    <div class='inner'>
        <h1>${reportTitle}</h1>
        <g:each in="${stats}" var="quarter">
            <h2>${quarter.key }</h2>
            <h3>Student Score: ${quarter.value.studentScore}</h3>
            <h3>Instructor Score: ${quarter.value.instructorScore}</h3>
            <br/>
        </g:each>
    </div>
</div>
</body>
</html>
