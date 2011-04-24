<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Agenda: Contactos</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>
<body>

	<h1>Búsqueda de Contactos</h1>
	
	<form method="get" action="search">
	
		Nombre: <input type="text" name="nombre" value="${param.nombre}"/>
		<br />
		
		Telefono: <input type="text" name="telefono" value="${param.telefono}" />
		<br />
		
		Mail: <input type="text" name="mail" value="${param.mail}" />
		<br />
		
		Ciudad: <input type="text" name="ciudad" value="${param.ciudad}" />
		<br />
		
		<input type="submit" value="Buscar"/>
	</form>
	
	<a href="crearContacto.jsp">Crear un contacto nuevo</a>
	
	<c:if test="${requestScope.contactos != null}" >
		<h2>Contactos encontrados:</h2>
		<table>
			<tr>
				<th>Nombre</th>
				<th>Tel</th>
				<th>Mail</th>
				<th>Ciudad</th>
				<th>Acciones</th>
			</tr>
			<c:forEach items="${requestScope.contactos}" var="contacto" varStatus="status">
				<tr>
					<td>${contacto.nombre}</td>
			    	<td>${contacto.telefono}</td>
			    	<td>${contacto.mail}</td>
			    	<td>${contacto.ciudad}</td>
					<td><a href="detalleContacto?id=${contacto.id}">mas info</a>
					<a href="editarContacto?id=${contacto.id}">editar</a>
					<a href="borrarContacto?id=${contacto.id}">borrar</a></td>
			    </tr>
			</c:forEach>
		</table>
		
		<form method="post" action="search">
		
		<input type="submit" value="Limpiar Búsqueda"/>
		
		</form>
		
	</c:if>
		
</body>
</html>