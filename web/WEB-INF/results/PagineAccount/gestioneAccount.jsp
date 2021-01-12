<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Gestione Account"/>
</jsp:include>

<section>
    <h1>Gestione degli Account</h1>
    <grid>
        <c:forEach items="${accounts}" var="account">
            <div col="1/3">
            <fieldset>
                <h2>Username:<br> ${account.username}</h2>
                <form action="showAccountDetail">
                    <input type="hidden" name="username" value="${account.username}">
                    <input type="hidden" name="password" value="${account.password}">
                    <input type="submit" value="Visualizza Dettagli Account">
                </form>
                <form action="showStoricoAdmin">
                    <input type="hidden" name="username" value="${account.username}">
                    <input type="submit" value="Visualizza Ordini">
                </form>
                <form action="DeleteAccount">
                    <input type="hidden" name="username" value="${account.username}">
                    <input type="hidden" name="password" value="${account.password}">
                    <input type="submit" value="Cancella Account">
                </form>
            </fieldset>
            <br>
            </div>
        </c:forEach>
    </grid>
</section>

<jsp:include page="../footer.jsp"></jsp:include>
