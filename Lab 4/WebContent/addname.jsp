<%@ page import="com.madan.waa.model.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="com.madan.waa.dao.PersonDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Name</title>
</head>
<body>

<button id="btnShow">Show all Names</button>
<div>
 <%
    List<Person> personlist = (List<Person>)((PersonDAO)session.getAttribute("personDAO")).getPersonList();
    if(personlist.size()>0) {
        out.print("<table border='1' cellspacing='0' ><th>Key</th><th>First Name</th><th>Last Name</th>");
        for (Person per : personlist) {
            out.print("<tr><td>" + per.getKey() + "</td>");
            out.print("<td>" + per.getFirstName() + "</td>");
            out.print("<td>" + per.getLastName() + "</td></tr>");
        }
        out.print("</table>");
    }
%>
</div>
<div>
    <form action="<%=request.getContextPath()%>/addNameController" method="post">
        Key=<input type="text" id="key" name="key">
        First Name=<input type="text" name="firstName">
        Last Name=<input type="text" name="lastName">
        <input type="submit" value="Add"/>
    </form>
</div>
<div>
    <form action="<%=request.getContextPath()%>/deleteNameServlet" method="post">
        Key=<input type="text" name="key">
        <input type="submit" value="Remove">
    </form>
</div>
</body>
</html>