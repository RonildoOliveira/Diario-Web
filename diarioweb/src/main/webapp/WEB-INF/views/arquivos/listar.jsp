<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Arquivos</title>
</head>
<body>
	
    <table border="1">
    <tr>
		<td>NOME</td>
		
	</tr>
	<c:forEach var="arquivo" items="${arquivos}">
	<tr>
		<td>${arquivo.nomeArquivo}</td>
		<td>
		<img height="100px" width="200px" src="/diarioweb/download/${arquivo.idArquivo}.html">
		<a href="${pageContext.request.contextPath}/download/${arquivo.idArquivo}.html">
		Baixe
		</a>
		</td>		
	</tr>
	</c:forEach>
</table>
<a href="/diarioweb/">Voltar</a>
</body>
</html>