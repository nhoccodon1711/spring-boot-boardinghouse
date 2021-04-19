<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.laptrinhjavaweb.security.utils.SecurityUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="navbar" class="navbar navbar-default          ace-save-state">
	<div class="navbar-container ace-save-state" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href='<c:url value='/admin/home'/>' class="navbar-brand">
				<small>
					<i class="fa fa-home"></i>
					Trang chủ
				</small>
			</a>

			<nav role="navigation" class="navbar-menu pull-left collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="fa fa-building"></i>
							Quản lý phòng đăng						&nbsp;
							<i class="fa fa-angle-down bigger-110"></i>
						</a>

						<ul class="dropdown-menu dropdown-light-blue dropdown-caret">
							<li>
								<a href='<c:url value='/admin/home'/>'>
									Danh sách phòng đăng
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="fa fa-user"></i>
							Quản lý người dùng
							&nbsp;
							<i class="fa fa-angle-down bigger-110"></i>
						</a>
						<ul class="dropdown-menu dropdown-light-blue dropdown-caret">
							<li>
								<a href='<c:url value='/admin/user-list'/>'>
									Danh sách người dùng
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="fa fa-list-ul"></i>
							Quản lý loại phòng
							&nbsp;
							<i class="fa fa-angle-down bigger-110"></i>
						</a>
						<ul class="dropdown-menu dropdown-light-blue dropdown-caret">
							<li>
								<a href='<c:url value='/admin/category-list'/>'>
									Danh sách loại phòng
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>

		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						Xin chào, <%=SecurityUtils.getPrincipal().getFullName()%>
						<i class="ace-icon fa fa-caret-down"></i>
					</a>

					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li>
							<a href="/admin/profile">
								<i class="ace-icon fa fa-user"></i>
								Thông tin tài khoản
							</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="<c:url value='/logout'/>">
								<i class="ace-icon fa fa-power-off"></i>
								Thoát
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>