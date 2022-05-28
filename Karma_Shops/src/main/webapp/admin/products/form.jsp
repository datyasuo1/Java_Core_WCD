<%@ page import="com.example.karma_shops.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.karma_shops.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.karma_shops.entity.myenum.ProductStatus" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        Product obj = (Product) request.getAttribute("obj");
        List<Category> category = (List<Category>) request.getAttribute("category");
        if (category == null){
            category = new ArrayList<>();
        }
        int action = (int) request.getAttribute("action");
        HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
        String url = "/admin/products/create";
        if(action == 2){
            url = "/admin/products/edit";
        }if(errors == null) {
        errors = new HashMap<>();
    }
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create Product</title>


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
                        <h1><%=request.getAttribute("title")%></h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Validation</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- jquery validation -->
                        <div class="card card-primary">
                            <!-- /.card-header -->
                            <!-- form start -->
                            <a href="/admin/products/list">Back to list</a>
                            <form id="quickForm" action="<%=url%>" method="post" name="product-form">
                                <input type="hidden" name="id" class="form-control" value="<%=obj.getId()%>" %>
                                <div class="card-body">
                                    <div class="col-sm-5">
                                        <div class="form-group">
                                            <label for="name">Name</label>
                                            <input type="text" name="name" class="form-control" id="name" value="<%=obj.getName()%>" %>
                                            <%if(errors.containsKey("name")){%>
                                            <span class="text-danger">* <%=errors.get("name")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-sm-2">
                                        <label>Name Category</label>
                                        <div for="categoryId" class="form-group">
                                            <select class="form-control" name="categoryId" id="categoryId">
                                            <option value="0">Tất cả</option>
                                            <%for (int i = 0; i < category.size(); i++) {%>
                                                <%if (obj.getCategoryId() == category.get(i).getId()){%>
                                                <option selected value="<%=category.get(i).getId()%>"><%=category.get(i).getName()%></option>
                                                <%}else{%>
                                                <option  value="<%=category.get(i).getId()%>"><%=category.get(i).getName()%></option>
                                            <%}}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-5">
                                        <div class="form-group">
                                            <label for="description">Description</label>
                                            <input type="text" name="description" class="form-control" id="description" value="<%=obj.getDescription()%>" placeholder="Enter the description">
                                            <%if(errors.containsKey("description")){%>
                                            <span class="text-danger">* <%=errors.get("description")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-sm-5">
                                        <div class="form-group">
                                            <label for="upload_widget">Thumbnail</label>
                                            <div class="input-group">
                                                <div class="custom-file">
                                                    <input type="text" name="thumbnail" class="form-control" id="upload_widget" value="<%=obj.getThumbnail()%>" placeholder="Chose the thumbnail">
                                                </div>
                                                <div class="input-group-append">
                                                    <span class="input-group-text">Upload</span>
                                                </div>
                                            </div>
                                            <%if(errors.containsKey("thumbnail")){%>
                                            <span class="text-danger">* <%=errors.get("thumbnail")%></span>
                                            <%}%>
                                                <img id="preview-image" style="display: none" src="" alt="" class="img-bordered mt-2" width="200px">
                                        </div>
                                    </div>
                                    <div class="col-sm-10">
                                        <div class="form-group">
                                            <label for="detail">Detail</label>
                                            <textarea id="summernote" name="detail"id="detail"><%=obj.getDetail()%></textarea>
                                            <%if(errors.containsKey("detail")){%>
                                            <span class="text-danger">* <%=errors.get("detail")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label for="price">Price</label>
                                            <input type="text" name="price" class="form-control" id="price" value="<%=obj.getPrice()%>">
                                            <%if(errors.containsKey("price")){%>
                                            <span class="text-danger">* <%=errors.get("price")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label for="qty">Qty</label>
                                            <input type="text" name="qty" class="form-control" id="qty" value="<%=obj.getQty()%>">
                                            <%if(errors.containsKey("qty")){%>
                                            <span class="text-danger">* <%=errors.get("qty")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label for="status">Status</label>
                                            <select name="status" class="form-control" id="status">
                                                <%
                                                    for (int i = 0; i < ProductStatus.values().length; i++) {
                                                %>
                                                <option <%=obj.getStatus() == ProductStatus.values()[1]  ? "selected": "" %> value="<%=ProductStatus.values()[i].getValue()%>"><%=ProductStatus.values()[i].name()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                    </div>
                                    <!-- /.card-body -->
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary">Create</button>
                                    </div>

                            </form>
                        </div>
                        <!-- /.card -->
                    </div>
                    <!--/.col (left) -->
                    <!-- right column -->
                    <div class="col-md-6">

                    </div>
                    <!--/.col (right) -->
                </div>
                <!-- /.row -->
          <!-- /.container-fluid -->
        </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>

    <script>
        $(function () {
            // Summernote
            $('#summernote').summernote()

            // CodeMirror
            CodeMirror.fromTextArea(document.getElementById("codeMirrorDemo"), {
                mode: "htmlmixed",
                theme: "monokai"
            });
        })
        var myWidget = cloudinary.createUploadWidget({
                cloudName: 's-fgd',
                uploadPreset: 'ip2bdwzg'}, (error, result) => {
                if (!error && result && result.event === "success") {
                    console.log('Done! Here is the image info: ', result.info.secure_url);
                    document.forms['product-form']['thumbnail'].value = result.info.secure_url;
                    document.getElementById('preview-image').src = result.info.secure_url;
                    document.getElementById('preview-image').style.display = "block";
                }
            }
        )

        document.getElementById("upload_widget").addEventListener("click", function(){
            myWidget.open();
        }, false);
    </script>

    <!-- Control Sidebar  -->

    <!-- /.control-sidebar -->
</div>

</body>
</html>
