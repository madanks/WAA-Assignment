<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guss Number</title>
</head>
<body>
	<H1>Guss Number</H1>
	<%
		String num = request.getParameter("inputnum");
		Integer rand = (int) (Math.random() * 10);
		//out.println(rand);
		if(num!=null){
			if(num.equals(Integer.toString(rand))){
				out.println("Congratulation !!! The number you entered is same as the random number");
			}else{
				out.println("Sorry !!! Try Again");
				
			}
		}

	%>

	<form action="" method="get">
		Enter a guess number <input id="inputnum"
			name="inputnum"> <input type="submit" id="btnGuess"
			name="btnGuess" value="Guess">
	</form>
</body>
</html>