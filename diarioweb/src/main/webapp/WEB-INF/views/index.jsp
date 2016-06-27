<%@page import="ufc.web.diario.models.TipoUsuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="resources/css/normalize.min.css">
<link rel="stylesheet" href="resources/css/foundation.min.css">
<link href='resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<link rel="stylesheet" href="resources/css/rn.css">

<script src="resources/js/modernizr.min.js"></script>

<title>Diário WEB</title>
</head>
<body>

	<%@ include file="topo.jsp"%>

	<!-- 	https://developers.facebook.com/docs/plugins/page-plugin -->
	<!-- 	https://twitter.com/settings/widgets/592398058639499266/edit?notice=WIDGET_UPDATED -->

	<div class="row">
		<div class="large-12 columns">
			<!--  12 columns -->
			<c:choose>
				<c:when test="${fn:length(noticiasRecentes) le 0}">
					<%@ include file="404.jsp"%>
				</c:when>

				<c:otherwise>
					<ul class="example-orbit" data-orbit>
						<!-- Slider -->

						<c:forEach begin="0" end="4" var="noticia"
							items="${noticiasRecentes}">
							<li><img height="400px" width="1000px"
								src="/diarioweb/download/${noticia.noticiaId}.html" /> <a
								href="noticias/exibir?id=${noticia.noticiaId}">${noticia.titulo}</a>
							</li>
						</c:forEach>
					</ul>
				</c:otherwise>

			</c:choose>
		</div>
		<!--  12 columns -->
		
		<%@ include file="footer.jsp"%>
	</div>
	<!-- ROWS -->

	
	
	<script src="resources/js/jquery-2.1.4.min.js"></script>
	<script src="resources/js/foundation.min.js"></script>
	<script>
		$(document).foundation();
	</script>

</body>
</html>