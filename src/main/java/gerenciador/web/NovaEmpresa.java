package gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
		//Envia em outra requisição o objeto empresa
		req.setAttribute("empresa", empresa);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
		requestDispatcher.forward(req, resp);
	}
}
