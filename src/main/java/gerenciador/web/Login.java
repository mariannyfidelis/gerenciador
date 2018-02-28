package gerenciador.web;

import gerenciador.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import gerenciador.dao.UsuarioDAO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer = resp.getWriter();

		String userEmail = " < deslogado > ";
		if (usuario == null) {
			writer.println("<html>");
			writer.println("<body>");
			writer.println("Usuario: " + userEmail+"<br/>");// + "acessando "+ req.getRequestURI());
			writer.println("</body>");
			writer.println("</html>");

		} else {
			userEmail = usuario.getEmail();
			
			/*NÃO SERÁ MAIS USADO O COOKIE E SIM A SESSION
				Cookie cookie = new Cookie("usuario.logado", email);  
				resp.addCookie(cookie);
			 */
			
			//Com sessão configura o atributo e o objeto usuário
			req.getSession().setAttribute("usuarioLogado", usuario);
			
			writer.println("<html>");
			writer.println("<body>");
			writer.println("Usuario: " + userEmail + " acessando : " + req.getRequestURI()+"<br/>");

			writer.println("<form action=\"index.jsp\" method=\"GET\">");
			writer.println("<input type=\"submit\" value=\"Ir para index \">");
			writer.println("</form>");
			writer.println("</body>");
			writer.println("</html>");

		}
	}
}
