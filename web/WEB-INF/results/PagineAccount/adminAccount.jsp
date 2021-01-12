<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Account Amministratore"/>
</jsp:include>

<section>
    <h1>Pagina Di Gestione del Sito</h1>
    <h2>Benvenuto ${account.username}</h2>
   <div col="1/3">
       <form action="GestioneAccount">
           <input type="submit" value="Gestione degli Account">
       </form>
   </div>
    <div col="1/3">
        <form action="GestioneCategorie">
            <input type="submit" value="Gestione delle Categorie">
        </form>
    </div>
    <div col="1/3">
        <form action="GestioneProdotti">
            <input type="submit" value="Gestione dei Prodotti">
        </form>
    </div>

</section>

<jsp:include page="../footer.jsp"></jsp:include>
