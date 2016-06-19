<%@page import="ufc.web.diario.models.TipoUsuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="pt-br">
<head>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.5.3/css/normalize.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.5.3/css/foundation.min.css">
<link
	href='http://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css'
	rel='stylesheet' type='text/css'>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>

<title>Login</title>
</head>
<body>
<%@ include file="../topo.jsp"%>

	<div class="row">
		<form method="post" action="/diarioweb/usuarios">
			<div class="large-6 columns">
				<div class="panel">
					Nome:
					<input type="text" name="nome" />
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					Login:
					<input type="text" name="login" />
				</div>
			</div>
			
			<div class="large-6 columns">
				<div class="panel">
					E-mail:
					<input type="email" name="email" />
				</div>
			</div>
			
			<div class="large-6 columns">
				<div class="panel">
					Senha:
					<input type="password" name="senha" />
				</div>
			</div>

			<%    pageContext.setAttribute("tiposUser", TipoUsuario.values()); %>
			<div class="large-6 columns">
				<div class="panel">
					<p>Seção:</p>
					<select name="tipoID">
						<c:forEach var="entry" items="${tiposUser}">
						    <option>${entry.nomeTipoUsuario}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="large-12 medium-12 columns">
				<div class="panel">
					<p>
						<a href="/diarioweb/" class="button">Voltar</a> <input
							class="success button" id="cadNot" type="submit"
							value="Entrar" />
					</p>
				</div>
			</div>
		</form>
		</div>
</body>
</html>