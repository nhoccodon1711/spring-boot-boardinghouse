<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- start project details section -->
<section>
    <div class="container">
        <form:form cssClass="project-detail-block" modelAttribute="product">
            <div class="row margin-40px-bottom md-margin-25px-bottom">
                <div>
                    <c:if test="${not empty product.thumbnail}">
                        <c:set var="image" value="/repository${product.thumbnail}"/>
                        <img src="${image}" id="viewImage" width="500px" height="500px">
                    </c:if>
                    <c:if test="${empty product.thumbnail}">
                        <img src="/admin/image/default.png" id="viewImage" width="300px" height="300px">
                    </c:if>

                </div>
                <div class="col-lg-6">
                    <div class="padding-20px-left md-no-padding-left">
                        <h5>${product.name}</h5>
                        <ul class="project-list no-margin-bottom">
                            <li>
                                <i class="ti-time"></i>
                                <h6
                                        class="no-margin-bottom font-size16 xs-font-size15 line-height-22 font-weight-500">
                                    Ngày cập nhật</h6>
                                <p class="no-margin-bottom"><fmt:formatDate value="${product.modifiedDate}" pattern="dd/MM/yyyy"/></p>
                            </li>
                            <li>
                                <i class="ti-money"></i>
                                <h6
                                        class="no-margin-bottom font-size16 xs-font-size15 line-height-22 font-weight-500">
                                    Giá cho thuê</h6>
                                <p class="no-margin-bottom">${product.price}</p>
                            </li>
                            <li>
                                <i class="ti-arrow-down"></i>
                                <h6
                                        class="no-margin-bottom font-size16 xs-font-size15 line-height-22 font-weight-500">
                                    Diện tích</h6>
                                <p class="no-margin-bottom">${product.area}</p>
                            </li>
                            <li>
                                <i class="ti-location-pin"></i>
                                <h6
                                        class="no-margin-bottom font-size16 xs-font-size15 line-height-22 font-weight-500">
                                    Địa chỉ</h6>
                                <p class="no-margin-bottom">${product.address}</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <h4>Thông tin mô tả</h4>
            <p>${product.content}</p>
        </form:form>
    </div>
</section>
<!-- end project details section -->
<!-- end project details section -->
<script>

</script>
</body>
</html>
