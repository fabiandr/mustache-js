<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/resources/mustache.min.js" var="mustacheJs" />
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script src="${mustacheJs}"></script>
    <title>Titulo</title>
</head>
<body>
<%--<a href="/index/getusers">go to list</a>--%>
<div id="container">
    <script id="template" type="x-tmpl-mustache">
        <div id="users-table">
            <h2>{{title}}</h2>
            <h5>{{description}}</h5>
            <table>
                <tr>
                    <th>Apellidos</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                </tr>
                {{#personList}}
                <tr>
                    <td>{{surname}}</td>
                    <td>{{name}}</td>
                    <td>{{age}}</td>
                </tr>
                {{/personList}}
            </table>
        </div>
    </script>


</div>

<p id="target">loading...</p>

<script type="text/javascript">
    $(document).ready(function(){

        setTimeout(function(){

            $.get("/mustache_js_war/index/getusers", function(data, status){

                console.log('json: '+data);
                var template = document.getElementById('template').innerHTML;
                console.log('template --> '+template);
                var rendered = Mustache.render(template, data);
                document.getElementById('target').innerHTML = rendered;

            });
        }, 3000);


    })

</script>
</body>
</html>