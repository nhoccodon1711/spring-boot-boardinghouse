<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="productListURL" value="/trang-chu"/>
<html>
<head>
    <title>Danh sách phòng</title>
</head>
<body>
<!-- start page title section -->
<section class="page-title-section bg-img cover-background" data-overlay-dark="75"
         data-background="img/banner/page-title.jpg">
    <div class="container">
        <form:form cssClass="row" modelAttribute="model" action="${productListURL}" id="listForm" method="GET">
            <div class="col-lg-3">
                <div class="form-group">
                    <label for="productCategory">Loại phòng</label>
                    <form:select cssClass="form-control" path="productCategory">
                        <form:option value="" label="Chọn loại phòng"/>
                        <form:options items="${mapCategories}"/>
                    </form:select>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="form-group">
                    <label for="price">Khoảng giá</label>
                    <form:select cssClass="form-control" path="price">
                        <form:option value="" label="Chọn khoảng giá"/>
                        <form:options items="${mapPrices}"/>
                    </form:select>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="form-group">
                    <label for="area">Diện tích</label>
                    <form:select cssClass="form-control" path="area">
                        <form:option value="" label="Chọn diện tích"/>
                        <form:options items="${mapAres}"/>
                    </form:select>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="form-group">
                    <label for="district">Quận</label>
                    <form:select cssClass="form-control" path="district">
                        <form:option value="" label="Chọn quận"/>
                        <form:options items="${mapDistricts}"/>
                    </form:select>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="fa-pull-left" style="padding-top: 20px;">
                    <a href="javascript:void(0)" class="butn" id="btnSearch">Tìm kiếm</a>
                </div>
            </div>
        </form:form>
    </div>
</section>
<!-- end page title section -->

<!-- start service section -->
<section>
    <div class="container">
        <div class="row">
            <c:forEach var="item" items="${products}">
                <div class="col-lg-4 col-md-6 margin-30px-bottom xs-margin-25px-bottom">
                    <div class="service-block02">
                        <div>
                            <c:if test="${not empty item.thumbnail}">
                                <c:set var="image" value="/repository${item.thumbnail}"/>
                                <img src="${image}" id="viewImage" width="300px" height="300px">
                            </c:if>
                            <c:if test="${empty item.thumbnail}">
                                <img src="/admin/image/default.png" id="viewImage" width="300px" height="300px">
                            </c:if>
                        </div>
                        <div class="padding-25px-all md-padding-20px-all">
                            <h5 class="font-weight-500 font-size22 md-font-size18 md-margin-10px-bottom xs-margin-10px-bottom">
                                <a href="#" class="text-black">${item.name}</a>
                            </h5>
                            <p class="text">Overview</p>
                            <a href="/product-detail-${item.id}"
                               class="text-black font-weight-600 font-size14 md-font-size13">Xem chi tiết
                                <span class="ti-arrow-right vertical-align-middle font-size12 margin-10px-left float-right font-weight-600"></span>
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- end service section -->

<script>
    $('#btnSearch').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();
    });
</script>

</body>
</html>
