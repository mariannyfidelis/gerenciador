package gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;

		String uri = request.getRequestURI();

		PrintWriter writer = resp.getWriter();

		writer.println("<html><body> URI acessada com sucesso: " + uri + "<br/> </body></html>");

		String usuario = "<deslogado>";
		HttpSession session = request.getSession();
		Usuario usuarioLogado = ((Usuario) session.getAttribute("usuarioLogado"));
	
		if (usuarioLogado != null) {

			/*
			 * NÃO SERÁ MAIS USADO O COOKIE E SIM A SESSION Cookie cookie = new
			 * Cookies(request.getCookies()).getUsuarioLogado(); if (cookie != null) {
			 * cookie.setMaxAge(10 * 60); ((HttpServletResponse) resp).addCookie(cookie); }
			 */

			System.out.println("Usuario: " + usuarioLogado.getEmail() + " acessando a URI " + uri);
		}
		else {
			System.out.println("Usuario: " + usuario+ " acessando a URI " + uri);
		}
		filter.doFilter(req, resp);
	}

	//Usado na implementação anterior do cookie
	private String getUsuario(HttpServletRequest req) {

		String usuario = "<deslogado>";

		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();

		if (cookie == null) {
			return usuario;
		} else {
			return cookie.getValue();
		}
	}
}
