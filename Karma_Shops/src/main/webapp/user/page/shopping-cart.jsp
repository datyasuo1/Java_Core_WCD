<%@ page import="com.example.karma_shops.entity.shoppingcart.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.karma_shops.entity.shoppingcart.CartItem" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<%
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
    if (shoppingCart == null){
        shoppingCart = new ShoppingCart();
    }
%>
<head>
    <!-- CSS only -->
    <!-- JavaScript Bundle with Popper -->
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
                <h1>Shopping Cart</h1>
                <nav class="d-flex align-items-center">
                    <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="category.html">Cart</a>
                </nav>
            </div>
        </div>
    </div>
</section>

<!-- End Banner Area -->

<!--================Cart Area =================-->
<section class="cart_area">
    <div class="container">
        <div class="cart_inner">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Product</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<CartItem> items = shoppingCart.getListItems();
                        for (int i = 0; i < items.size(); i++) {%>
                    <tr>
                        <td>
                            <div class="media">
                                <div class="d-flex">
                                    <img src="<%=items.get(i).getProductThumbnail()%>" alt="" style="max-width: 250px">
                                </div>
                                <div class="media-body">
                                    <p><%=items.get(i).getProductName()%></p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <h5><%=items.get(i).getUnitPrice()%>VND</h5>
                        </td>
                        <td>
                            <div class="product_count">
                                <input type="text" name="qty" id="sst" maxlength="12" value="<%=items.get(i).getQuantity()%>" title="Quantity:"
                                       class="input-text qty">
                                <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;"
                                        class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
                                <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;"
                                        class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button>
                            </div>
                        </td>
                        <td>
                            <h5><%=items.get(i).getUnitPrice() * items.get(i).getQuantity()%>VND</h5>
                        </td>
                        <td>
                            <a class="fa fa-remove"href="/cart/delete?id=<%=items.get(i).getProductId()%>" onclick="return confirm('Are you sure?')"></a>
                        </td>
                    </tr>

                    <%}%>
                    <tr class="bottom_button">
                        <td>
                            <a class="gray_btn" href="#">Update Cart</a>
                        </td>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>
                            <div class="cupon_text d-flex align-items-center">
                                <input type="text" placeholder="Coupon Code">
                                <a class="primary-btn" href="#">Apply</a>
                                <a class="gray_btn" href="#">Close Coupon</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>
                            <h5>Subtotal</h5>
                        </td>
                        <td>
                            <h5>$2160.00</h5>
                        </td>
                    </tr>
                    <tr class="out_button_area">
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>
                            <div class="checkout_btn_inner d-flex align-items-center">
                                <a class="gray_btn" href="/products">Continue Shopping</a>
                                <a class="primary-btn" href="/cart/checkout">Proceed to checkout</a>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!--================End Cart Area =================-->

<!-- start footer Area -->
<jsp:include page="../includes/footer.jsp"></jsp:include>

<!-- End footer Area -->
<jsp:include page="../includes/scrip.jsp"></jsp:include>


</body>

</html>