<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách loại phòng</title>
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
                    <a href="/admin/home">Trang chủ</a>
                </li>
                <li class="active">Quản lý loại phòng</li>
                <li class="active">Danh sách loại phòng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">


            <!-- TABLE -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="pull-left">
                        <a href='<c:url value='/admin/category-new'/>'>
                            <button data-toggle="tooltip" title="Thêm loại phòng" class="btn btn-white btn-info btn-bold">
                                <i class="fa fa-plus-circle" aria-hidden="true"></i>
                            </button>
                        </a>
                        <button id="btnDeleteCategory" data-toggle="tooltip" title="Xóa loại phòng"
                                class="btn btn-white btn-warning btn-bold">
                            <i class="fa fa-trash" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>

                <div class="col-xs-12">
                    <div class="space space-30"></div>
                    <table id="categoryList" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Ngày cập nhật</th>
                            <th>Tên loại phòng</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${catogories}">
                            <tr role="row" class="odd">
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="id" value="${item.id}" id="checkbox_${item.id}"/>
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td><fmt:formatDate value="${item.modifiedDate}" pattern="dd/MM/yyyy"/></td>
                                <td>${item.name}</td>
                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <a type="button" class="btn btn-sm btn-primary" title="Chỉnh sửa"
                                           href="/admin/category-edit-${item.id}">
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
    $('#btnDeleteCategory').click(function (e) {
        e.preventDefault();
        //var data = {};
        var categoryIds = $('#categoryList').find('tbody input[type=checkbox]:checked').map(function() {
            return $(this).val();
        }).get();

        deleteCategory(categoryIds);
    });

    function deleteCategory(data) {
        $.ajax({
            type: "DELETE",
            url: '/api/category',
            data: JSON.stringify(data),
            //dataType: "json",
            contentType: "application/json",
            success: function (response) {
                window.location.href = "<c:url value='/admin/category-list'/>";
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
