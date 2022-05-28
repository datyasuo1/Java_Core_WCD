<%@ page import="java.util.List" %>
<%@ page import="com.example.karma_shops.entity.Product" %>
<%@ page import="com.example.karma_shops.entity.Category" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        Product product = (Product) request.getAttribute("obj");
        List<Category> category = (List<Category>) request.getAttribute("category");

    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%=product.getName()%> Detail</title>


</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/aside.jsp"></jsp:include>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>DataTables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">DataTables</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <!-- /.card -->
                        <a href="/admin/customers/create">Create new student</a>
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">Customer Detail</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <ul class="list-unstyled">
                                    <li>
                                        <p class="text-secondary">Name: <%=product.getName()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Description: <%=product.getDescription()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Detail: <%=product.getDetail()%></p>
                                    </li>
                                    <li>
                                        <p>Thumbnail: </p>
                                        <p class="text-secondary"><img class="img-bordered" src="<%=product.getThumbnail()%>" alt="" width="150px"></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Price: <%=product.getPrice()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Qty: <%=product.getQty()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Created At: <%=product.getCreatedAt()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Updated At: <%=product.getUpdatedAt()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Status: <%=product.getStatus()%></p>
                                    </li>
                                </ul>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->

    <!-- /.control-sidebar -->
</div>

</body>
</html>
