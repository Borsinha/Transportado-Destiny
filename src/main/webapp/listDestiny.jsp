<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Lista de Destinos</title>

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
		<h1 class='title'>Lista de Destinos</h1>
		<h3 class='components-section-title'>
			<a class='btn btn-outline-dark' href='DestinyController?op=insert'>Adicionar
				Destino</a>
		</h3>
		<table class='table'>
			<thead>
				<tr>
					<th scope='col'>ID</th>
					<th scope='col'>Nome</th>
					<th scope='col'>Rua</th>
					<th scope='col'>Numero</th>
					<th scope='col'>Cep</th>
					<th scope='col'>Cidade</th>
					<th scope='col'>Estado</th>
					<th scope='col'>Editar</th>
					<th scope='col'>Excluir</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${destiny}" var="destiny">
					<tr>
						<th scope'row'>
						<c:out value="${destiny.id}" />
						</th>
						<td><c:out value="${destiny.name}" /></td>
						<td><c:out value="${destiny.street}" /></td>
						<td><c:out value="${destiny.number}" /></td>
						<td><c:out value="${destiny.cep}" /></td>
						<td><c:out value="${destiny.city}" /></td>
						<td><c:out value="${destiny.state}" /></td>
						
					
    	
						<td><a class='btn btn-outline-dark'
							href='DestinyController?op=edit&destinyId=<c:out value="${destiny.id}"/>'>Editar</a></td>
						<td><a class='btn btn-outline-dark'
							href='DestinyController?op=delete&destinyId=<c:out value="${destiny.id}"/>'>delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</header>