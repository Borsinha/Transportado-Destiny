<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
				<h2 class='title'>Adicionar Caminhão</h2>
				<form action="TruckController" method="POST" name="addTruckForm">
					<div class='form-group'>
						<input type='text' readonly="readonly" class='form-control' name='id'
							placeholder='id' required
							value="<c:out value="${truck.id}" />">
					</div>
					<div class='form-group'>
						<input type='text' class='form-control' name='model'
							placeholder='Modelo' required
							value="<c:out value="${truck.model}" />">
					</div>
					<div class='form-group'>
						<input type='text' class='form-control' name='driver'
							placeholder='Condutor' required
							value="<c:out value="${truck.driver}" />">
					</div>
					<div class='form-group'>
						<input type='number' class='form-control' name='totalKm'
							placeholder='Kilometragem Total' required
							value="<c:out value="${truck.totalKm}" />">
					</div>
					<div class='form-group'>
						<label>Localização Atual</label> <select class='form-control'
							name='currentLocation' style='width: 150px'>
							<option>Santa Catarina</option>
							<option>Paraná</option>
							<option>Rio Grande do Sul</option>
							<option>Movimento</option>
						</select>
					</div>
					<div class='form-group'>
						<input type='text' class='form-control' name='destiny'
							placeholder='Destino' required
							value="<c:out value="${truck.destiny}" />">
					</div>
					<button type='submit' class='btn btn-dark'>Adicionar</button>
				</form>
			</div>
		</div>
	</div>
	</header>


</body>
</html>