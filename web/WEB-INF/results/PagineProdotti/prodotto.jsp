<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="${prodotto.nomeProdotto}"/>
</jsp:include>



<!-- section with grid -->

<section>
    <grid>
        <div col="1/3" id="articolo" class="colLogin">



            <img src="img/prodotti/${prodotto.IDprodotto}.jpg">

            <h1>${prodotto.nomeProdotto}</h1>
            <h3>Descrizione:</h3>
            <p>${prodotto.descrizioneProdotto}</p>
        </div>

        <div col="1/3" class="colLogin"></div>

        <div col="1/3" class="colLogin">
            <h6>
                Categorie:
                <c:forEach items="${prodotto.categorieProdotto}" var="categoria" varStatus="status">
                    <a href="Categoria?id=${categoria.IDCategoria}">${categoria.nomeCategoria}</a><c:if test="${not status.last}">,</c:if>
                </c:forEach>

            </h6>
            <h1>Prezzo: ${prodotto.prezzoProdotto} &euro;</h1>
            <form action="Carrello" method="post">
                Quantità:
                <select name="quantita" id="quantità">
                    <c:forEach begin="1" end="30" varStatus="loop">
                        <option value="${loop.index}">${loop.index}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="prodID" value="${prodotto.IDprodotto}">
                <input type="submit" value="Acquista" id="button">
            </form>
        </div>
    </grid>
</section>

<jsp:include page="../footer.jsp"></jsp:include>