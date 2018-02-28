package gerenciador.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String attribute = req.getParameter("tarefa");

		if (attribute == null) {
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		}

		try {
			String nomeClasse = "gerenciador.web." + attribute;

			Class<?> type = Class.forName(nomeClasse);
			Tarefa task = (Tarefa) type.newInstance();
			String path = task.executa(req, resp);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
			requestDispatcher.forward(req, resp);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
