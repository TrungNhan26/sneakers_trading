<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <style>
        .gallery-wrap .img-big-wrap img {
            height: 450px;
            width: auto;
            display: inline-block;
            cursor: zoom-in;
        }

        .gallery-wrap .img-small-wrap .item-gallery {
            width: 60px;
            height: 60px;
            border: 1px solid #ddd;
            margin: 7px 2px;
            display: inline-block;
            overflow: hidden;
        }

        .gallery-wrap .img-small-wrap {
            text-align: center;
        }

        .gallery-wrap .img-small-wrap img {
            max-width: 100%;
            max-height: 100%;
            object-fit: cover;
            border-radius: 4px;
            cursor: zoom-in;
        }

        .img-big-wrap img {
            width: 100% !important;
            height: auto !important;
        }
    </style>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <jsp:include page="Left.jsp"></jsp:include>
        <div class="col-sm-9">
            <div class="container">
                <div class="card">
                    <div class="row">
                        <aside class="col-sm-5 border-right">
                            <article class="gallery-wrap">
                                <div class="img-big-wrap">
                                    <div> <a href="#"><img src="${detail.image}"></a></div>
                                </div>
                            </article>
                        </aside>
                        <aside class="col-sm-7">
                            <article class="card-body p-5">
                                <h3 class="title mb-3">${detail.name}</h3>

                                <p class="price-detail-wrap"> 
                                    <span class="price h3 text-warning"> 
                                        <span class="currency">US $</span><span class="num">${detail.price}</span>
                                    </span> 
                                    <!--<span>/per kg</span>--> 
                                </p> <!-- price-detail-wrap .// -->
                                <dl class="item-property">
                                    <dt>Description</dt>
                                    <dd><p>${detail.description} </p></dd>
                                </dl>
<!--                                        <dl class="param param-feature">
                                    <dt>Model#</dt>
                                    <dd>12345611</dd>
                                </dl>   item-property-hor .// 
                                <dl class="param param-feature">
                                    <dt>Color</dt>
                                    <dd>Black and white</dd>
                                </dl>   item-property-hor .// 
                                <dl class="param param-feature">
                                    <dt>Delivery</dt>
                                    <dd>Russia, USA, and Europe</dd>
                                </dl>   item-property-hor .// -->

                           

                                <a href="#buyModal" class="btn btn-lg btn-primary text-uppercase" id="buyNowBtn"> Buy now </a>

                                <a href="#" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a>

                            </article>
                        </aside>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Edit Modal HTML -->
<div id="buyModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="add" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Buy</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Address</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input name="image" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Note</label>
                        <input name="price" type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success"id="okBtn"  value="OK">
                </div>
            </form>
        </div>
    </div>
</div>
<div id="successModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Success</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <p>Your order will be sent to you soon, thank you for your purchase</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">OK</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

<!-- JavaScript to show the modal form -->
<script>
    $(document).ready(function () {
        // Handle the click event of the "Buy now" button
        $("#buyNowBtn").click(function () {
            // Show the buy modal form
            $("#buyModal").modal("show");
        });

        // Handle the click event of the "OK" button in the buy modal
        $("#okBtn").click(function () {
            // Close the buy modal form
            $("#buyModal").modal("hide");

            // Show the success modal form
            $("#successModal").modal("show");
        });
    });
</script>
</body>
</html>