
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Account"/>
</jsp:include>

<grid>
    <div col="1/3" class="colLogin"></div>
    <div col="1/3" class="colLogin">
        <fieldset>
            <legend>Dati Account</legend>
            Username: ${account.username}<br>
            Password: ${account.password}<br>
        </fieldset>
        <fieldset>
            <legend>Dati Personali</legend>
            Nome:${contact.nome}<br>
            Cognome:${contact.cognome}<br>
            Codice Fiscale:${contact.CF}<br>
            Data di nascita:${contact.dataDiNascita}<br>
            Numero di telefono:${contact.telefono}<br>
            E-mail:${contact.email}<br>
        </fieldset>
        <fieldset>
            <legend>Dati Pagamento</legend>
            Numero Carta:${carta.numCarta}<br>
            Tipo Carta(Mastercard,Visa,American Express...):<br>
            Data di Scadenza:${carta.dataDiScadenza}<br>
            CSV:${carta.CSV}<br>
            Nome del titolare:${carta.nomeTitolare}<br>
            Cognome del titolare:${carta.cognomeTitolare}<br>
        </fieldset>
        <fieldset>
            <legend>Indirizzo di fatturazione e spedizione</legend>
            Via:${indirizzo.via}<br>
            Via 2:${indirizzo.via2}<br>
            Nazione:${indirizzo.nazione}<br>
            Regione:${indirizzo.regione}<br>
            CAP:${indirizzo.CAP}<br>
            Città:${indirizzo.citta}<br>
        </fieldset>
        <form action="cambioPagina?button=Modifica Dati">
            <br><input type="submit" name="button" value="Modifica Dati">
        </form>
    </div>
    <div col="1/3" class="colLogin"></div>
</grid>

<jsp:include page="../footer.jsp"></jsp:include>