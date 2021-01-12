<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Gestione Categorie"/>
</jsp:include>

<section>
    <h1>Gestione delle Categorie</h1>
    <form action="cambioPagina?button = Aggiungi Categoria">
        <input type="submit" name="button" value="Aggiungi Categoria">
    </form>
    <grid>
        <c:forEach items="${categorie}" var="categoria">
            <div col="1/3">
                <fieldset>
                    <h2>Nome : ${categoria.nomeCategoria}</h2>
                    <h3>Descrizione : ${categoria.descrizioneCategoria}</h3>
                    <form action="showCategoriaDetails">
                        <input type="hidden" name="IDCategoria" value="${categoria.IDCategoria}">
                        <input type="submit" value="Modifica Dettagli Categoria">
                    </form>
                    <form action="DeleteCategoria">
                        <input type="hidden" name="IDCategoria" value="${categoria.IDCategoria}">
                        <input type="submit" value="Cancella Categoria">
                    </form>
                </fieldset>
                <br>
            </div>
        </c:forEach>
    </grid>
</section>

<jsp:include page="../footer.jsp"></jsp:include>
