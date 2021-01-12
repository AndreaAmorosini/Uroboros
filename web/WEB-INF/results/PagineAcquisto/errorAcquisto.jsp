<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Errore di acquisto"/>
</jsp:include>

<section>
    <h1>Errore nell'operazione di acquisto</h1>
    <h2>è necessario fare il login per acquistare</h2>
    <form action="ShowAccount">
        <input type="submit" value="Login"></input>
    </form>
</section>

<jsp:include page="../footer.jsp"></jsp:include>
