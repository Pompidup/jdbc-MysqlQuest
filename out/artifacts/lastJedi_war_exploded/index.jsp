<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Maitre Yoda</title>
</head>
<body>
<h1>JEDI LIST FOR JDBC QUEST</h1>
<%
    String[] name = (String[]) request.getAttribute("names");
    String[] surname = (String[]) request.getAttribute("surnames");

    int loop = name.length;

%>
<% if (loop > 1) { %>
<p> Il y a actuellement <% out.println(loop);%> Jedis dans la base</p>
<% } else { %>
<p> Il y a actuellement <% out.println(loop);%> Jedis dans la base</p>
<% } %>
<ul>
    <% for (int i = 0; i < loop; i++) { %>
    <li>Name : <% out.println(name[i]);%>
        , Surname : <% out.println(surname[i]);%>
    </li>
    <%}%>
</ul>

</body>
</html>