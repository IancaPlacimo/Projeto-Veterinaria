<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinária Arca de Noé - Cliente </title>

<link href="/css/bootstrap.min.css" rel="styLesheet">

</head>
<body>

		<spring:url value="/cliente/cadastra" var="cadastra"/>
		<spring:url value="/cliente/deleta" var="deleta"/>
		<spring:url value="/cliente/edita" var="edita"/>

		<jsp:include page="../comum/header.jsp"></jsp:include>
	
		<div class="container">
		<div class="pb-2 mt-5 mb-2 border-bottom">
			
			<h1>Cadastro de Clientes</h1>
		
			<form:form modelAttribute="cliente"  action="${cadastra}" >
			
			<input type="hidden" name="id" id="id" value="${cliente.id}"/>
			
				<div class="form-group">
						<label for="nomeDono">Nome Completo</label> <input type="text" name="nomeDono"
						id="nomeDono" value="${cliente.nomeDono}" class="form-control">
					</div>
					
					<div class="form-group">
						<label for="dataNasc">Data de Nascimento</label>
						<input type="date" name="dataNasc" id="dataNasc" value= "${cliente.dataNasc}"  />										
					</div>
			
					<div class="form-group">
					<label for="cpfDono">CPF</label> <input type="text" name="cpfDono"
					id="cpfDono" value="${cliente.cpfDono}" class="form-control">
					</div>
					
					<div class="form-group">
					<label for="telefone">Telefone</label> <input type="text" name="telefone"
					id="telefone" value="${cliente.telefone}" class="form-control">
					</div>	
																																			
					
					<h3> Endereço </h3>
							
					
					<div class="col-md-9 mb-9">
					<label for="rua"> Rua </label> <input type="text" name="rua"
					id="rua" value="${endereco.rua}" class="form-control">
					</div>
					
					<div class="col-md-5 mb-5">
					<label for="numero"> Número </label> <input type="text" name="numero"
					id="numero" value="${endereco.numero}" class="form-control">
					</div>
					
					<div class="col-md-5 mb-5">
						<label for="complemento"> Complemento </label> <input type="text" name="complemento"
						id="complemento" value="${endereco.complemento}" class="form-control">
					</div>
					
					<div class="col-md-3 mb-3">
						<label for="estado"> Estado </label> <input type="text" name="estado"
						id="estado" value="${endereco.estado}" class="form-control">
					</div>
					
					<div class="col-md-3 mb-3">
					<label for="cidade"> Cidade </label> <input type="text" name="cidade"
					id="cidade" value="${endereco.cidade}" class="form-control">
					</div>
					
					<div class="col-md-3 mb-3">
					<label for="bairro"> Bairro </label> <input type="text" name="bairro"
					id="bairro" value="${endereco.bairro}" class="form-control">
					</div>
					
					<div class="col-md-3 mb-3">
						<label for="cep"> CEP </label> <input type="text" name="cep"
						id="cep" value="${endereco.cep}" class="form-control">
					</div>
					
					<c:if test="${cliente.id == '0'}">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</c:if>					
					<c:if test="${cliente.id  != '0' }">
						<button type="submit" class="btn btn-primary">Editar</button>
					</c:if>
					
				<a href="/" class="btn btn-success">Voltar</a>		
				</form:form>				
			</div>
	
	<c:if test="${not empty clientes }"	>
		<table class="table table-dark table-hover">
			<thead class="thead-dark">
			
			<tr>
			<th width="20%"> Nome do Dono</th>
			<th width="20%">CPF</th>
			<th width="20%"> Telefone</th>
			<th colspan="3" width="20%">Ações</th>
			</tr>
			<c:forEach var="cliente" items="${clientes}">
			
			<tr>	
			<td> ${cliente.nomeDono}</td>
			<td> ${cliente.cpfDono}</td>
			<td> ${cliente.telefone}</td>
			
			
			
			<td><a href="${edita}/${cliente.id}" class="btn btn-primary">Editar</a></td>
			<td><a href="${deleta}/${cliente.id}"  class="btn btn-danger">Deletar</a></td>	
			</tr>
			
			
			</c:forEach>
			</table>
			</c:if>
	
	
	
	
	
	
	
	
	
	
	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	
</body>
</html>