<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Gestione Prodotti"/>
</jsp:include>
<section>
<h1>Gestione Prodotti</h1>
    <form action="cambioPagina?button=Aggiungi un Prodotto">
        <input type="submit" name="button" value="Aggiungi un Prodotto">
    </form>
<grid>
    <c:forEach items="${prodotti}" var="prodotto">
        <div col="1/3">
            <img src="img/prodotti/${prodotto.IDprodotto}.jpg">

            <h3>${prodotto.nomeProdotto}</h3>

            <h4>Prezzo: ${prodotto.prezzoProdotto} &euro;</h4>

            <form action="ModificaProdotto">
                <input type="hidden" name="prodID" value="${prodotto.IDprodotto}">
                <input type="submit" value="Modifica Prodotto">
            </form>

            <form action="CancellaProdotto">
                <input type="hidden" name="prodID" value="${prodotto.IDprodotto}">
                <input type="submit" value="Cancella Prodotto">
            </form>

        </div>
    </c:forEach>
</grid>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
