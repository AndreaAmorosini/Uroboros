<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 16/06/20
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Carrello"/>
</jsp:include>

<section>
<h1>Carrello</h1>
<grid>
    <c:forEach items="${carrello.prodotti}" var="pq">
        <div col="1/3">
            <a href="#"><img src="img/prodotti/${pq.prodotto.IDprodotto}.jpg"> </a>
        </div>
        <div col="1/3" class="colLogin">
            <h3>
                <a href="Prodotto?id=${pq.prodotto.IDprodotto}">${pq.prodotto.nomeProdotto}</a>
            </h3>
            <h5>Quantità. ${pq.quantita}, Prezzo unit. : ${pq.prodotto.prezzoProdotto}, Prezzo tot. : ${pq.prezzoTot} &euro;</h5>
            <form action="CarrelloRemove" method="post">
                <input type="hidden" name="prodId" value="${pq.prodotto.IDprodotto}">
                <input type="hidden" name="setNum" value="0">
                <input type="submit" value="Rimuovi">
            </form>
        </div>
        <br>
    </c:forEach>
    <c:if test="${empty carrello.prodotti}">
        <div col="1">Nessun prodotto nel carrello</div>
    </c:if>
</grid>
</section>
<c:if test="${not empty carrello.prodotti}">
    <section>
        <grid>
            <div col="1/3">
                <h2>Totale: ${carrello.prezzoTot} &euro;</h2>
            </div>
            <div col="1/3">
                <form action="Acquisto">
                    <input type="submit" value="Completa Acquisto">
                </form>
            </div>
        </grid>
    </section>
</c:if>


<jsp:include page="../footer.jsp"></jsp:include>