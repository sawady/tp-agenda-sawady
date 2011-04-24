<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<title>Detalle Contacto: ${contacto.nombre} </title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>

	<body>
		<center>
			<h2>Detalle de Contacto</h2>
			<table>
				<tr>
					<th>Nombre</th>
					<td>${contacto.nombre}</td>
				</tr>
				<tr>
					<th>Telefono</th>
					<td>${contacto.telefono}</td>
				</tr>
				<tr>
					<th>Mail</th>
					<td>${contacto.mail}</td>
				</tr>
				<tr>
					<th>Ciudad</th>
					<td>${contacto.ciudad.nombre}</td>
				</tr>
				<tr>
					<th>Observaciones</th>
					<td>${contacto.observaciones}</td>
				</tr>
			</table>

			<br />
			<a href="search?">Volver</a>			
		</center>
	</body>
</html>
