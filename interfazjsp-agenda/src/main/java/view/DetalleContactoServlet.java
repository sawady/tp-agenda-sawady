package view;

import homes.Agenda;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;

import org.uqbar.commons.model.Home;

public class DetalleContactoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		
		Home<Contacto> home = Agenda.getInstance().getHome(Contacto.class);
		
		request.setAttribute("contacto", home.searchById(Integer.parseInt(request.getParameter("id"))));

		request.getRequestDispatcher("detalleContacto.jsp").forward(request, response);
	}
}