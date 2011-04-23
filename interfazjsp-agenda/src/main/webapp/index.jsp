<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>interfazweb-sawady</title>
	</head>
<body>

	<h1>HAKUNA MATATA, UNA FORMA DE SER</h1>
	
	<form method="get" action="search">
		<input type="text" name="titulo" value="${param.titulo}" />
		<input type="submit" value="Buscar"/>
	</form>
	
	<h2>Respuestas:</h2>	
	<c:if test="${requestScope.tituloResult != null}">
	<a href="http://www.google.com">${requestScope.tituloResult}</a>
	</c:if>
		
</body>
</html>