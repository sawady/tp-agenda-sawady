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

public class SearchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		
		Home<Contacto> home = Agenda.getInstance().getHome(Contacto.class);

		Contacto example = new Contacto();
		
		example.setNombre(request.getParameter("nombre"));
		example.setMail(request.getParameter("mail"));
		example.setTelefono(request.getParameter("telefono"));
		example.setCiudad(new Ciudad(request.getParameter("ciudad")));
		
		request.setAttribute("contactos", home.searchByExample(example));

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
