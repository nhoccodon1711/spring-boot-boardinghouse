<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="userList" value="/admin/user-list"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
            Danh sách người dùng
    </title>
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
                <li class="active">Quản lý người dùng</li>
                <li class="active">Danh sách người dùng</li>
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
                                <form:form cssClass="form-horizontal" modelAttribute="model" action="${userList}" id="listForm" method="GET">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                        <label style="font-weight:bold">Username</label>
                                        <form:input path="userName" cssClass="form-control"/>
                                    </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight:bold">Tên</label>
                                            <form:input path="fullName" cssClass="form-control"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight:bold">Số điện thoại</label>
                                            <form:input path="phone" cssClass="form-control"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <label style="font-weight:bold">Email</label>
                                            <form:input path="email" cssClass="form-control"/>
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
                                <a href='<c:url value='/admin/user-new'/>'>
                                    <button data-toggle="tooltip" title="Thêm người dùng" class="btn btn-white btn-info btn-bold">
                                        <i class="fa fa-plus-circle" aria-hidden="true"></i>
                                    </button>
                                </a>
                                <button id="btnDeleteUser" data-toggle="tooltip" title="Xóa người dùng"
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
                    <table id="userList" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Ngày cập nhật</th>
                            <th>Tên</th>
                            <th>Username</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Trạng thái</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${users}">
                            <tr role="row" class="odd">
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="id" value="${item.id}" id="checkbox_${item.id}"/>
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td><fmt:formatDate value="${item.modifiedDate}" pattern="dd/MM/yyyy"/></td>
                                <td>${item.fullName}</td>
                                <td>${item.userName}</td>
                                <td>${item.phone}</td>
                                <td>${item.email}</td>
                                <td>${item.statusConverted}</td>
                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <a type="button" class="btn btn-sm btn-primary" title="Chỉnh sửa"
                                           href="/admin/user-edit-${item.id}">
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

    $('#btnDeleteUser').click(function (e) {
        e.preventDefault();
        //var data = {};
        var userIds = $('#userList').find('tbody input[type=checkbox]:checked').map(function() {
            return $(this).val();
        }).get();

        deleteUser(userIds);
    });

    function deleteUser(data) {
        $.ajax({
            type: "DELETE",
            url: '/api/user',
            data: JSON.stringify(data),
            //dataType: "json",
            contentType: "application/json",
            success: function (response) {
                window.location.href = "<c:url value='/admin/user-list'/>";
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