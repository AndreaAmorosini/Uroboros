<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 17/05/20
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="${categoria.nomeCategoria}"/>
</jsp:include>

<section mt->
    <h1>${categoria.nomeCategoria}</h1>

    <p>${categoria.descrizioneCategoria}</p>
</section>

<!-- section with grid -->

<section>
    <grid>
        <c:forEach items="${categoria.prodotti}" var="prodotto">
        <div col="1/3">
            <a href="Prodotto?id=${prodotto.IDprodotto}"><img src="img/prodotti/${prodotto.IDprodotto}.jpg"></a>

            <h3><a href="Prodotto?id=${prodotto.IDprodotto}">${prodotto.nomeProdotto}</a></h3>

            <h4>Prezzo: ${prodotto.prezzoProdotto} &euro;</h4>

        </div>
        </c:forEach>
    </grid>
</section>

<jsp:include page="../footer.jsp"></jsp:include>