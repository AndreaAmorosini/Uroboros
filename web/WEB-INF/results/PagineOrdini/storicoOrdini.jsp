<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Storico Ordini"/>
</jsp:include>

<section>
    <h1>Storico ordini di ${account.username}</h1>
    <grid>
    <c:forEach items="${transazioni}" var="transazione">
        <div col="1/3">
        <fieldset>
            <legend>Transazione n° ${transazione.idTransazione}</legend>
            <h2>Data: ${transazione.data}</h2>
            <h2>Spesa Totale: ${transazione.spesa}</h2>
            <form action="ProdottiOrdine">
            <input type="hidden" name="IdTransazione" value="${transazione.idTransazione}">
            <input type="submit" value="Visualizza Prodotti">
            </form>
        </fieldset>
        </div>
    </c:forEach>
    </grid>
</section>

<jsp:include page="../footer.jsp"></jsp:include>