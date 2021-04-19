<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link href="https://fonts.googleapis.com/css?family=Medula+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="home/css/bootstrap.min.css" />

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="home/css/style.css" />
</head>
<body>
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
                    <div class="form-header">
                        <h2>Tìm phòng trọ</h2>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cupiditate laboriosam numquam at</p>
                    </div>
                    <form>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <span class="form-label">Arrival date</span>
                                    <input class="form-control" type="date" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <span class="form-label">Departure date</span>
                                    <input class="form-control" type="date" required>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <span class="form-label">Rooms</span>
                                    <select class="form-control">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <span class="form-label">Adults</span>
                                    <select class="form-control">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <span class="form-label">Kids</span>
                                    <select class="form-control">
                                        <option>0</option>
                                        <option>1</option>
                                        <option>2</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-btn">
                            <button class="submit-btn">Check availability</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<header>

    <div id="top-bar" class="top-bar">
        <div class="container lg-container">
            <div class="row">
                <div class="col-md-3 xs-display-none">
                    <ul class="top-social-icon">
                        <li><a href="javascript:void(0)"><i class="fab fa-facebook-f"></i></a></li>
                        <li><a href="javascript:void(0)"><i class="fab fa-twitter"></i></a></li>
                        <li><a href="javascript:void(0)"><i class="fab fa-pinterest-p"></i></a></li>
                        <li><a href="javascript:void(0)"><i class="fab fa-linkedin-in"></i></a></li>
                        <li><a href="javascript:void(0)"><i class="fab fa-dribbble"></i></a></li>
                    </ul>
                </div>
                <div class="col-xs-12 col-md-9">
                    <div class="top-bar-info">
                        <ul>
                            <li><i class="fas fa-phone"></i>(+123) 456 7890</li>
                            <li><i class="fas fa-envelope"></i>addyour@emailhere</li>
                            <li class="sm-display-none"><i class="far fa-clock"></i>Mon-Fri: 7:00 - 17:00</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="navbar-default border-bottom border-color-light-white">

        <!-- start top search -->
        <div class="top-search bg-theme border-top">
            <div class="container lg-container">
                <form class="search-form" action="search.html" method="GET" accept-charset="utf-8">
                    <div class="input-group">
                                <span class="input-group-addon cursor-pointer">
                                    <button class="search-form_submit fas fa-search font-size18 text-white"
                                            type="submit"></button>
                                </span>
                        <input type="text" class="search-form_input form-control" name="s" autocomplete="off"
                               placeholder="Type & hit enter...">
                        <span class="input-group-addon close-search"><i
                                class="fas fa-times font-size18 line-height-28 margin-5px-top"></i></span>
                    </div>
                </form>
            </div>
        </div>
        <!-- end top search -->

        <div class="container lg-container">
            <div class="row align-items-center">
                <div class="col-12 col-lg-12">
                    <div class="menu_area alt-font">
                        <nav class="navbar navbar-expand-lg navbar-light no-padding">

                            <div class="navbar-header navbar-header-custom">
                                <!-- Start Logo -->
                                <a href="index.html" class="navbar-brand"><img id="logo"
                                                                               src="img/logos/logo.png" alt="logo"></a>
                                <!-- End Logo -->
                            </div>

                            <div class="navbar-toggler"></div>

                            <!-- start Menu Area -->
                            <ul class="navbar-nav ml-auto" id="nav" style="display: none;">
                                <li><a href="home.html">Trang chủ</a></li>
                                <li><a href="#">Tìm phòng</a>
                                    <ul>
                                        <li><a href="room-list.html">Danh sách phòng</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Blog</a>
                                    <ul>
                                        <li><a href="blog-grid.html">Blog Grid</a></li>
                                        <li><a href="blog-default.html">Blog Default</a></li>
                                        <li><a href="blog-post.html">Blog Post</a></li>
                                    </ul>
                                </li>
                                <li><a href="contact-us.html">Contact Us</a></li>
                            </ul>
                            <!-- End Menu Area -->

                            <!-- Start Atribute Navigation -->
                            <div class="attr-nav sm-no-margin sm-margin-70px-right xs-margin-65px-right">
                                <ul>
                                    <li class="search"><a href="javascript:void(0)"><i
                                            class="fas fa-search"></i></a></li>
                                </ul>
                            </div>

                            <div class="attr-nav sm-no-margin sm-margin-70px-right xs-margin-65px-right">
                                <a href="/login" class="butn small"
                                    style="margin-left: 1.5cm;">
                                    <span>Đăng nhập</span>
                                </a>
                            </div>

                            <div class="attr-nav sm-no-margin sm-margin-70px-right xs-margin-65px-right">
                                <a href="/signup" class="butn small"
                                    style="margin-left: 7px;">
                                    <span>Đăng ký</span>
                                </a>
                            </div>

                            <div class="attr-nav sm-no-margin sm-margin-70px-right xs-margin-65px-right">
                                <a href="blog-post.html" class="butn small" style="margin-left: 22px;">
                                    <span>Đăng tin phòng</span>
                                </a>
                            </div>
                    <!-- End Atribute Navigation -->

                    </nav>
                </div>

            </div>
        </div>
    </div>
    </div>

</header>
</body>

</html>