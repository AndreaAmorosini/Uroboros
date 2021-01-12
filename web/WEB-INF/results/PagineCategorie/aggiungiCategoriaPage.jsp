<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Aggiunta Categoria"/>
</jsp:include>
<section>
    <h1>Aggiungi Categoria</h1>
    <form action="AggiungiCategoria">
        ID Categoria: <input type="text" name="IDCategoria"><br>
        Nome Categoria:<input type="text" name="nome"><br>
        Descrizione Categoria : <input type="text" name="descrizione"><br>
        <input type="submit" value="Aggiungi">
    </form>
</section>
<jsp:include page="../footer.jsp"></jsp:include>