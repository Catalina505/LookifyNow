<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="http://localhost:8080/css/style.css">
<title>TopTen</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
	<p class="h2" id="color">Top 10 Canciones</p>
	<a class="btn btn-success" href="/inicio" role="button">Volver</a>
<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">T�tulo</th>
      <th scope="col">Calificaci�n</th>
      <th scope="col">Acci�n</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${cancion }" var="cancion" end="9">
    <tr>
      <td><a href="/ver/${cancion.id}"><c:out value="${cancion.titulo }"/></a></td>
      <td><c:out value="${cancion.clasificacion }"/></td>
      <td><a method="POST" href="/${cancion.id}/borrar/borrar">Borrar</a>  <a href="/edit">Editar</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</body>
</html>