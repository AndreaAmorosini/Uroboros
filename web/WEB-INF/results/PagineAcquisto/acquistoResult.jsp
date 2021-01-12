<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Acquisto"/>
</jsp:include>

<section>
    <div col="1/3" class="colLogin"></div>
    <div col="1/3" class="colLogin">
        <h1>Acquisto Effettuato</h1>
                <h2>Transazione n° ${ultimoAcquisto.idTransazione}</h2>
                <h3>Data: ${ultimoAcquisto.data}</h3>
                <h3>Spesa Totale: ${ultimoAcquisto.spesa}</h3>
                <form action="ProdottiOrdine">
                    <input type="hidden" name="IdTransazione" value="${ultimoAcquisto.idTransazione}">
                    <input type="submit" value="Visualizza Prodotti">
                </form>
    </div>
    <div col="1/3" class="colLogin"></div>
</section>

<jsp:include page="../footer.jsp"></jsp:include>
