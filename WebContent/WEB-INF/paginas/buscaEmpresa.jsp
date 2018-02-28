<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
</head>

<body>
	Resultado da busca:	<br />

	<ul>
		<c:forEach var="empresa" items="${empresas}">
			<li>${empresa.getId()} --- ${empresa.getNome()} <br />	</li>
		</c:forEach>
	</ul>

	<form action="index.html" method="GET">
		<input type="submit" value="Ir para index ">
	</form>

</body>
</html>