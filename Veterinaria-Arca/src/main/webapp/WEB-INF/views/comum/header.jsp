<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<div class="pos-f-t">


	
	<c:if test=" ${not empty sucesso }">
		<div class="alert alert-info" role="alert">
		${sucesso}
		</div>
		</c:if>	

				
		
  <div class="collapse" id="navbarToggleExternalContent">
  
    <div class="bg-dark p-4">
  	 
      <h5 class="text-white h4" >Menu</h5>
      
      
   
      
      <h5 ><a href="/">Home</a></h5>
       <h5><a href="/cliente/novo">Cadastrar Cliente</a></h5>
        <h5><a href="/animal/novo">Cadastrar Pet</a></h5>
       <h5><a href="/veterinario/novo">Cadastrar veterinário</a></h5>
       <h5><a href="/exame/novo">Solicitação de exame</a></h5>
       <h5><a href="/atendimento/novo">Atendimento emergencial</a></h5>
        <h5><a href="/consulta/novo">Agendar consulta</a></h5>
       
      <span class="text-muted"> O melhor lugar para cuidar do seu Pet .</span>
    </div>
  </div>
  <nav class="navbar navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Alterna navegação">
      <span class="navbar-toggler-icon"></span> 
    <img src="https://1.bp.blogspot.com/-dU4xYAeTE04/WlugMnta35I/AAAAAAAAD4w/MVUCti-Zbs8_MKKuC9D2v7CTr5tKtTeZACLcBGAs/s1600/Gato%2Bem%2Bjanela.png" width="80" height="70" >
   Menu - Site para uso interno da Clínica 
    </button>
 
   

  </nav>
  
</div>
 

