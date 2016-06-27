<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="../resources/js/modernizr.min.js"></script>

<title>Diário WEB - Todas os Usuários</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="row">
		<div class="large-12 columns">

			<table border="2">
				<tr>
					<td><strong>ID:</strong></td>
					<td><strong>NOME:</strong></td>
					<td><strong>LOGIN:</strong></td>
					<td><strong>E-MAIL:</strong></td>
					<td><strong><font color="red">CRUD:</font></strong></td>
				</tr>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.login}</td>
						<td>${usuario.email}</td>
						<td><a href="/diarioweb/usuarios?id=${usuario.id}"> <img
								height="16px" width="16px" alt=""
								src="/diarioweb/resources/img/delete.png">
						</a></td>
					</tr>
				</c:forEach>
			</table>

			<div class="panel">
				<p>
					<a href="/diarioweb/" class="button">Voltar</a>
				</p>
			</div>
		</div>
		<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>