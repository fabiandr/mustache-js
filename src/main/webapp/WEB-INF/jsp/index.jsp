<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/resources/js/nano/nano.min.js" var="nanoJs" />
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script src="${nanoJs}"></script>
    <title>Titulo</title>
</head>
<body>
<p style="width:100%; background-color:powderblue;">${message}</p>
<button id="getAssyncData">Get my info</button>
<p id="template" style="display: none">Hello {surname}, {name} Your age is {age} years</p>

<div id="tableContainer"></div>

<p id="result"></p>
<script type="text/javascript">
    $(document).ready(function(){

        $("#getAssyncData").click(function(){
            $.get("/nano_js_war/index/getuserinfo", function(data, status){
                var person = data;
                console.log('json: '+person);
                var template =  $("#template").text();
                console.log('template --> '+template);
                $("#result").html(nano(template, person));
            });
        });


    })

</script>
</body>
</html>