<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 17/05/20
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Risultati Ricerca ${searchTerm}"/>
</jsp:include>

<!-- section with grid -->

<section>
    <h1>Risultati per la ricerca di ${searchTerm}</h1>
    
    <c:choose>
        <c:when test="${searchResult.isEmpty()==true}">
            Nessun prodotto corrisponde al termine di ricerca
        </c:when>
        <c:otherwise>
            <grid>
                <c:forEach items="${searchResult}" var="prodotto">
                    <div col="1/3">
                        <a href="Prodotto?id=${prodotto.IDprodotto}"><img src="img/prodotti/${prodotto.IDprodotto}.jpg"></a>

                        <h3><a href="Prodotto?id=${prodotto.IDprodotto}">${prodotto.nomeProdotto}</a></h3>

                        <h4>Prezzo: ${prodotto.prezzoProdotto} &euro;</h4>

                    </div>
                </c:forEach>
            </grid>
        </c:otherwise>
    </c:choose>
</section>

<jsp:include page="../footer.jsp"></jsp:include>