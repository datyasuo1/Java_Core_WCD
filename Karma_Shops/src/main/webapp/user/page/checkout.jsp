
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.karma_shops.entity.shoppingcart.CartItem" %>
<%@ page import="com.example.karma_shops.entity.shoppingcart.ShoppingCart" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<%
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
    if (shoppingCart == null){
        shoppingCart = new ShoppingCart();
    }
%>
<head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon-->
    <link rel="shortcut icon" href="/user/img/fav.png">
    <!-- Author Meta -->
    <meta name="author" content="CodePixar">
    <!-- Meta Description -->
    <meta name="description" content="">
    <!-- Meta Keyword -->
    <meta name="keywords" content="">
    <!-- meta character set -->
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>Karma Shop</title>

    <!--
            CSS
            ============================================= -->
    <jsp:include page="../includes/css.jsp"></jsp:include>

</head>

<body>

<!-- Start Header Area -->
<jsp:include page="../includes/header.jsp"></jsp:include>
<!-- End Header Area -->

<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Checkout</h1>
                <nav class="d-flex align-items-center">
                    <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="single-product.html">Checkout</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

<!--================Checkout Area =================-->
<section class="checkout_area section_gap">
    <div class="container">
        <div class="billing_details">
            <div class="row">
                <div class="col-lg-8">
                    <h3>Billing Details</h3>
                    <form class="row contact_form" action="/cart/checkout" method="post" novalidate="novalidate">
                        <div class="col-md-6 form-group p_star">
                            <span >First Name</span>
                            <input type="text" class="form-control" id="first" name="firstname" placeholder="First Name">

                        </div>
                        <div class="col-md-6 form-group p_star">
                            <span  >Last Name</span>
                            <input type="text" class="form-control" id="last" name="lastname" placeholder="Last Name">

                        </div>
                        <div class="col-md-6 form-group p_star">
                            <span >PhoneNumber</span>
                            <input type="text" class="form-control" id="number" name="shipPhone" placeholder="Phone Number">

                        </div>

                        <div class="col-md-12 form-group p_star">
                            <span >Address</span>
                            <input type="text" class="form-control" id="add2" name="shipAddress" placeholder="Address">

                        </div>
                        <div class="col-md-12 form-group p_star">
                            <textarea class="form-control" name="shipNote" id="message" rows="1"
                                      placeholder="Order Notes"></textarea>
                        </div>
                    </div>
                        <div class="col-lg-4">
                            <div class="order_box">

                                <h2>Your Order</h2>
                                <ul class="list">
                                    <li><a href="#">Product <span>Total</span></a></li>
                                    <%
                                    List<CartItem> items = shoppingCart.getListItems();
                                    double totalprice =0;
                                    for (int i = 0; i < items.size(); i++) {
                                         totalprice +=(items.get(i).getQuantity()*items.get(i).getUnitPrice());%>
                                    <li><a href="#"><%=items.get(i).getProductName()%><span class="middle"><%=items.get(i).getQuantity()%></span> <span class="last"><%=items.get(i).getUnitPrice() * items.get(i).getQuantity()%>VND</span></a></li>
                                    <%}%>

                                </ul>
                                <ul class="list list_2">
                                    <input name="totalPrice" type="hidden" value="<%=totalprice%>">
                                    <li><a href="#">Subtotal <span><%=totalprice%></span></a></li>
                                </ul>
                                <button class="primary-btn" type="submit">Payment</button>
                            </div>
                        </div>
                   </form>
            </div>
        </div>
    </div>
</section>
<!--================End Checkout Area =================-->

<!-- start footer Area -->
<jsp:include page="../includes/footer.jsp"></jsp:include>

<!-- End footer Area -->


<jsp:include page="../includes/scrip.jsp"></jsp:include>
</body>

</html>