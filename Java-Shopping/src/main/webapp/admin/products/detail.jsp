<%@ page import="com.t2010a.javashopping.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 21/05/2022
  Time: 9:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="../includes/sidebar.jsp"></jsp:include>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <jsp:include page="../includes/topbar.jsp"></jsp:include>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <!-- Default box -->
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">Product Detail</h3>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12 col-md-12 col-lg-4 order-1 order-md-2">
                            <h3 class="text-primary"></i><%=product.getName()%></h3>
                            <p class="text-muted"><%=product.getContent()%></p>
                            <br>
                            <div class="text-muted">
                                <p class="text-sm">Price
                                    <b class="d-block"><%=product.getPrice()%></b>
                                </p>
                                <p class="text-sm">Quantity
                                    <b class="d-block"><%=product.getQty()%></b>
                                </p>
                            </div>

                            <h5 class="mt-5 text-muted">Other</h5>
                            <ul class="list-unstyled">
                                <li>
                                    <p class="text-secondary">Size: <%=product.getSize()%></p>
                                </li>
                                <li>
                                    <p class="text-secondary">Sku: <%=product.getSku()%></p>
                                </li>
                                <li>
                                    <p class="text-secondary">Category: <%=product.getCategory()%></p>
                                </li>
                                <li>
                                    <p class="text-secondary">Tag: <%=product.getTag()%></p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- /.card-body -->
            </div>
            <!-- /.card -->
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <jsp:include page="../includes/footer.jsp"></jsp:include>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<jsp:include page="../includes/script.jsp"></jsp:include>

</body>

</html>