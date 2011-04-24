<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<title>Editar Contacto: ${contacto.nombre} </title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>

<body>
	<center>
		<h2>Datos del Nuevo Contacto:</h2>

		<form method="post" action="crearContacto">
		
			Nombre: <input type="text" name="nombre"/>
			<br />
			
			Telefono: <input type="text" name="telefono"/>
			<br />
			
			Mail: <input type="text" name="mail"/>
			<br />
			
			Ciudad: <input type="text" name="ciudad"/>
			<br />
			
			<br /> 
			Observaciones: <br /> 
			<textarea name="observaciones" rows="5" cols="60"></textarea>
			<br />
						
			<input type="submit" value="Aceptar"/>
		</form>
		
		<br />		
	</center>
</body>
</html>