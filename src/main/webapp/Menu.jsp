<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/menu.css" rel="stylesheet" type="text/css"/>
<!--begin of menu-->
<div style="background:black;"class="header">
<nav  class="navbar navbar-expand-md navbar-dark bg-dark">
<img style="height:120px; width:120px; margin-top:-6px;margin-bottom:-6px;margin-left:-20px;" alt="" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKFkdYPlvWlFBN-ffwA0SUXFA9eT9GPH1LS4nijC0mZg&s">
      <a style="font-size:50px;color:#6c757d;margin-left:10px;" class="navbar-brand" href="home">StockX</a>
    <div   class="container">
        
     
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
           <ul class="navbar-nav ml-auto">
    <c:if test="${sessionScope.acc.isSell == 1}">
        <li class="nav-item">
            <a class="nav-link" href="manager">My product</a>
        </li>
    </c:if>
    <c:if test="${sessionScope.acc != null }">
        <li class="nav-item">
            <a class="nav-link" href="#">Hello ${sessionScope.acc.user}</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="logout">Logout</a>
        </li>
    </c:if>
    <c:if test="${sessionScope.acc == null }">
        <li class="nav-item">
            <a class="nav-link" href="Login.jsp">Login</a>
        </li>
    </c:if>
</ul>


            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value = "${txts}" name="txt" type="text" class="form-control" aria-label="Small"
                           aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
    		<c:if test="${sessionScope.acc != null }">
            <a class="btn btn-success btn-sm ml-3" href="show">
                <i class="fa fa-shopping-cart"></i> Cart
            </a>
            </c:if>
        </div>
    </div>
</nav>

        <section  class="jumbotron text-center">
            <div class="container" style=" background-size: cover; height: 370px; width: 100%;margin-top:-65px;margin-bottom:18px;">
             <img  style="margin-left:-397px; height: 450px; width: 1900px" alt="" src="img/4b4f2-neutral-sneakers_hero-1000x683-1.jpg">
            </div>
        </section>
       </div>
        <!--end of menu-->