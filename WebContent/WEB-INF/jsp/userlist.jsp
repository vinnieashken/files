<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		  <div align="center">
		  	<a href="${pageContext.request.contextPath}/logout">Logout</a>
		  </div>
  <div align="center">
  		<table border="1">
  		<tr>
  			<th>UserName</th>
  			<th>Email</th>
  		</tr>
  		
  		<c:forEach var="user" items="${userlist }" >
	  		<tr>
	  			<td>${user.username}</td>
	  			<td>${user.email}</td>
	  	    </tr>
  	    </c:forEach>
  	
  		</table>
  		<p>${specific.username } </p>
  </div>

</body>
</html>