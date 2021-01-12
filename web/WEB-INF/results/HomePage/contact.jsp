<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 16/06/20
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Contact"/>
</jsp:include>

<section>
<h1>Keep Contact</h1>

    <h2>Contatti Social:</h2><br>
    <a href="www.Facebook.com">Facebook</a><br>
    <a href="www.Instagram.com">Instagram</a><br>
    <a href="www.Twitter.com">Twitter</a>

    <h2>Contatti Tradizionali</h2>
    <h3>Telefono : 1232456235</h3>
    <h3>Mail : Uroboros@gmail.com</h3>
</section>

<jsp:include page="../footer.jsp"></jsp:include>