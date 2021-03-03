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

	<spring:url value="/consulta/cadastra" var="cadastra"/>
	<spring:url value="/consulta/deleta" var="deleta"/>
	<spring:url value="/consulta/edita" var="edita"/>

		<jsp:include page="../comum/header.jsp"></jsp:include>
	
		<div class="container">
		<div class="pb-2 mt-5 mb-2 border-bottom">
			
		<h1>Agendamento de Consulta</h1>
		
		<form:form modelAttribute="consulta" action="${cadastra}">
		
		
		<input type="hidden" name="idC" id="idC" value="${consulta.idC}"/>
		
			
			<div class="form-group">
				<label for="nomeVeterinario">Nome do Veterinário</label> 
				<form:select path="veterinario" items="${veterinarios_r}" multiple="false" itemValue="id"  class="form-control"/>
			</div>	
			
			<div class="form-group">
				<label for="nomeAnimal">Nome do Pet</label> 
				<form:select path="animal" items="${animais_r}" multiple="false" itemValue="idAnimal" itemLabel="nomeAnimal" class="form-control"/>
			</div>	
		
			<div class="form-group">
						<label for="dataAgendamento">Data de Agendamento</label>
						<input type="date" name="dataAgendamento" id="dataAgendamento" value= "${consulta.dataAgendamento}"  />										
					</div>
					
					<div class="form-group col-md-4">										
						<label for="horaAtt">Hora do atendimento</label>
				      <select name="horaAtt" id="horaAtt" value="${consulta.horaAtt}"  class="form-control">
				       
				        <optionselected>09:00</option>
						<option>10:00</option>
						<option>11:00</option>
						<option>12:00</option>
						<option>13:00</option>
						<option>14:00</option>
						<option>15:00</option>
						<option>16:00</option>
						<option>17:00</option>
						<option>18:00</option>
				         
				      </select>
					</div>		
					
					<div class="form-group" >
						<label  for="observacoes">Observações</label> 
						<textarea rows="3" name="observacoes" maxlength="2000" class="form-control">${consulta.observacoes}</textarea>
					</div>		
					
	
			</div>
					
			<c:if test="${consulta.idC == '0'}">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</c:if>	
									
					<c:if test="${consulta.idC  != '0' }">
						<button type="submit" class="btn btn-primary">Editar </button>
					</c:if>
				
				<a href="/" class="btn btn-success">Voltar</a>
					
		</form:form>
			
	
	
		<c:if test= "${not empty consultas}" >
		<table class="table table-dark table-hover">
			<thead class="thead-dark">
			<tbody>
			<tr>
			<th width="20%"> Nome do Veterinario </th>
			<th width="20%"> Nome do Pet</th>
			<th width="20%"> Data de Agendamento</th>
			<th width="20%"> Hora de Agendamento</th>
			<th width="20%"> Observações</th>
			<th width="20%"> Ações</th>
			<th colspan="3" width="20%">Ações</th>
			</tr>
						
			<c:forEach var="consulta" items="${consultas}">	
					
			<tr>	
			<td> ${consulta.veterinario.nomeVeterinario}</td>
			<td> ${consulta.animal.nomeAnimal}</td>
			<td> ${consulta.dataAgendamento}</td>
			<td> ${consulta.horaAtt}</td>
			<td> ${consulta.observacoes}</td>
			
			<td><a href="${edita}/${consulta.idC}" class="btn btn-primary">Editar</a></td>
			<td><a href="${deleta}/${consulta.idC}"  class="btn btn-danger">Deletar</a></td>	
			</tr>
						
			</c:forEach>
			</tbody>
			</table>
			</c:if>
		
			
	
	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	
</body>
</html>