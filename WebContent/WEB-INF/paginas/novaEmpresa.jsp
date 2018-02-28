<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	Empresa adicionada com sucesso: ${empresa.getNome()}

	<form action="controller" method="GET">
		<input type="hidden" name="tarefa" value="BuscaEmpresa"> 
		<input type="submit" value="Ir para busca ">
	</form>

	<form action="index.jsp" method="GET">
		<input type="submit" value="Ir para index">
	</form>
</body>
</html>