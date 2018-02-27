package gerenciador.web;

import gerenciador.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import gerenciador.dao.EmpresaDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {
	
	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Iniciando a servelet .... "+ this.getClass().getSimpleName());
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a servelet .... "+this.getClass().getSimpleName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("<body>");
		writer.println("Resultado da busca:<br/>");

		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

		writer.println("<ul>");

		for (Empresa empresa : empresas) {
			writer.print("<li>" + empresa.getId() + "--- " + empresa.getNome() + "</li>");
		}
		writer.println("</ul>");

		writer.println("<form action=\"index.html\" method=\"GET\">");
		writer.println("<input type=\"submit\" value=\"Ir para index \">");
		writer.println("</form>");

		writer.println("</body>");
		writer.println("</html>");

	}
}
