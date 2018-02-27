package gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.Empresa;
import gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String nomeEmpresa = req.getParameter("nome");
		
		Empresa empresa = new Empresa(nomeEmpresa);
		
		new EmpresaDAO().adiciona(empresa);
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<br/> Empresa criada com sucesso: " + empresa.getNome());
		
		writer.println("<form action=\"index.html\" method=\"GET\">");
		writer.println("<input type=\"submit\" value=\"Ir para index \">");
		writer.println("</form>");
		
		writer.println("</body>");
		writer.println("</html>");
	}
}
