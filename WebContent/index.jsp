<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
</head>

<body>
	Bem vindo ao nosso gerenciador de empresas!	<br />
	
	<c:if test="${usuarioLogado != null}">
		Você está logado como ${usuarioLogado.getEmail()}<br/>
	</c:if>

	<form action="novaEmpresa" method="POST">

		Nome: <input type="text" name="nome"> <input type="submit"
			value="Enviar">
	</form>

	<form action="login" method="POST">
		Email: <input type="email" name="email"> Senha: <input
			type="password" name="senha"> <input type="submit"
			value="Enviar">
	</form>

	<form action="busca" method="GET">
		<input type="submit" value="Ir para busca ">
	</form>

	<form action="logout" method="POST">
		<input type="submit" value="Deslogar">
	</form>
</body>
</html>
