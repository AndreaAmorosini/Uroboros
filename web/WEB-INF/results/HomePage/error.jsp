<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 16/06/20
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Errore ${requestScope['javax.servlet.error.status_code']}"/>
</jsp:include>

<section>
    <h1>Errore ${requestScope['javax.servlet.error.status_code']}</h1>
    <pre>${requestScope['javax.servlet.error.exception']}</pre>
    <pre>
        <%
            if(exception!=null) {
                out.flush();
                exception.printStackTrace(response.getWriter());
            }
        %>
    </pre>
</section>

<jsp:include page="../footer.jsp"></jsp:include>