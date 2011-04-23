package view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HakunaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String titulo = request.getParameter("titulo");
		
		request.setAttribute("tituloResult", titulo);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
