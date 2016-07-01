<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

		<form method="post" action="/diarioweb/classificado">
			<strong>Inserir Oferta: </strong>
			<textarea rows="1" name="oferta" required></textarea>
			<input type="hidden" name="classificadoId" value="${classificado.classificadoId}">
			<input class="success button" type="submit" value="Inserir" />
		</form>

</body>
</html>
