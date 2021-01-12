<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Contact"/>
</jsp:include>

<section>
    <h1>Dettagli Categoria : ${categoria.nomeCategoria}</h1>
    <form action="AggiornaCategoria">
        Nome Categoria: <input type="text" name="nome" value="${categoria.nomeCategoria}"><br>
        Descrizione Categoria: <input type="text" name="descrizione" value="${categoria.descrizioneCategoria}"><br>
        <input type="hidden" name="IDCategoria" value="${categoria.IDCategoria}">
        <input type="submit" value="Aggiorna Dati">
    </form>
</section>

<jsp:include page="../footer.jsp"></jsp:include>
