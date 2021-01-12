<%@ page import="model.JavaBeans.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ater
  Date: 17/05/20
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Uroboro - ${param.pageTitle}</title>
    <link rel="stylesheet" type="text/css" href="homepageStyle.css">
    <link rel="stylesheet" href=
            "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- meta -->
    <meta charset=utf-8>
    <meta name="description" content="Homepage Uroboro">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>

    <!-- css -->
</head>

<!-- body -->

<body>

<!-- nav -->

<nav id="navMenu">
    <label>
        <header class="top">
            <a href="BackToHome" id="Home"><img id="logo" src="img/uroboros.jpg">Uroboros</a>
        </header>
        <ul id="menu" class="menu">
            <div id="sideMenu">
            <li class="menuItem"><a href="cambioPagina?link=aboutus">About Us</a></li>
            <li class="menuItem"><a href="cambioPagina?link=contact">Contact</a></li>
            <li class="dropdown">
                <a>Catalogo</a>
                <div class="dropdownItem">
                    <a href="Catalogo">Catalogo Completo</a>
                    <c:forEach items="${categorie}" var="categoria">
                        <a href="Categoria?id=${categoria.IDCategoria}">${categoria.nomeCategoria}</a>
                    </c:forEach>
                </div>
            </li>
            <li class="menuItem"><a href="Carrello">Carrello</a></li>
            <li class="dropdownLogin">
                <a>Account</a>
                <div class="dropdownItemLogin">
                    <% HttpSession Session = request.getSession();
                        if(Session.getAttribute("account")!=null){
                     %>
                    <a href="ShowAccount">Profilo</a>
                    <a href="Storico">Storico ordini</a>
                    <% Account account = (Account) session.getAttribute("account");
                        if(account.isAdmin()==true){
                     %>
                    <a href="cambioPagina?link=dashboard">Dashboard</a>
                    <%}%>
                    <a href="Logout">LogOut</a>
                    <% } else { %>
                    <a href="ShowAccount">Accedi</a>
                    <a href="cambioPagina?link=registrazione">Registrati</a>
                    <% } %>
                </div>
            </li>
            </div>
            <li class="searchDropdown">
                <a class="searchDrop"><i class="fa fa-search"></i></a>
                <div class="dropdownSearchBar">
                    <form action="Search" class="searchForm">
                        <input type="text" placeholder="   Search..." class="searchTerm" name="searchTerm">
                        <button type="submit" class="searchButton"><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </li>
            <li class="icon" id="menuLink" onclick="mobileMenu()"><a><i class="fa fa-bars"></i></a></li>
            <div id="menuDisplay"></div>

        </ul>
    </label>
</nav>
<script>
    function mobileMenu(){
        var node = document.getElementById("sideMenu");
        document.getElementById("menuDisplay").appendChild(node);
        toggle();
    }

    function toggle(){
        var x = document.getElementById("menuDisplay");
        var y = document.getElementById("sideMenu");
        if(x.style.display!=="none"){
            x.style.display="block";
            y.style.display="block";
        }else if(x.style.display!=="block"){
            x.style.display="none";
            y.style.display="none";
        }
    }

    document.getElementById("menuLink").addEventListener("click",mobileMenu);

</script>