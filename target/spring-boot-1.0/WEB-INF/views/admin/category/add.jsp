<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="createCategory" value="/api/category"/>

<html>
<head>
    <title>Thêm mới loại phòng</title>
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
                    <a href="building-list.html">Trang chủ</a>
                </li>
                <li class="active">Quản lý loại phòng</li>
                <li class="active">Thêm mới loại phòng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form cssClass="form-horizontal" modelAttribute="category" action="${createCategory}" id="formAdd" method="POST">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name">Tên loại phòng</label>

                            <div class="col-sm-5">
                                <form:input path="name" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name">Code</label>

                            <div class="col-sm-5">
                                <form:input path="code" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="btn-group pull-right">
                            <button class="btn btn-primary btn-bold" id="btnAddCategory">
                                Thêm loại phòng
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
    $(document).ready(() => {
        console.log("Ready");
    });

    $('#btnAddCategory').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formAdd').serializeArray();
        $.each(formData, function (index, v) {
            if (v.value != '' && v.value != null) {
                data['' + v.name + ''] = v.value;
            }
        });
        $.ajax({
            type: 'POST',
            url: '/api/category',
            data: JSON.stringify(data),
            dataType: "json", // data from Server to Client
            contentType: "application/json", // data from Client to Server
            success: function (response) {
                //showAlertAfterAdd();
                window.location.href = "<c:url value='/admin/category-list'/>";
            },
            error: function (response) {
                console.log('failed');
                console.log(response);
            }
        });
    });
</script>
<script type='text/javascript' src="/admin/index.js"></script>
</body>
</html>
