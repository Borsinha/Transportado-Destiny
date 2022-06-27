<%@page import="java.util.ArrayList"%>
<%@page import="models.Truck"%>
<%@page import="java.util.List"%>
<%@page import="models.Destiny"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Lista de Caminhões</title>

<!-- css  -->
<link rel="stylesheet" href="assets/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>

	<nav class='navbar nav-first navbar-dark bg-dark'>
	<div class='container'>
		<a class='navbar-brand' href='index.jsp'> <img
			src='assets/img/home.png'>
		</a>
	</div>
	</nav>
	<header class='header'>
	<div class='container'>
		<h1 class='title'>Lista de Caminhões</h1>
		<h3 class='components-section-title'>
			<a class='btn btn-outline-dark' href='TruckController?op=insert'>Adicionar
				Caminhão</a>
		</h3>
		<table class='table'>
			<thead>
				<tr>
					<th scope='col'>ID</th>
					<th scope='col'>Modelo</th>
					<th scope='col'>Condutor</th>
					<th scope='col'>KM Total</th>
					<th scope='col'>Localização</th>
					<th scope='col'>Destino</th>
					<th scope='col'>Editar</th>
					<th scope='col'>Excluir</th>
				</tr>
			</thead>
			<tbody>
				<% 
					List<Truck> listTruck = (ArrayList<Truck>)request.getAttribute("trucks");
					List<Destiny> listDestiny = (ArrayList<Destiny>)request.getAttribute("destinys");
					for(Truck truck : listTruck){
				%>	
					<tr>
						<th scope'row'>
							<% out.print(truck.getId()); %>
						</th>
						<td><% out.print(truck.getModel()); %></td>
						<td><% out.print(truck.getDriver()); %></td>
						<td><% out.print(truck.getTotalKm()); %></td>
						<td><% out.print(truck.getCurrentLocation()); %></td>
						
						<% for(Destiny destiny : listDestiny){ 
							if(truck.getDestiny() == destiny.getId()){
								out.print("<td>"+ destiny.getName() +"</td>");
							}
						}
						%>
						<td><a class='btn btn-outline-dark'
							href='TruckController?op=edit&truckId=<%out.print(truck.getId()); %>'>Editar</a></td>
						<td><a class='btn btn-outline-dark'
							href='TruckController?op=delete&truckId=<%out.print(truck.getId()); %>'>Deletar</a></td>
					</tr>
				<% }%>
			</tbody>
		</table>
	</div>
	</header>