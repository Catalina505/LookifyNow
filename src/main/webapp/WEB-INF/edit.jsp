<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="http://localhost:8080/css/style.css">
<title>Editar Cancion</title>
</head>
<body class="p-3 mb-2 bg-dark text-white">
<h1 id="titulo">Editar Canción</h1>
<form action="/edit/${cancion.id}" method="POST">
  <div class="form-group">
    <label for="formGroupExampleInput">Título</label>
    <input name="titulo" type="text" class="form-control" id="formGroupExampleInput">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Artista</label>
    <input name="artista" type="text" class="form-control" id="formGroupExampleInput2">
  </div>
  <div class="form-group">
	  <label for="formGroupExampleInput2">Clasificación</label>
	  <input name="clasificacion" type="text" class="form-control" id="formGroupExampleInput2">
	  
 </div>
  <button type="submit" class="btn btn-success" id="btnCrear">EDITAR</button>
</form>
<a id="btnCrear" class="btn btn-primary" href="/inicio" role="button">VOLVER</a>
</body>
</html>