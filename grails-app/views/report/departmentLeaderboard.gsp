<%@ page import="mentor.TimePeriod" %>

<html>
<head>
    <meta name='layout' content='main'/>
    <title>${reportTitle}</title>
</head>

<body>
<div>
    <div class='inner'>
        <h1>${reportTitle}</h1>
        <table>
            <thead>
                <tr>
                    <th width='100px'>Score</th>
                    <th>Department</th>
                </tr>
            </thead>
	        <g:each in="${stats}" var="department">
	           <tr>
	               <td>${department.value}</td>
	               <td>${department.key}</td>
	           </tr>
	        </g:each>
        </table>
    </div>
</div>
</body>
</html>