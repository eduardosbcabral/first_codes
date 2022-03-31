<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="model.Carro"%>
	<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resposta Consultar Todos Modelos</title>
</head>
<body>
	<h1>Lista dos carros</h1>

	<table border="1">
	<tr><td>Modelo</td><td>Ano</td><td>Marca</td></tr>
	
		<%
			ArrayList<Carro> carros = (ArrayList<Carro>) request.getAttribute("listaCarros");
		
			for(Carro carro : carros){
			
			%>
			
			<tr><td>
			
			<%=
				carro.getModelo()
			%>
			
			</td><td>
			
			<%=
				carro.getAnoFab()
			%>
			
			</td><td>
			
			<%=
				carro.getMarca()
			%>
			
			</td></tr>
			
			<%	
			}
		%>
	</table>

</body>
</html>