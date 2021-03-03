<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinária Arca de Noé - Exames </title>

<link href="/css/bootstrap.min.css" rel="styLesheet">

</head>
<body>

	<spring:url value="/exame/cadastra" var="cadastra"/>
	<spring:url value="/exame/deleta" var="deleta"/>
	<spring:url value="/exame/edita" var="edita"/>

		<jsp:include page="../comum/header.jsp"></jsp:include>
	
		<div class="container">
		<div class="pb-2 mt-5 mb-2 border-bottom">
			
		<h1>Solicitação de Exame</h1>
		
		<form:form modelAttribute="exame" action="${cadastra}">
		
		
		<input type="hidden" name="idExame" id="idExame" value="${exame.idExame}"/>
		<div class="form-group">
				<label for="nomeVeterinario">Nome do Veterinário</label> 
				<form:select path="veterinario" items="${veterinarios_r}" multiple="false" itemValue="id"  class="form-control"/>
			</div>				
				
		
					<div class="form-group">
				<label for="nomeAnimal">Nome do Pet</label> 
				<form:select path="animal" items="${animais_r}" multiple="false" itemValue="idAnimal" itemLabel="nomeAnimal" class="form-control"/>
			</div>	
					
					
					<div class="form-group">
					<label for="descricao">Descrição</label> <input type="text" name="descricao"
					id="descricao" value="${exame.descricao}" class="form-control">
					</div>
					
					<div class="form-group">
					<label for="valor">Valor do Exame</label> <input type="text" name="valor"
					id="valor" value="${exame.valor}" class="form-control">
					</div>
					
					<c:if test="${exame.idExame == '0'}">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</c:if>	
									
					<c:if test="${exame.idExame  != '0' }">
						<button type="submit" class="btn btn-primary">Editar </button>
					</c:if>
				
				<a href="/" class="btn btn-success">Voltar</a>
					
		</form:form>
			
	</div>
	
		<c:if test= "${not empty exames}" >
		<table class="table table-dark table-hover">
			<thead class="thead-dark">
			<tbody>
			<tr>
			<th width="20%"> Veterinário </th>
			<th width="20%"> Nome do Pet</th>
			<th width="20%"> Valor do Exame</th>
			<th colspan="3" width="20%">Ações</th>
			</tr>
						
			<c:forEach var="exame" items="${exames}">	
					
			<tr>	
			<td> ${exame.veterinario}</td>
			<td> ${exame.animal}</td>
			<td> ${exame.valor}</td>
			<td><a href="${edita}/${exame.idExame}" class="btn btn-primary">Editar</a></td>
			<td><a href="${deleta}/${exame.idExame}"  class="btn btn-danger">Deletar</a></td>	
			</tr>
						
			</c:forEach>
			</tbody>
			</table>
			</c:if>
	
	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	
</body>
</html>