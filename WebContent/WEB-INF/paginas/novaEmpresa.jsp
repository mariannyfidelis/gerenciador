<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	Empresa adicionada com sucesso: ${empresa.getNome()}

	<form action="index.html" method="GET">
		<input type="submit" value= "Ir para index">
	</form>
</body>
</html>