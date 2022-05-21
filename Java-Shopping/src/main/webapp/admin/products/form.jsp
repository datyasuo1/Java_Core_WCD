<%@ page import="com.t2010a.javashopping.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 21/05/2022
  Time: 2:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Product product = (Product) request.getAttribute("product");
  int action = (int) request.getAttribute("action");
  String url = "/admin/products/create";
  if(action == 2){
    url = "/admin/products/edit";
  }
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
      <div class="row">
        <!-- left column -->
        <div class="col-md-8">
          <!-- general form elements -->
          <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">Create product</h3>
            </div>
            <!-- /.card-header -->
            <!-- form start -->
            <form action="<%=url%>" method="post">
              <div class="card-body">
                <div class="form-group">
                  <label for="id">Id</label>
                  <input type="text" class="form-control" id="id" name="id" placeholder="Enter id" value="<%=product.getId()%>" <%=action == 2 ? "readonly":""%>>
                </div>
                <div class="form-group">
                  <label for="name">Name</label>
                  <input type="text" class="form-control" id="name" name="name" placeholder="Enter name"  value="<%=product.getName()%>">
                </div>
                <div class="form-group">
                  <label for="price">Price</label>
                  <input type="number" class="form-control" id="price" name="price" placeholder="Enter price" value="<%=product.getPrice()%>">
                </div>
                <div class="form-group">
                  <label for="contents">Content</label>
                  <input type="text" class="form-control" id="contents" name="content" placeholder="Enter content" value="<%=product.getContent()%>">
                </div>
                <div class="form-group">
                  <label for="size">Size</label>
                  <input type="text" class="form-control" id="size" name="size" placeholder="Enter size" value="<%=product.getSize()%>">
                </div>
                <div class="form-group">
                  <label for="qty">Quantity</label>
                  <input type="number" class="form-control" id="qty" name="qty" placeholder="Enter quantity" value="<%=product.getQty()%>">
                </div>
                <div class="form-group">
                  <label for="sku">Sku</label>
                  <input type="number" class="form-control" id="sku" name="sku" placeholder="Enter sku" value="<%=product.getSku()%>">
                </div>
                <div class="form-group">
                <label for="category">Category</label>
                <input type="text" class="form-control" id="category" name="category" placeholder="Enter category" value="<%=product.getCategory()%>">
              </div>
                <div class="form-group">
                  <label for="tag">Tag</label>
                  <input type="text" class="form-control" id="tag" name="tag" placeholder="Enter tag" value="<%=product.getTag()%>">
                </div>
                <!-- /.form group -->
                <div class="form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
              </div>
              <!-- /.card-body -->

              <div class="card-footer">
                <button type="submit" class="btn btn-primary">Save</button>
                <button type="reset" class="btn btn-default">Reset</button>
              </div>
            </form>
          </div>
          <!-- /.card -->

        </div>
        <!--/.col (left) -->
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

