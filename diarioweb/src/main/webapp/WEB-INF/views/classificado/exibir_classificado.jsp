<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>
<link rel="stylesheet" href="../resources/responsive-tables.css">

<script src="../resources/responsive-tables.js"></script>
<script src="../resources/js/modernizr.min.js"></script>

<title>Diário WEB - ${classificadoResult.titulo } </title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="row">
		<div class="large-12 columns">
			
				<table>
					     
					           <tr>
					           		<td><strong>TÍTULO</strong></td>
					           		<td><h3>${classificadoResult.titulo }</h3></td>
					           </tr>					       
					           <tr>
					           		<td><strong>TEXTO:</strong></td>
					           		<td><h4>${classificadoResult.texto }</h4></td>
					           </tr>
					           <tr>
					           		<td><strong>PREÇO INICIAL:</strong></td>
					           		<td> ${classificadoResult.preco } </td>
					           </tr>
					           <tr>					
					           		<td><strong>TELEFONE:</strong></td>
					           		<td> ${classificadoResult.telefone }</td>
					           </tr>
					           <tr>
					           		<td><strong>MELHOR OFERTA:</strong></td>					
					           		<td> ${classificadoResult.melhor_oferta } </td>
					           </tr>
					           <tr>	
					           		<td><strong>DATA DA OFERTA:</strong></td>				
					           		<td> ${classificadoResult.data_oferta } </td>
					           </tr>
					           					
					            <c:if test="${not empty classificadoResult.autorOferta }">
					            	<tr>
					            		<td><strong>AUTOR DA OFERTA:</strong></td>
					            		<td> ${classificadoResult.autorOferta.nome }</td>
					            	</tr>     
					            </c:if>

					            <c:forEach var="regra" items="${usuario.regras}">
					                <c:if test="${regra.nome == 'Leitor' }">
					                	<c:if test="${usuario.getRegraId() == 1 }">
					                   		<tr>
					                   			<td><strong><font color="red">CRUD:</font></strong></td>
					                   			<td> <%@ include file="../classificado/fazer_oferta.jsp"%> </td>
					                   		</tr> 
					                	</c:if>
					                </c:if>
					            </c:forEach> 
				</table>
				
         

			<%@ include file="../rodape.jsp"%>
		</div>

	</div>

</body>
</html>