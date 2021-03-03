<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinária Arca de Noé - Atendimento </title>



<link href="/css/bootstrap.min.css" rel="styLesheet">

</head>
<body>

		<spring:url value="/atendimento/cadastra" var="cadastra"/>
		<spring:url value="/atendimento/edita" var="edita"/>
		<spring:url value="/atendimento/deleta" var="deleta"/>


		<jsp:include page="../comum/header.jsp"></jsp:include>
	
	
	
		<div class="container">	
		<div class="pb-2 mt-5 mb-2 border-bottom">
			
		<h1 class="font-weight-bold">Atendimento Emergencial</h1>
		
		
		<form:form modelAttribute="atendimento"   action="${cadastra}">
		
		<input type="hidden" name="idAtendimento" id="idAtendimento" value="${atendimento.idAtendimento}"/>
		
			<div class="form-group">
				<label for="nomeVeterinario">Nome do Veterinário</label> 
				<form:select path="veterinario" items="${veterinarios_r}" multiple="false" itemValue="id"  class="form-control"/>
			</div>			
		
					<div class="form-group">
				<label for="nomeAnimal">Nome do Pet</label> 
				<form:select path="animal" items="${animais_r}" multiple="false" itemValue="idAnimal" itemLabel="nomeAnimal" class="form-control"/>
			</div>	
					
					<div class="form-group">
				<label for="nomeDono">Nome Dono</label> 
				<form:select path="nomeDono" items="${clientes_r}" multiple="false" itemValue="id" itemLabel="nomeDono" class="form-control"/>
			</div>	
					
					<div class="form-group">
						<label for="cpfDono">CPF do Dono</label> <input type="text" name="cpfDono"
						id="cpfDono" value="${atendimento.cpfDono}" class="form-control">
					</div>
					
					
					<div class="form-group">
						<label for="dataAtendimento">Data de Atendimento</label>
						<input type="date" name="dataAtendimento" id="dataAtendimento" value= "${atendimento.dataAtendimento}"  />										
					</div>
					
					
										
					
					<div class="form-group" >
						<label  for="outrasInformacoes">Outras Informações</label> 
						<textarea rows="3" name="outrasInformacoes" maxlength="2000" class="form-control">${atendimento.outrasInformacoes}</textarea>
					</div>														
				
					<c:if test="${atendimento.idAtendimento == '0'}">
						<button type="submit" class="btn btn-primary">Enviar Solicitação</button>
					</c:if>	
									
					<c:if test="${atendimento.idAtendimento  != '0' }">
						<button type="submit" class="btn btn-primary">Editar Solicitação</button>
					</c:if>
					
					
					
				<a href="/" class="btn btn-success">Voltar</a>	
		</form:form>
			
	</div>
		<c:if test="${not empty atendimentos }"	>
		<table class="table table-dark table-hover">
			<thead class="thead-dark">
			
			<tr>
			<th width="20%"> Veterinário de Plantão</th>
			<th width="20%"> Nome do Pet</th>
			<th width="20%"> Nome do dono</th>
			<th width="20%"> Data  Atendimento</th>
			<th width="20%"> Outras Informaçoes</th>
			<th colspan="2" width="20%">Ações</th>
			</tr>
			<c:forEach var="atendimento" items="${atendimentos}">
			
			<tr>	
			<td> ${atendimento.veterinario.nomeVeterinario}</td>
			<td> ${atendimento.animal.nomeAnimal}</td>
			<td> ${atendimento.nomeDono.nomeDono}</td>
			<td> ${atendimento.dataAtendimento}</td>
			<td> ${atendimento.outrasInformacoes}</td>
			<td><a href="${edita}/${atendimento.idAtendimento}" class="btn btn-primary">Editar</a></td>
			<td><a href="${deleta}/${atendimento.idAtendimento}"  class="btn btn-danger">Deletar</a></td>	
			</tr>
			
			
			</c:forEach>
			</table>
			</c:if>
	
		
	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	
</body>
</html>