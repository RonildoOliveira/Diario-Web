  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Comentário</title>
</head>
<body>
	
    <table border="1">
	<c:forEach var="comentario" items="${comentarios}">
	<tr>
		<td>${comentario.noticiaId}</td>
		<td>${comentario.texto}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>