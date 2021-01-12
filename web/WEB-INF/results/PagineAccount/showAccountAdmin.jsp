
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Gestione Dati Account"/>
</jsp:include>

<grid>
    <div col="1/3" class="colLogin"></div>
    <div col="1/3" class="colLogin">
        <fieldset>
            <legend>Dati Account</legend>
            Username: ${accountC.username}<br>
        </fieldset>
        <fieldset>
            <legend>Dati Personali</legend>
            Nome:${contactC.nome}<br>
            Cognome:${contactC.cognome}<br>
            Codice Fiscale:${contactC.CF}<br>
            Data di nascita:${contactC.dataDiNascita}<br>
            Numero di telefono:${contactC.telefono}<br>
            E-mail:${contactC.email}<br>
        </fieldset>
        <fieldset>
            <legend>Dati Pagamento</legend>
            Numero Carta:${cartaC.numCarta}<br>
            Tipo Carta(Mastercard,Visa,American Express...):<br>
            Data di Scadenza:${cartaC.dataDiScadenza}<br>
            Nome del titolare:${cartaC.nomeTitolare}<br>
            Cognome del titolare:${cartaC.cognomeTitolare}<br>
        </fieldset>
        <fieldset>
            <legend>Indirizzo di fatturazione e spedizione</legend>
            Via:${indirizzoC.via}<br>
            Via 2:${indirizzoC.via2}<br>
            Nazione:${indirizzoC.nazione}<br>
            Regione:${indirizzoC.regione}<br>
            CAP:${indirizzoC.CAP}<br>
            Città:${indirizzoC.citta}<br>
        </fieldset>
    </div>
    <div col="1/3" class="colLogin"></div>
    <br>
</grid>

<jsp:include page="../footer.jsp"></jsp:include>