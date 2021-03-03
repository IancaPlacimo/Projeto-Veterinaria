<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinária Arca de Noé - Veterinario </title>

<link href="/css/bootstrap.min.css" rel="styLesheet">

</head>
<body>


		<spring:url value="/veterinario/cadastra" var="cadastra"/>
		<spring:url value="/veterinario/edita" var="edita"/>
		<spring:url value="/veterinario/deleta" var="deleta"/>
		

		<jsp:include page="../comum/header.jsp"></jsp:include>
		
	
		<div class="container">
		<div class="pb-2 mt-5 mb-2 border-bottom">
			
		<h1>Cadastro de Veterinário</h1>
		
		<form:form modelAttribute="veterinario"   action="${cadastra}">
		
		<input type="hidden" name="id" id="id" value="${veterinario.id}"/>
			
					<div class="col-md-3 mb-3">
						<label for="crmv">CRMV</label> <input type="text" name="crmv"
						id="crmv" value="${veterinario.crmv}" class="form-control">
					</div>				
				
		
					<div class="col-md-7 mb-7">
						<label for="nomeVeterinario">Nome Completo</label> <input type="text" name="nomeVeterinario"
						id="nomeVeterinario" value="${veterinario.nomeVeterinario}" class="form-control">
					</div>
					
					<div class="col-md-5 mb-5">
						<label for="especialidade">Especialidade</label> <input type="text" name="especialidade"
						id="especialidade" value="${veterinario.especialidade}" class="form-control">
					</div>
					
					<div class="col-md-5 mb-5">
						<label for="telefone">Telefone</label> <input type="text" name="telefone"
						id="telefone" value="${veterinario.telefone}" class="form-control">
					</div>
					
					<div class="form-group">
						<label for="dataNascimento">Data de Nascimento</label>
						<input type="date" name="dataNascimento" id="dataNascimento" value= "${veterinario.dataNascimento}"  />										
					</div>
												
					<h3> Endereço </h3>		
				
					<div  class="col-md-9 mb-9">
						<label for="rua"> Rua </label> <input type="text" name="rua"
						id="rua" value="${endereco.rua}" class="form-control">
					</div>
					
					<div  class="col-md-5 mb-5">
						<label for="numero"> Número </label> <input type="text" name="numero"
						id="numero" value="${endereco.numero}" class="form-control">
					</div>
					
					<div  class="col-md-5 mb-5">
						<label for="complemento"> Complemento </label> <input type="text" name="complemento"
						id="complemento" value="${endereco.complemento}" class="form-control">
					</div>
					
					<div  class="col-md-3 mb-3">
						<label for="estado"> Estado </label> <input type="text" name="estado"
						id="estado" value="${endereco.estado}" class="form-control">
					</div>
					
					<div  class="col-md-3 mb-3">
						<label for="bairro"> Bairro </label> <input type="text" name="bairro"
						id="bairro" value="${endereco.bairro}" class="form-control">
					</div>
					
					<div  class="col-md-3 mb-3">
						<label for="cidade"> Cidade </label> <input type="text" name="cidade"
						id="cidade" value="${endereco.cidade}" class="form-control">
					</div>
					
					
					<div  class="col-md-3 mb-3">
						<label for="cep"> CEP </label> <input type="text" name="cep"
						id="cep" value="${endereco.cep}" class="form-control">
					</div>
				
				<c:if test="${veterinario.id == '0'}">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</c:if>	
									
					<c:if test="${veterinario.id  != '0' }">
						<button type="submit" class="btn btn-primary">Editar </button>
					</c:if>
				
				<a href="/" class="btn btn-success">Voltar</a>
		</form:form>					
	</div>
	
	</div>
		<c:if test="${not empty veterinarios }"	>
		<table class="table table-striped">
			<thead class="thead-dark">
			
			<tr>
			<th width="40%"> CRMV</th>
			<th width="20%"> Nome do Veterinário</th>
			<th width="20%"> Especialidade</th>
			<th width="20%"> Data  Nascimento</th>
			<th width="20% colspan="2" ">Ações</th>
			</tr>
			<c:forEach var="veterinario" items="${veterinarios}">
			
			<tr>	
			<td> ${veterinario.crmv}</td>
			<td> ${veterinario.nomeVeterinario}</td>
			<td> ${veterinario.especialidade}</td>
			<td> ${veterinario.dataNascimento}</td>
			<td><a href="${edita}/${veterinario.id}" class="btn btn-primary">Editar</a></td>
			<td><a href="${deleta}/${veterinario.id}"  class="btn btn-danger">Deletar</a></td>	
			</tr>
			
			
			</c:forEach>
			</table>
			</c:if>
	
	
	
	
	
	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	
</body>

</html>
