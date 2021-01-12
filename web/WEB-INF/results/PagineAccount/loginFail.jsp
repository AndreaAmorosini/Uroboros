<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 24/06/20
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Errore Login"/>
</jsp:include>

<section>
    <h1>Account utente non trovato nel sistema o password inserita non corretta</h1>
    <h2>Si prega di riprovare</h2>
    <form action="ShowAccount">
        <input type="submit" formaction="ShowAccount" value="Login">
    </form>
    <form action="cambioPagina?button = Registrati">
        <input type="submit" name="button" value="Registrati">
    </form>
</section>

<jsp:include page="../footer.jsp"></jsp:include>