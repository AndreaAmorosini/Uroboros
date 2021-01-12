<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp">
    <jsp:param name="pageTitle" value="Homepage"/>
</jsp:include>


<!-- Slideshow container -->
<div class="slideshow-container">

    <!-- Full-width images with number and caption text -->
    <div class="mySlides fade">
        <div class="numbertext">1 / 3</div>
        <a href="#"><img src="img/uroboros.jpg" style="width:100%;height:50%"></a>
        <div class="text">Caption Text</div>
    </div>

    <div class="mySlides fade">
        <div class="numbertext">2 / 3</div>
        <a href="#"><img src="img/uroboros.jpg" style="width:100%;height:50%"></a>
        <div class="text">Caption Two</div>
    </div>

    <div class="mySlides fade">
        <div class="numbertext">3 / 3</div>
        <a href="#"><img src="img/uroboros.jpg" style="width:100%;height:50%"></a>
        <div class="text">Caption Three</div>
    </div>

    <!-- Next and previous buttons -->
    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
    <span class="dot" onclick="currentSlide(1)"></span>
    <span class="dot" onclick="currentSlide(2)"></span>
    <span class="dot" onclick="currentSlide(3)"></span>
</div>

<script>
    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("dot");
        if (n > slides.length) {slideIndex = 1}
        if (n < 1) {slideIndex = slides.length}
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " active";
    }
</script>

<!-- section with grid -->

<section>
    <h2>Prodotti in evidenza</h2>

    <grid>
        <c:forEach items="${prodotti}" var="prodotto">
        <div col="1/3">
            <a href="Prodotto?id=${prodotto.IDprodotto}"><img src="img/prodotti/${prodotto.IDprodotto}.jpg"></a>

            <h3><a href="Prodotto?id=${prodotto.IDprodotto}">${prodotto.nomeProdotto}</a></h3>

            <h4>Prezzo: ${prodotto.prezzoProdotto} &euro;</h4>

        </div>
        </c:forEach>
    </grid>
</section>

<jsp:include page="../footer.jsp"></jsp:include>