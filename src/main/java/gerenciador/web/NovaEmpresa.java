package gerenciador.web;

import gerenciador.Empresa;
import gerenciador.dao.EmpresaDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresa implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){
	
		String nomeEmpresa = req.getParameter("nome");
		
		Empresa empresa = new Empresa(nomeEmpresa);
		
		new EmpresaDAO().adiciona(empresa);

		req.setAttribute("empresa", empresa);
		
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
}