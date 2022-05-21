<%@ page import="java.util.List" %>
<%@ page import="com.t2010a.javashopping.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 20/05/2022
  Time: 11:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("listProduct");
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
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                <a href="/admin/products/create">Create New Product</a>
                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Content</th>
                                    <th>Size</th>
                                    <th>Quantity</th>
                                    <th>Sku</th>
                                    <th>Category</th>
                                    <th>Tag</th>
                                    <th>Create At</th>
                                    <th>Update At</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Content</th>
                                    <th>Size</th>
                                    <th>Quantity</th>
                                    <th>Sku</th>
                                    <th>Category</th>
                                    <th>Tag</th>
                                    <th>Create At</th>
                                    <th>Update At</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <%for (Product pd : products){%>
                                <tr>
                                    <th><%=pd.getId()%></th>
                                    <th><%=pd.getName()%></th>
                                    <th><%=pd.getPrice()%></th>
                                    <th><%=pd.getContent()%></th>
                                    <th><%=pd.getSize()%></th>
                                    <th><%=pd.getQty()%></th>
                                    <th><%=pd.getSku()%></th>
                                    <th><%=pd.getCategory()%></th>
                                    <th><%=pd.getTag()%></th>
                                    <th><%=pd.getCreatedAt()%></th>
                                    <th><%=pd.getUpdatedAt()%></th>
                                    <th><%=pd.getStatus()%></th>
                                    <th>
                                        <a href="/admin/products/detail?id=<%=pd.getId()%>"><i class="fas fa-arrow-circle-right"></i></a>
                                        <a href="/admin/products/edit?id=<%=pd.getId()%>"><i class="fa fa-pencil-alt"></i></a>
                                        <a href="/admin/products/delete?id=<%=pd.getId()%>" onclick="return confirm('Are you sure?')"><i class="fas fa-trash"></i></a>
                                    </th>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
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
