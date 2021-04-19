<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="editProduct" value="/api/product"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng tin phòng</title>
</head>
<body>
<section>
	<div class="container">
		<div class="padding-40px-all sm-padding-30px-all xs-padding-20px-all bg-light-gray margin-80px-top sm-margin-40px-top xs-margin-30px-top">
			<h4 class="font-size38 sm-font-size34 xs-font-size28 line-height-45 sm-line-height-40 font-weight-500 margin-10px-bottom text-center">
				Chỉnh sửa</h4>
			<form:form modelAttribute="product" action="${editProduct}" method="POST" id="formEdit">
				<div class="row">
					<form:hidden path="id"/>
					<div class="col-lg-8">
						<div class="form-group">
							<label>Tên phòng</label>
							<form:input path="name" cssClass="no-margin-bottom"/>
						</div>
					</div>

					<div class="col-lg-4">
						<div class="form-group">
							<label for="area">Loại phòng</label>
							<form:select cssClass="no-margin-bottom" path="productCategory" cssStyle="height: 46px">
								<form:option value="" label="Chọn loại phòng"/>
								<form:options items="${mapCategories}"/>
							</form:select>
						</div>
					</div>

					<div class="col-lg-4">
						<div class="form-group">
							<label>Đường</label>
							<form:input path="street" cssClass="no-margin-bottom"/>
						</div>
					</div>

					<div class="col-lg-4">
						<div class="form-group">
							<label>Phường</label>
							<form:input path="ward" cssClass="no-margin-bottom"/>
						</div>
					</div>

					<div class="col-lg-4">
						<div class="form-group">
							<label for="area">Quận</label>
							<form:select cssClass="no-margin-bottom" path="district" cssStyle="height: 46px">
								<form:option value="" label="Chọn quận"/>
								<form:options items="${mapDistricts}"/>
							</form:select>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="form-group">
							<label>Diện tích</label>
							<form:input path="area" cssClass="no-margin-bottom"/>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="form-group">
							<label>Mô tả diện tích</label>
							<form:input path="areaDescription" cssClass="no-margin-bottom"/>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="form-group">
							<label>Giá thuê</label>
							<form:input path="price" cssClass="no-margin-bottom"/>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="form-group">
							<label>Mô tả giá</label>
							<form:input path="priceDescription" cssClass="no-margin-bottom"/>
						</div>
					</div>

					<div class="col-lg-12">
						<div class="form-group">
							<label>Mô tả</label>
							<form:input path="content" cssClass="no-margin-bottom"/>
						</div>
					</div>

					<div class="col-lg-12">
						<div class="form-group">
							<label for="thumbnail">Thumbnail phòng</label>
							<input type="file" id="uploadImage"/>

							<div>
								<c:if test="${not empty product.thumbnail}">
									<c:set var="image" value="/repository${product.thumbnail}"/>
									<img src="${image}" id="viewImage" width="300px" height="300px">
								</c:if>
							</div>
						</div>
					</div>

					<div class="col-lg-12">
						<div class="Send">
							<a href="javascript:void(0)" class="butn" id="btnEditProduct">Lưu thay đổi</a>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</section>

<script>
	var thumbnailBase64 = '';
	var thumbnailImageName = '';

	$(document).ready(() => {
		console.log("Ready");
	});

	$('#btnEditProduct').click(function (e) {
		e.preventDefault();
		var data = {};
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
				window.location.href = "<c:url value='/customer-product-list'/>";
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
</body>
</html>