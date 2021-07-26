<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="http://localhost:8080/css/style.css">
<title>Informacion Cancion</title>
</head>
<body class="p-3 mb-2 bg-dark text-white" id="main">
<div class="contenido">
	<h1 id="titulo">Información de la Canción</h1>
	<p class="h3" id="nombre">Título</p> <div class="h3" id="valor"><c:out value="${cancion.titulo }"/></div>
	<p class="h3" id="nombre">Artista</p> <div class="h3" id="valor"><c:out value="${cancion.artista }"/></div>
	<p class="h3" id="nombre">Clasificación</p> <div class="h3" id="valor"><c:out value="${cancion.clasificacion }"/></div>
<a id="btn" class="btn btn-success" href="/inicio" role="button">Volver</a>
</body>
</div>
</html>