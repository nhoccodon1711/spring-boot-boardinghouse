<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="productListURL" value="/admin/home"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách phòng đăng</title>
</head>
<body>
<!-- main content -->
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="building-list.html">Home</a>
                </li>
                <li class="active">Quản lý phòng đăng</li>
                <li class="active">Danh sách phòng đăng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="widget-box">

                        <div class="widget-header">
                            <h4 class="widget-title">Tìm kiếm</h4>

                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <form:form cssClass="form-horizontal" modelAttribute="model" action="${productListURL}" id="listForm" method="GET">
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label style="font-weight:bold">Loại phòng</label>
                                                <form:select cssClass="form-control" path="productCategory">
                                                    <form:option value="" label="Chọn loại phòng"/>
                                                    <form:options items="${mapCategories}"/>
                                                </form:select>
                                            </div>
                                            <div class="col-sm-3">
                                                <label style="font-weight:bold">Khoảng giá</label>
                                                <form:select cssClass="form-control" path="price">
                                                    <form:option value="" label="Chọn khoảng giá"/>
                                                    <form:options items="${mapPrices}"/>
                                                </form:select>
                                            </div>
                                            <div class="col-sm-3">
                                                <label style="font-weight:bold">Diện tích</label>
                                                <form:select cssClass="form-control" path="area">
                                                    <form:option value="" label="Chọn diện tích"/>
                                                    <form:options items="${mapAres}"/>
                                                </form:select>
                                            </div>
                                            <div class="col-sm-3">
                                                <label style="font-weight:bold">Quận</label>
                                                <form:select cssClass="form-control" path="district">
                                                    <form:option value="" label="Chọn quận"/>
                                                    <form:options items="${mapDistricts}"/>
                                                </form:select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-2">
                                                <button type="button" class="btn btn-sm btn-primary" id="btnSearch">
                                                    Tìm kiếm
                                                    <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                </button>
                                            </div>
                                        </div>
                                </form:form>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="pull-right">
                                <a href='<c:url value='/admin/product-new'/>'>
                                    <button data-toggle="tooltip" title="Đăng tin phòng" class="btn btn-white btn-info btn-bold">
                                        <i class="fa fa-plus-circle" aria-hidden="true"></i>
                                    </button>
                                </a>
                                <button id="btnDeleteProduct" data-toggle="tooltip" title="Xóa phòng đăng"
                                        class="btn btn-white btn-warning btn-bold">
                                    <i class="fa fa-trash" aria-hidden="true"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- TABLE -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="space space-30"></div>
                    <table id="productList" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Ngày cập nhật</th>
                            <th>Tên phòng</th>
                            <th>Địa chỉ</th>
                            <th>Người đăng</th>
                            <th>Số điện thoại</th>
                            <th>Diện tích</th>
                            <th>Loại phòng</th>
                            <th>Giá thuê</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${products}">
                            <tr role="row" class="odd">
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="id" value="${item.id}" id="checkbox_${item.id}"/>
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td><fmt:formatDate value="${item.modifiedDate}" pattern="dd/MM/yyyy"/></td>
                                <td>${item.name}</td>
                                <td>${item.address}</td>
                                <td>${item.createdByConverted}</td>
                                <td>${item.phoneHost}</td>
                                <td>${item.area}</td>
                                <td>${item.productCategory}</td>
                                <td>${item.price}</td>
                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">

                                        <a type="button" class="btn btn-sm btn-primary" title="Chỉnh sửa"
                                           href="/admin/product-edit-${item.id}">
                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!-- Table ENDS -->
    </div><!-- /.page-content -->
</div> <!-- /.main-content -->
</div>
<script>
    $('#btnSearch').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();
    });

    $('#btnDeleteProduct').click(function (e) {
        e.preventDefault();
        //var data = {};
        var productIds = $('#productList').find('tbody input[type=checkbox]:checked').map(function() {
            return $(this).val();
        }).get();

        deleteProduct(productIds);
    });

    function deleteProduct(data) {
        $.ajax({
            type: "DELETE",
            url: '/api/product',
            data: JSON.stringify(data),
            //dataType: "json",
            contentType: "application/json",
            success: function (response) {
                window.location.href = "http://localhost:8080/admin/product-list";
            },
            error: function (response) {
                console.log('failed');
                console.log(response);
            }
        });
    }
</script>
</body>
</html>
