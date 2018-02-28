package gerenciador.web;

import gerenciador.Usuario;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuario != null) {
			session.removeAttribute("usuarioLogado");
			return "/WEB-INF/paginas/logoutt.html";
			//requestDispatcher.forward(req, resp);
			}
		else {
			return "/WEB-INF/paginas/logoutf.html";
			//requestDispatcher.forward(req, resp);	
		}
	}
}