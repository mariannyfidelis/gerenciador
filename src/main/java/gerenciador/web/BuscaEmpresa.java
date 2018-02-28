package gerenciador.web;

import gerenciador.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import gerenciador.dao.EmpresaDAO;

import javax.servlet.RequestDispatcher;
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
		
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		req.setAttribute("empresas", empresas);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
		requestDispatcher.forward(req, resp);
		
	}
}
