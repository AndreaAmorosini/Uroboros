<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Aggiunta Prodotto"/>
</jsp:include>
<section>
    <h1>Aggiungi Prodotto </h1>
    <form action="AggiungiProdotto" method="post" enctype="multipart/form-data">
        Immagine Prodotto : <label class="file-upload-button"><input type="file" name="file"></label><br>
        ID Prodotto: <input type="text" name="prodID"><br>
        Nome Prodotto:<input type="text" name="nome"><br>
        Descrizione Prodotto : <input type="text" name="descrizione"><br>
        Prezzo Prodotto: <input type="text" name="prezzo"><br>
        Quantità disponibile: <input type="text" name="quantita"><br>
        Categoria: <select name="categoria">
        <c:forEach items="${categorie}" var="categoria">
            <option value="${categoria.IDCategoria}">${categoria.nomeCategoria}</option>
        </c:forEach>
    </select><br>
        <input type="submit" value="Aggiungi">
    </form>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
