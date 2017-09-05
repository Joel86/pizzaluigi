package be.vdab.servlets;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Begroeting;
import be.vdab.entities.Persoon;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns= "/index.htm", name= "indexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final AtomicInteger aantalKeerBekeken = new AtomicInteger();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("emailAdresWebMaster", 
				this.getServletContext().getInitParameter("emailAdresWebMaster"));
		request.setAttribute("aantalKeerBekeken", aantalKeerBekeken.incrementAndGet());
		request.setAttribute("begroeting", new Begroeting());
		request.setAttribute("zaakvoerder", new Persoon("Luigi", "Peperone", 7, true,
				new Adres("Grote markt", "3", 9700, "Oudenaarde")));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
