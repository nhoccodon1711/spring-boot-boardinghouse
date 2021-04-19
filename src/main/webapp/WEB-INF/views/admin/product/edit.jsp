<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="editProduct" value="/api/product"/>

<html>
<head>
    <title>Chỉnh sửa phòng đăng</title>
</head>
<body>

<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="/admin/home">Trang chủ</a>
                </li>
                <li class="active">Quản lý phòng đăng</li>
                <li class="active">Chỉnh sửa phòng đăng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form cssClass="form-horizontal" modelAttribute="product" action="${editProduct}" id="formEdit" method="PUT">
                        <form:hidden path="id"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name">Tên phòng</label>

                            <div class="col-sm-9">
                                <form:input path="name" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="district">Quận</label>

                            <div class="col-sm-9">
                                <div style="width: 4.2cm;">
                                    <form:select cssClass="form-control" path="district">
                                        <form:option value="" label="Chọn quận"/>
                                        <form:options items="${mapDistricts}"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="ward">Phường</label>

                            <div class="col-sm-9">
                                <form:input path="ward" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="street">Đường</label>

                            <div class="col-sm-9">
                                <form:input path="street" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="area">Diện tích</label>

                            <div class="col-sm-9">
                                <form:input path="area" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="areaDescription">Mô tả diện tích</label>

                            <div class="col-sm-9">
                                <form:input path="areaDescription" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="price">Giá thuê</label>

                            <div class="col-sm-9">
                                <form:input path="price" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="priceDescription">Mô tả giá</label>

                            <div class="col-sm-9">
                                <form:input path="priceDescription" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="priceDescription">Mô tả khác</label>

                            <div class="col-sm-9">
                                <form:input path="note" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="productCategory">Loại phòng</label>

                            <div class="col-sm-9">
                                <div style="width: 4.2cm;">
                                    <form:select cssClass="form-control" path="productCategory">
                                        <form:option value="" label="Chọn loại phòng"/>
                                        <form:options items="${mapCategories}"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="thumbnail">Thumbnail phòng</label>
                            <input class="col-sm-3 control-label no-padding-right" type="file" id="uploadImage"/>

                            <div class="col-sm-9">
                                <c:if test="${not empty product.thumbnail}">
                                    <c:set var="image" value="/repository${product.thumbnail}"/>
                                    <img src="${image}" id="viewImage" width="300px" height="300px">
                                </c:if>
                                <c:if test="${empty product.thumbnail}">
                                    <img src="/admin/image/default.png" id="viewImage" width="300px" height="300px">
                                </c:if>
                            </div>
                        </div>

                        <div class="btn-group pull-right">
                            <button class="btn btn-primary btn-bold" id="btnEditProduct">
                                Lưu thay đổi
                            </button>

                            <a type="button" class="btn btn-warning btn-bold" href="/admin/home">Hủy</a>
                        </div>
                    </form:form>
                </div>
            </div><!-- /.row -->
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->

<script>
    var thumbnailBase64 = '';
    var thumbnailImageName = '';

    $(document).ready(() => {
        console.log("Ready");
    });

    $('#btnEditProduct').click(function (e) {
        e.preventDefault();
        var data = {};
        var buildingTypes = [];
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (index, v) {
            if (v.value != '' && v.value != null) {
                data['' + v.name + ''] = v.value;
            }
            if (thumbnailBase64 != '') {
                data['thumbnailBase64'] = thumbnailBase64;
                data['thumbnailImageName'] = thumbnailImageName;
            }
        });
        $.ajax({
            type: 'POST',
            url: '/api/product',
            data: JSON.stringify(data),
            dataType: "json", // data from Server to Client
            contentType: "application/json", // data from Client to Server
            success: function (response) {
                window.location.href = "<c:url value='/admin/home'/>";
            },
            error: function (response) {
                console.log('failed');
                console.log(response);
            }
        });
    });

    $('#uploadImage').change(function (event) {
        var reader = new FileReader();
        var file = $(this)[0].files[0];
        reader.onload = function(e){
            thumbnailBase64 = e.target.result;
            thumbnailImageName = file.name; // ten hinh khong dau, khoang cach. vd: a-b-c
        };
        reader.readAsDataURL(file);
        openImage(this, "viewImage");
    });

    function openImage(input, imageView) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' +imageView).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
<script type='text/javascript' src="/admin/index.js"></script>
</body>
</html>
