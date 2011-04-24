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

public class ValidarEditarServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		
		Home<Contacto> home = Agenda.getInstance().getHome(Contacto.class);
		
		Contacto contacto = home.searchById(Integer.parseInt(request.getParameter("id")));
		
		contacto.setNombre(request.getParameter("nombre"));
		contacto.setTelefono(request.getParameter("telefono"));
		contacto.setMail(request.getParameter("mail"));
		contacto.setCiudad(new Ciudad(request.getParameter("ciudad")));
		contacto.setObservaciones(request.getParameter("observaciones"));
		
		request.setAttribute("contacto", contacto);
		
		request.getRequestDispatcher("validarEditar.jsp").forward(request, response);
	}
	
}
