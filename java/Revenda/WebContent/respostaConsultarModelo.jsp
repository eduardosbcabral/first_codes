<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Carro"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resposta Consultar Modelo</title>
</head>
<body>
	<h1>Dados do Modelo</h1>

	<%
		//Aqui comeca o codigo java

		//Recuperar atributos do request
		Carro c = (Carro) request.getAttribute("carro");

		//Exibindo dados do carro - Forma 1
		out.println("Modelo: " + c.getModelo() + "<BR>");
	%>

	Ano de Fabricação:
	<%=c.getAnoFab()%><BR> Marca:
	<%=c.getMarca()%>

</body>
</html>