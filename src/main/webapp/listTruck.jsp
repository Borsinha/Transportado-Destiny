<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
			<a class='btn btn-outline-dark' href='TruckController?action=insert'>Adicionar
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
				<c:forEach items="${trucks}" var="truck">
					<tr>
						<th scope'row'>
						<c:out value="${truck.id}" />
						</th>
						<td><c:out value="${truck.model}" /></td>
						<td><c:out value="${truck.driver}" /></td>
						<td><c:out value="${truck.totalKm}" /></td>
						<td><c:out value="${truck.currentLocation}" /></td>
						<td><c:out value="${truck.destiny}" /></td>
						<td><a class='btn btn-outline-dark'
							href='TruckController?action=edit&truckId=<c:out value="${truck.id}"/>'>Editar</a></td>
						<td><a class='btn btn-outline-dark'
							href='TruckController?action=delete&truckId=<c:out value="${truck.id}"/>'>delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</header>