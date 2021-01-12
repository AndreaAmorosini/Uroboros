<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Storico Ordini - Prodotti"/>
</jsp:include>

<section>
        <h1>Transazione n° ${idTransazione} di ${account.username}</h1>
        <grid>
        <c:forEach items="${prodottiOrdine}" var="prodotto">
            <div col="1/3">
                <a href="Prodotto?id=${prodotto.IDprodotto}"><img src="img/prodotti/${prodotto.IDprodotto}.jpg"></a>

                <h3><a href="Prodotto?id=${prodotto.IDprodotto}">${prodotto.nomeProdotto}</a></h3>

                <h4>Prezzo: ${prodotto.prezzoProdotto} &euro;</h4>

            </div>
        </c:forEach>
        </grid>
    </div>
</section>

<jsp:include page="../footer.jsp"></jsp:include>
