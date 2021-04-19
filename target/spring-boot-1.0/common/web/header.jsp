<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.laptrinhjavaweb.security.utils.SecurityUtils" %>
<!-- start header section -->
<header>

	<div class="navbar-default border-bottom border-color-light-white">
		<div class="container lg-container">
			<div class="row align-items-center">
				<div class="col-12 col-lg-12">
					<div class="menu_area alt-font">
						<nav class="navbar navbar-expand-lg navbar-light no-padding">

							<div class="navbar-header navbar-header-custom">
								<!-- Start Logo -->
								<a href="/trang-chu" class="navbar-brand"><img id="logo" src="/web/image/logo/logo-web.png" alt="logo"></a>
								<!-- End Logo -->
							</div>

							<div class="navbar-toggler"></div>
							<!-- start Menu Area -->
							<security:authorize access="isAuthenticated()">
								<!-- start Menu Area -->
								<ul class="navbar-nav ml-auto" id="nav" style="display: none;">
									<li><a href="/trang-chu">Trang chủ</a>
									</li>
									<li><a href="/customer-product-list">Danh sách phòng đăng của bạn</a></li>
<%--									<li><a href="#">Blog</a>--%>
<%--										<ul>--%>
<%--											<li><a href="blog-grid.html">Title 1</a></li>--%>
<%--											<li><a href="blog-default.html">Title 2</a></li>--%>
<%--											<li><a href="blog-post.html">Title 3</a></li>--%>
<%--										</ul>--%>
<%--									</li>--%>
								</ul>

								<div class="attr-nav sm-no-margin sm-margin-70px-right xs-margin-65px-right">
									<a href="/customer-product-new" class="butn small" style="margin-left: 30px;">
										<span>Đăng tin phòng</span>
										<i class="ti-pencil-alt"></i>
									</a>
								</div>

								<div class="btn-group dropright">
									<button type="button" class="butn small" data-toggle="dropdown" style="margin-left: 30px">
										<span>Cá nhân</span>
										<i class="ti-user"></i>
									</button>
									<div class="dropdown-menu">
										<a href="/customer-profile" class="dropdown-item">Thông tin</a>
										<a href="/logout" class="dropdown-item">Thoát</a>
									</div>
								</div>

							</security:authorize>
							<security:authorize access="isAnonymous()">
								<!-- start Menu Area -->
								<ul class="navbar-nav ml-auto" id="nav" style="display: none;">
									<li><a href="/trang-chu">Trang chủ</a>
									</li>
<%--									<li><a href="#">Tìm kiếm phòng</a>--%>
<%--										<ul>--%>
<%--											<li><a href="/product-list">Danh sách phòng</a></li>--%>
<%--										</ul>--%>
<%--									</li>--%>
<%--									<li><a href="#">Blog</a>--%>
<%--										<ul>--%>
<%--											<li><a href="blog-grid.html">Blog Grid</a></li>--%>
<%--											<li><a href="blog-default.html">Blog Default</a></li>--%>
<%--											<li><a href="blog-post.html">Blog Post</a></li>--%>
<%--										</ul>--%>
<%--									</li>--%>
								</ul>

								<div class="attr-nav sm-no-margin sm-margin-70px-right xs-margin-65px-right">
									<a href="/login" class="butn small" style="margin-left: 1.5cm;">
										<span>Đăng nhập</span>
									</a>
								</div>

								<div class="attr-nav sm-no-margin sm-margin-70px-right xs-margin-65px-right">
									<a href="/signup" class="butn small" style="margin-left: 7px;">
										<span>Đăng ký</span>
									</a>
								</div>
							</security:authorize>


							<!-- End Menu Area -->
							<!-- End Atribute Navigation -->
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>

</header>
<!-- end header section -->