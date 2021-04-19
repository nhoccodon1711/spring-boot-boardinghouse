<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Danh sách phòng đăng</title>
</head>
<body>

<!-- start service section -->
<section>
    <div class="container">
        <div class="row" id="rowEdit">
            <c:forEach var="item" items="${products}">
                <div class="col-lg-4 col-md-6 margin-30px-bottom xs-margin-25px-bottom">
                    <div class="service-block02" id="productList">
                        <div>
                            <c:if test="${not empty item.thumbnail}">
                                <c:set var="image" value="/repository${item.thumbnail}"/>
                                <img src="${image}" id="viewImage" width="300px" height="300px">
                            </c:if>
                            <c:if test="${empty item.thumbnail}">
                                <img src="web/image/default.png" id="viewImage" width="300px" height="300px">
                            </c:if>
                        </div>
                        <div class="padding-25px-all md-padding-20px-all">
                            <h5 class="font-weight-500 font-size22 md-font-size18 md-margin-10px-bottom xs-margin-10px-bottom" data-toggle="tooltip" title="Xem chi tiết">
                                <a href="/customer-product-${item.id}" class="text-black">${item.name}</a>
                            </h5>
                            <p class="text">Overview</p>
                            <label class="vertical-align-middle font-size12 margin-10px-left float-left font-weight-600">
                                <input type="checkbox" name="id" value="${item.id}" id="checkbox_${item.id}"/>
                            </label>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="col-lg-4 col-md-6">
                <a type="button" class="butn small" href="#" id="btnDeleteProduct">Xóa
                    <i class="ti-trash"></i>
                </a>
            </div>
        </div>
    </div>
</section>
<!-- end service section -->

<script>

    $('#btnDeleteProduct').click(function (e) {
        e.preventDefault();

        var productIds = $('#rowEdit').find('input[type=checkbox]:checked').map(function() {
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
                window.location.href = "<c:url value='/customer-product-list'/>";
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
