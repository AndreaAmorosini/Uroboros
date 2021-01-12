<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 18/05/20
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Login"/>
</jsp:include>

<grid>
    <div col="1/3" class="colLogin"></div>
    <div col="1/3" class="colLogin">
    <h1>Accesso all'Account</h1>
    <form action="login" method="get">
        Username:<br>
        <input type="text" id="username" name="username"><br>
        Password:<br>
        <input type="password" id="password" name="password"><br>
        <br><input type="submit" value="Login">
    </form>

    <a href="cambioPagina?link=registrazione">Registrazione nuovo utente</a>
    </div>
    <div col="1/3" class="colLogin"></div>

</grid>

<jsp:include page="../footer.jsp"></jsp:include>