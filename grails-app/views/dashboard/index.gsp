<%@ page import="mentor.TimePeriod" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${resource(dir:'css',file:'dashboard.css')}" />
	    <script type='text/javascript' src='https://www.google.com/jsapi'></script>
	    <script type='text/javascript'>
	      google.load('visualization', '1', {packages:['gauge']});
	      google.setOnLoadCallback(drawChart);
	      function drawChart() {
	        var data = google.visualization.arrayToDataTable([
	          ['Label', 'Value'],
	          ["${currentQuarter.name}", ${participants*.studentScore(currentQuarter).sum()?:0}]
	        ]);
	        
	        var options = {
	          width: 300, height: 300,
	          max: ${graphStats.max},
	          redFrom: ${graphStats.redFrom}, redTo: ${graphStats.redTo},
	          yellowFrom:${graphStats.yellowFrom}, yellowTo: ${graphStats.yellowTo},
	          greenFrom: ${graphStats.greenFrom}, greenTo: ${graphStats.greenTo},
	          majorTicks: ["0","${graphStats.max}"], 
	          minorTicks: ${graphStats.max/100}
	        };
	
	        var chart = new google.visualization.Gauge(document.getElementById('chart_div'));
	        chart.draw(data, options);
	      }
	    </script>
    </head>
    <body>
        <div class="container dashboard">
            <h1>${params.filter?.capitalize()} Mentor Heroes</h1>
	        <g:each var="participant" in="${participants}">
	            <div class="nameTag">
	                <div class="participantName">
		                <g:link controller="participant" action="show" id="${participant.id}">${participant.name}</g:link>
	                </div>
                    <div class="badges">
                        <ul>
                            <g:each var="achievement" in="${participant.achievements()}">
                                <li>
                                    <g:link controller="achievement" action="show" id="${achievement.id}">
                                        <g:if test="${achievement.image}">
                                            <img src="${createLink(controller:'achievement', action:'viewImage', id:"${achievement.id}")}" />
                                        </g:if>
                                        <g:else>
                                            <img src="${g.resource(dir: 'images/badges', file:achievement.imageName)}"/>
                                        </g:else>
                                    </g:link>
                                </li>
                            </g:each>
                        </ul>
	                </div>
                    <div class="scores">
                        <span class='student'>Student: ${participant.studentScore(currentQuarter)}</span>
                        <span class='instructor'>Instructor: ${participant.instructorScore(currentQuarter)}</span>
                    </div>
	            </div>
	        </g:each>
            <div class="clear"></div>

            <g:if test="${params.showGauge != 'false'}" >
                <div class="summary">
                    <div id='chart_div'></div>
                </div>
            </g:if>

        </div>
    </body>
</html>