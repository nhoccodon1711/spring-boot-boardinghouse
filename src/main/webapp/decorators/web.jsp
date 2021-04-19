<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

	<!-- plugins -->
	<link rel="stylesheet" href="web/css/plugins.css" />

	<!-- revolution slider css -->
	<link rel="stylesheet" href="web/css/rev_slider/settings.css' />">
	<link rel="stylesheet" href="web/css/rev_slider/layers.css">
	<link rel="stylesheet" href="web/css/rev_slider/navigation.css">

	<!-- core style css -->
	<link href="web/css/styles.css" rel="stylesheet" />

	<%--jquery 2.1.4--%>
	<script type='text/javascript' src='web/js/jquery-2.1.4/jquery.min.js'></script>
</head>
<body>

	<div id="preloader">
		<div class="row loader">
			<div class="loader-icon"></div>
		</div>
	</div>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>

	<div class="main-wrapper">
		<dec:body/>
		<!-- Footer -->
		<%@ include file="/common/web/footer.jsp" %>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="web/vendor/jquery/jquery.min.js"></script>
	<script src="web/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- start scroll to top -->
	<a href="javascript:void(0)" class="scroll-to-top"><i class="fas fa-angle-up" aria-hidden="true"></i></a>
	<!-- end scroll to top -->

	<!-- all js include start -->

	<!-- modernizr js -->
	<script src="web/js/modernizr.js"></script>

	<!-- bootstrap -->
	<script src="web/js/bootstrap.min.js"></script>

	<!-- navigation -->
	<script src="web/js/nav-menu.js"></script>

	<!-- tab -->
	<script src="web/js/easy.responsive.tabs.js"></script>

	<!-- owl carousel -->
	<script src="web/js/owl.carousel.js"></script>

	<!-- jquery.counterup.min -->
	<script src="web/js/jquery.counterup.min.js"></script>

	<!-- stellar js -->
	<script src="web/js/jquery.stellar.min.js"></script>

	<!-- waypoints js -->
	<script src="web/js/waypoints.min.js"></script>

	<!-- countdown js -->
	<script src="web/js/countdown.js"></script>

	<!-- jquery.magnific-popup js -->
	<script src="web/js/jquery.magnific-popup.min.js"></script>

	<!-- isotope.pkgd.min js -->
	<script src="web/js/isotope.pkgd.min.js"></script>

	<!-- custom scripts -->
	<script src="web/js/main.js"></script>

	<!-- all js include end -->

	<script src="web/paging/jquery.twbsPagination.js"></script>
</body>
</html>