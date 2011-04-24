package view;

import homes.Agenda;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ciudad;
import model.Contacto;

import org.uqbar.commons.model.Home;

public class CrearContactoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		
		Home<Contacto> home = Agenda.getInstance().getHome(Contacto.class);
		
		Contacto nuevoContacto = new Contacto();
		
		home.create(nuevoContacto);
		
		request.setAttribute("contacto", nuevoContacto);
		
		nuevoContacto.setNombre(request.getParameter("nombre"));
		nuevoContacto.setTelefono(request.getParameter("telefono"));
		nuevoContacto.setMail(request.getParameter("mail"));
		nuevoContacto.setCiudad(new Ciudad(request.getParameter("ciudad")));
		nuevoContacto.setObservaciones(request.getParameter("observaciones"));
		
		request.getRequestDispatcher("validarCrear.jsp").forward(request, response);
	}
}
