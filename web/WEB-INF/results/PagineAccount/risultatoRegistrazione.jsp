<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 20/03/20
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Registrazione effettuata"/>
</jsp:include>

<grid>
    <div col="1/3"></div>
    <div col="1/3">
    <h1 align="CENTER">Utente Registrato correttamente</h1>
    <a href="ShowAccount">Torna alla pagina di login</a>
    </div>
    <div col="1/3"></div>
</grid>
<jsp:include page="../footer.jsp"></jsp:include>