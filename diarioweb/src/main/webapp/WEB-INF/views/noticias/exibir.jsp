<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../resources/css/foundation.css" rel="stylesheet"
	type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../topo.jsp"%>

	<div class="large-12 columns">
		<div class="row">
			<h3>${noticiaResult.titulo}</h3>
			<h6>${noticiaResult.dataNoticia}</h6>
			<div class="large-12w columns">
				<p>${noticiaResult.texto}</p>
			</div>

			<%@ include file="../comentarios/form.jsp"%>

			<h5>
				<strong>Comentários</strong>
			</h5>
			<c:forEach var="comentario" items="${comentarios}">
				<div class="primary callout">
					<p>${comentario.texto}</p>
				</div>
			</c:forEach>

			<div class="primary callout">
				<p>
					<a href="/diarioweb/" class="button">Voltar</a>
				</p>
			</div>
		</div>

	</div>

</body>
</html>