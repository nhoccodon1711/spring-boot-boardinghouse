<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="createUser" value="/api/user"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng ký</title>
</head>
<body>
<section>
	<div class="container">
		<div class="padding-40px-all sm-padding-30px-all xs-padding-20px-all bg-light-gray margin-80px-top sm-margin-40px-top xs-margin-30px-top">
			<h4 class="font-size38 sm-font-size34 xs-font-size28 line-height-45 sm-line-height-40 font-weight-500 margin-10px-bottom text-center">
				Đăng ký</h4>
			<form:form modelAttribute="user" action="${createUser}" method="POST" id="formAdd">
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label>Username</label>
							<form:input path="userName" cssClass="no-margin-bottom"/>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label>Password</label>
							<form:input path="password" cssClass="no-margin-bottom"/>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="form-group">
							<label>Fullname</label>
							<form:input path="fullName" cssClass="no-margin-bottom"/>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label>Phone</label>
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
							<a href="javascript:void(0)" class="butn" id="btnAddUser">Đăng ký</a>
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

	$('#btnAddUser').click(function (e) {
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