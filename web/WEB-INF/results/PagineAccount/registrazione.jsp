<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 18/05/20
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Registrazione"/>
</jsp:include>

<grid>
    <div col="1/3" class="colLogin"></div>
    <div col="1/3" class="colLogin">
    <h1>Registrazione Nuovo Utente</h1>
    <form name="Registrazione" action="registrazione">
        <fieldset>
            <legend>Dati Account</legend>
            Username (Almeno 6 caratteri, non sono ammessi caratteri speciali):<br>
            <input type="text" id="username" name="username" oninput="validaUsername()"><br>
            Password (Almeno 8 caratteri, deve contenere una lettera maiuscola, una minuscola e un numero):<br>
            <input type="password" id="password" name="password" oninput="validaPassword()"><br>
            Verifica Password:<br>
            <input type="password" id="password1" name="password1" oninput="validaPassword()"><br>
        </fieldset>
        <fieldset>
            <legend>Dati Personali</legend>
            Nome:<br>
            <input type="text" id="nome" name="nome"><br>
            Cognome:<br>
            <input type="text" id="cognome" name="cognome"><br>
            Codice Fiscale:<br>
            <input type="text" id="CF" name="CF" oninput="validaCF()"><br>
            Data di nascita (bisogna avere minimo 18 anni):<br>
            <input type="date" id="dataDiNascita" name="dataDiNascita" oninput="validaData()"><br>
            Numero di telefono:<br>
            <input type="text" id="telefono" name="telefono"><br>
            E-mail (Diversa da e-mail precedentemente registrate nel sito):<br>
            <input type="email" id="mail" name="mail" oninput="validaEmail()"><br>
        </fieldset>
        <fieldset>
            <legend>Dati Pagamento</legend>
            Numero Carta:<br>
            <input type="text" id="#carta" name="#carta"><br>
            Tipo Carta(Mastercard,Visa,American Express...):<br>
            <input type="text" id="tipoCarta" name="tipoCarta"><br>
            Data di Scadenza:<br>
            <input type="date" id="dataDiScadenza" name="dataDiScadenza"><br>
            CSV:<br>
            <input type="text" id="CSV" name="CSV"><br>
            Nome del titolare:<br>
            <input type="text" id="nomeTitolare" name="nomeTitolare"><br>
            Cognome del titolare:<br>
            <input type="text" id="cognomeTitolare" name="cognomeTitolare"><br>
        </fieldset>
        <fieldset>
            <legend>Indirizzo di fatturazione e spedizione</legend>
            Via:<br>
            <input type="text" id="via" name="via"><br>
            Via 2:<br>
            <input type="text" id="via2" name="via2"><br>
            Nazione:<br>
            <input type="text" id="nazione" name="nazione"><br>
            Regione:<br>
            <input type="text" id="regione" name="regione"><br>
            CAP:<br>
            <input type="text" id="CAP" name="CAP"><br>
            Città:<br>
            <input type="text" id="città" name="città"><br>
        </fieldset>
        <br><input type="submit" id="registraButton" value="Registrati"><span id="registramiMessaggio"></span>
    </form>
    <br>
    </div>
    <div col="1/3" class="colLogin"></div>
</grid>
<script>
    const borderOK = '2px solid #717171';
    const borderNo = '2px solid #ff0000';
    let usernameOK = false;
    let passwordOK = false;
    let emailOK = false;

    function validaUsername(){
        const inputForm = document.forms.Registrazione;
        const inputUsername = inputForm.elements.username;
        if(inputUsername.value.length >= 6 && inputUsername.value.match(/^[0-9a-zA-Z]+$/)){
            const xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.onreadystatechange = function() {
                if(this.readyState == 4 && this.status == 200 && this.responseText == '<ok/>'){
                    usernameOK = true;
                    inputUsername.style.border = borderOK;
                }else{
                    inputUsername.style.border = borderNo;
                    usernameOK = false;
                }
            }
            xmlHttpRequest.open("GET", "VerificaUsername?username=" + encodeURIComponent(inputUsername.value), true);
            xmlHttpRequest.send();
        }else{
            inputUsername.style.border = borderNo;
            usernameOK = false;
        }
    }

    function validaPassword(){
        const inputForm = document.forms.Registrazione;
        const inputPass = inputForm.elements.password;
        const inputPassConf = inputForm.elements.password1;
        const password = inputPass.value;
        if(password.length >= 8 && password.toUpperCase()!=password && password.toLowerCase() != password && /[0-9]/.test(password)){
            inputPass.style.border = borderOK;
            if(password == inputPassConf.value){
                inputPassConf.style.border = borderOK;
                passwordOK = true;
            }else{
                inputPassConf.style.border = borderNo;
                passwordOK = false;
            }
        }else{
            inputPass.style.border = borderNo;
            inputPassConf.style.border = borderNo;
            passwordOK=false;
        }
    }

    function validaEmail() {
        var inputForm = document.forms.Registrazione;
        var inputMail = inputForm.elements.mail;
        if(inputMail.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)){
            inputMail.style.border = borderOK;
            emailOK = true;
        }else{
            inputMail.style.border = borderNo;
            emailOK = false;
        }
    }

    function cambiaStatoRegistrami(){
        if(usernameOK && passwordOK && emailOK){
            document.getElementById('registraButton').disabled = false;
            document.getElementById('registramiMessaggio').innerHTML = '';
        }else{
            document.getElementById('registraButton').disabled = true;
            document.getElementById('registramiMessaggio').innerHTML = 'Verifica che tutti i campi siano corretti';
        }
    }

</script>
<jsp:include page="../footer.jsp"></jsp:include>