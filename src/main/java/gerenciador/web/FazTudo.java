package gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/fazTudo")
public class FazTudo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String attribute = (String) req.getParameter("tarefa");

		String tarefa = "gerenciador.web." + attribute;

		try {
			Class<?> className = Class.forName(tarefa);
			Tarefa task;
			task = (Tarefa) className.newInstance();
			String path = task.executa(req, resp);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
			requestDispatcher.forward(req, resp);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException(e);
		}

	}
}
