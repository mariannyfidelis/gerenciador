package gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.Usuario;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*NÃO SERÁ MAIS USADO O COOKIE E SIM A SESSION
		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();*/
		HttpSession session = req.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario.logado");
		PrintWriter writer = resp.getWriter();
		
		/*if (cookie != null) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			writer.println("<html><body>Logout efetuado</body></html>");
		}*/
		if(usuario != null) {
			session.removeAttribute("usuario.logado");
			//resp.sendRedirect("logoutt.html");
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logoutt.html");
			requestDispatcher.forward(req, resp);
			}
		else {
			//writer.println("<html><body>Logout não pode ser efetuado  pois usuário não estava logado</body></html>");
			//resp.sendRedirect("logoutf.html");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logoutf.html");
			requestDispatcher.forward(req, resp);
			
		}
		
		

	}
}
