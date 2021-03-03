<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinária Arca de Noé - Animais </title>

<link href="/css/bootstrap.min.css" rel="styLesheet">

</head>
<body>

	<spring:url value="/animal/cadastra" var="cadastra"/>
	<spring:url value="/animal/deleta" var="deleta"/>
	<spring:url value="/animal/edita" var="edita"/>

		<jsp:include page="../comum/header.jsp"></jsp:include>
	
	
		<div class="container">
		<div class="pb-2 mt-5 mb-2 border-bottom">
			
		<h1>Cadastro de Animais</h1>
		
		<form:form modelAttribute="animal" action="${cadastra}">
		
		
		<input type="hidden" name="idAnimal" id="idAnimal" value="${animal.idAnimal}"/>
		
			
			<div class="col-md-7 mb-7">
				<label for="nomDono">Nome Dono</label> 
				<form:select path="cliente" items="${clientes_cadastrados}" multiple="false" itemValue="id" itemLabel="nomeDono" class="form-control"/>
			</div>	
		
				<div class="col-md-7 mb-7">
					<label for="nomeAnimal">Nome do Pet</label> <input type="text" name="nomeAnimal"
					id="nomeAnimal" value="${animal.nomeAnimal}" class="form-control">
				</div>				
				
		
					<div class="col-md-7 mb-7">
						<label for="racaAnimal">Raça do Pet</label> <input type="text" name="racaAnimal"
						id="racaAnimal" value="${animal.racaAnimal}" class="form-control">
					</div>
					
					<div class="col-md-7 mb-7">
						<label for="idadeAnimal">Idade do Pet</label> <input type="text" name="idadeAnimal"
						id="idadeAnimal" value="${animal.idadeAnimal}" class="form-control">
					</div>
					
					<c:if test="${animal.idAnimal == '0'}">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</c:if>	
									
					<c:if test="${animal.idAnimal  != '0' }">
						<button type="submit" class="btn btn-primary">Editar </button>
					</c:if>
				
				<a href="/" class="btn btn-success">Voltar</a>
					
		</form:form>
			
	</div>
	
		<c:if test= "${not empty animais}" >
		<table class="table table-dark table-hover">
			<thead class="thead-dark">
			<tbody>
			<tr>
			<th width="20%"> Nome do pet </th>
			<th width="20%"> Raça do Pet</th>
			<th width="20%"> Idade do pet</th>
			<th colspan="3" width="20%">Ações</th>
			</tr>
						
			<c:forEach var="animal" items="${animais}">	
					
			<tr>	
			<td> ${animal.nomeAnimal}</td>
			<td> ${animal.racaAnimal}</td>
			<td> ${animal.idadeAnimal}</td>
			<td><a href="${edita}/${animal.idAnimal}" class="btn btn-primary">Editar</a></td>
			<td><a href="${deleta}/${animal.idAnimal}"  class="btn btn-danger">Deletar</a></td>	
			</tr>
						
			</c:forEach>
			</tbody>
			</table>
			</c:if>
			
	
	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	
</body>
</html>