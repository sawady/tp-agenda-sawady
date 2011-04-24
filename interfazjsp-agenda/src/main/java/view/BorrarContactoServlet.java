package view;

import homes.Agenda;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;

import org.uqbar.commons.model.Home;

public class BorrarContactoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		
		Home<Contacto> home = Agenda.getInstance().getHome(Contacto.class);
		
		Contacto contactoAEliminar = home.searchById(Integer.parseInt(request.getParameter("id")));
		
		home.delete(contactoAEliminar);
		
		request.setAttribute("contacto", contactoAEliminar);

		request.getRequestDispatcher("validarBorrar.jsp").forward(request, response);
	}
}
