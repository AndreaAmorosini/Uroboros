<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Modifica Prodotto"/>
</jsp:include>
<section>
    <h1>Modifica Prodotto ${prodotto.nomeProdotto}</h1>
    <form action="ModificaDatiProdotto">
        Nome Prodotto:<input type="text" name="nome" value="${prodotto.nomeProdotto}"><br>
        Descrizione Prodotto : <input type="text" name="descrizione" value="${prodotto.descrizioneProdotto}"><br>
        Prezzo Prodotto: <input type="text" name="prezzo" value="${prodotto.prezzoProdotto}"><br>
        Quantità disponibile: <input type="text" name="quantita" value="${prodotto.quantita}"><br>
        <input type="hidden" name="prodID" value="${prodotto.IDprodotto}">
        <input type="submit" value="Modifica">
    </form>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
