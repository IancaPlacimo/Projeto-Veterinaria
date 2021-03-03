<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title class="font-weight-bold">Veterinária Arca de Noé - Home </title>

<link href="/css/bootstrap.min.css" rel="styLesheet">

</head>
<body>


	<jsp:include page="comum/header.jsp"></jsp:include>
	<jsp:include page="comum/rodape.jsp"></jsp:include>
	
	
	<img src="https://i.ibb.co/D5WSp3m/Arca-de-No-2.png"  class="mx-auto d-block rounded-circle"  alt="Cinque Terre">

		<div class="container">
		<div class="pb-2 mt-5 mb-2 border-bottom">
		<div class="card-group" >	
			
					<div class="col-sm-3">
							  <div class="card border-danger mb-3" style="width:200px"  >
							  	<img class="card-img-top" src="https://i.ibb.co/RYsJ03r/Design-sem-nome-14.png" alt="Card image">
							  <div class="card-body">
							    <h4 class="card-title">Atendimento Emergencial</h4>
							    <a  href="/atendimento/novo" class="btn btn-outline-danger">Solicitar </a>
						  </div>
						</div>
					</div>
					
					<div class="col-sm-3">
					  <div class="card border-warning mb-3" style="width:200px">
					  <img class="card-img-top" src="https://i.ibb.co/3v51Dy9/Design-sem-nome-16.png" alt="Card image">
					  <div class="card-body">
					    <h4 class="card-title">Agendar consulta</h4>
					    <a href="/consulta/novo" class="btn btn-outline-warning">Solicitar</a>
					  </div>
				</div>
			</div>
					      				
					<div class="col-sm-3">
					  <div class="card border-primary mb-3" style="width:200px">
					  <img class="card-img-top" src="https://i.ibb.co/ccMtnnx/Design-sem-nome-17.png" alt="Card image">
					  <div class="card-body">
					    <h4 class="card-title">Solicitação de Exames</h4>
					    <a href="/exame/novo" class="btn btn-outline-primary">Solicitar</a>
					 </div>
				</div>
			</div>
					
					<div class="col-sm-3">
					  <div class="card border-dark mb-3" style="width:200px">
					  <img class="card-img-top" src="https://i.ibb.co/5j81ggB/Design-sem-nome-15.png" alt="Card image">
					  <div class="card-body">
					    <h4 class="card-title">Informações Gerais</h4>
					    <a href="/apresentacao/novo" class="btn btn-outline-dark">Solicitar</a>
					  </div>
					</div>
				</div>
									      
 			 </div>
  		 </div>
   	
	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	
	

</body>
</html>