<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Adicionar Caminhão</title>

<!-- css  -->
<link rel='stylesheet' href='assets/css/style.css'>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<!-- nav -->
	<nav class='navbar nav-first navbar-dark bg-dark'>
	<div class='container'>
		<a class='navbar-brand' href='index.jsp'> <img
			src='assets/img/home.png'>
		</a>
	</div>
	</nav>
	<header class='header'>
	<div class='container'>
		<div class='d-flex justify-content-center'>
			<div class='col-md-7'>
				<h2 class='title'>${action} Destino</h2>
				<form action="DestinyController" method="POST" name="addDestinyForm">
					<div class='form-group'>
						<input type='text' readonly="readonly" class='form-control' name='id'
							placeholder='id' required
							value="<c:out value="${destiny.id}" />">
					</div>
						<div class='form-group'>
						<input type='text' class='form-control' name='name'
							placeholder='Nome' required
							value="<c:out value="${destiny.name}" />">
					</div>
					<div class='form-group'>
						<input type='text' class='form-control' name='street'
							placeholder='Rua' required
							value="<c:out value="${destiny.street}" />">
					</div>
					<div class='form-group'>
						<input type='text' class='form-control' name='number'
							placeholder='Numero' required
							value="<c:out value="${destiny.number}" />">
					</div>
					<div class='form-group'>
						<input type='text' class='form-control' name='cep'
							placeholder='CEP' required
							value="<c:out value="${destiny.cep}" />">
					</div>
					<div class='form-group'>
						<input type='text' class='form-control' name='city'
							placeholder='Cidade' required
							value="<c:out value="${destiny.city}" />">
					</div>
						<div class='form-group'>
						<input type='text' class='form-control' name='state'
							placeholder='Estado' required
							value="<c:out value="${destiny.state}" />">
					</div>
					<button type='submit' class='btn btn-dark'>${action}</button>
				</form>
			</div>
		</div>
	</div>
	</header>


</body>
</html>