<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Modifica Dati"/>
</jsp:include>

<grid>
    <div col="1/3"></div>
    <div col="1/3">
        <h1>Modifica dati utente ${account.username}</h1>
        <form action="ModificaDatiAccount">
            <fieldset>
                <legend>Dati Account</legend>
                Username:<br>
                <input type="text" id="username" name="username" value="${account.username}"><br>
                Password:<br>
                <input type="password" id="password" name="password" value="${account.password}"><br>
                Verifica Password:<br>
                <input type="password" id="password1" name="password1" value="${account.password}"><br>
            </fieldset>
            <fieldset>
                <legend>Dati Personali</legend>
                Nome:<br>
                <input type="text" id="nome" name="nome" value="${contact.nome}"><br>
                Cognome:<br>
                <input type="text" id="cognome" name="cognome" value="${contact.cognome}"><br>
                Codice Fiscale:<br>
                <input type="text" id="CF" name="CF" value="${contact.CF}"><br>
                Data di nascita:<br>
                <input type="date" id="dataDiNascita" name="dataDiNascita" value="${contact.dataDiNascita}"><br>
                Numero di telefono:<br>
                <input type="text" id="telefono" name="telefono" value="${contact.telefono}"><br>
                E-mail:<br>
                <input type="email" id="mail" name="mail" value="${contact.email}"><br>
            </fieldset>
            <fieldset>
                <legend>Dati Pagamento</legend>
                Numero Carta:<br>
                <input type="text" id="#carta" name="#carta" value="${carta.numCarta}"><br>
                Tipo Carta(Mastercard,Visa,American Express...):<br>
                <input type="text" id="tipoCarta" name="tipoCarta"><br>
                Data di Scadenza:<br>
                <input type="date" id="dataDiScadenza" name="dataDiScadenza" value="${carta.dataDiScadenza}"><br>
                CSV:<br>
                <input type="text" id="CSV" name="CSV" value="${carta.CSV}"><br>
                Nome del titolare:<br>
                <input type="text" id="nomeTitolare" name="nomeTitolare" value="${carta.nomeTitolare}"><br>
                Cognome del titolare:<br>
                <input type="text" id="cognomeTitolare" name="cognomeTitolare" value="${carta.cognomeTitolare}"><br>
            </fieldset>
            <fieldset>
                <legend>Indirizzo di fatturazione e spedizione</legend>
                Via:<br>
                <input type="text" id="via" name="via" value="${indirizzo.via}"><br>
                Via 2:<br>
                <input type="text" id="via2" name="via2" value="${indirizzo.via2}"><br>
                Nazione:<br>
                <input type="text" id="nazione" name="nazione" value="${indirizzo.nazione}"><br>
                Regione:<br>
                <input type="text" id="regione" name="regione" value="${indirizzo.regione}"><br>
                CAP:<br>
                <input type="text" id="CAP" name="CAP" value="${indirizzo.CAP}"><br>
                Città:<br>
                <input type="text" id="città" name="città" value="${indirizzo.citta}"><br>
            </fieldset>
            <br><input type="submit" value="Salva">
        </form>
        <br>
    </div>
    <div col="1/3"></div>
</grid>
<jsp:include page="../footer.jsp"></jsp:include>
