<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="editUser" value="/api/user"/>
<html>
<head>
	<title>Thông tin người dùng</title>
</head>
<body>
<body>
<section>
	<div class="container">
		<div class="padding-40px-all sm-padding-30px-all xs-padding-20px-all bg-light-gray margin-80px-top sm-margin-40px-top xs-margin-30px-top">
			<h4 class="font-size38 sm-font-size34 xs-font-size28 line-height-45 sm-line-height-40 font-weight-500 margin-10px-bottom text-center">
				Thông tin người dùng</h4>
			<form:form modelAttribute="user" action="${editUser}" method="PUT" id="formEdit">
				<div class="row">
					<form:hidden path="id"/>
					<div class="col-lg-6">
						<div class="form-group">
							<label>Username</label>
							<form:input path="userName" cssClass="no-margin-bottom"/>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label>Password</label>
							<input type="text" name="password" for="password" value=""/>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="form-group">
							<label>Họ và tên</label>
							<form:input path="fullName" cssClass="no-margin-bottom"/>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label>Số điện thoại</label>
							<form:input path="phone" cssClass="no-margin-bottom"/>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label>Email</label>
							<form:input path="email" cssClass="no-margin-bottom"/>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="Send">
							<a href="javascript:void(0)" class="butn" id="btnEditUser">Lưu thay đổi</a>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</section>

<script>
	$(document).ready(() => {
		console.log("Ready");
	});

	$('#btnEditUser').click(function (e) {
		e.preventDefault();
		var data = {};
		var formData = $('#formEdit').serializeArray();
		$.each(formData, function (index, v) {
			if (v.value != '' && v.value != null) {
				data['' + v.name + ''] = v.value;
			}
		});
		$.ajax({
			type: 'PUT',
			url: '/api/user',
			data: JSON.stringify(data),
			dataType: "json", // data from Server to Client
			contentType: "application/json", // data from Client to Server
			success: function (response) {
				window.location.href = "http://localhost:8080/admin/home";
			},
			error: function (response) {
				console.log('failed');
				console.log(response);
			}
		});
	});
</script>
</body>
</html>