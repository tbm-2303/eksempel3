<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>


<body>

<h1><%= "All Pokemon" %>
</h1>
<br/>


<c:forEach var="item" items="${applicationScope.PokemonListAppScope}">

    ${item}<br>


</c:forEach>










</body>


</html>