<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="/mapper/resources/css/style.css" />
		<link href="/mapper/resources/css/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<title>Web App</title>
		<script type="text/javascript" src="/mapper/resources/js/jQuery.js"></script> 
		<script type="text/javascript" src="/mapper/resources/js/script.js"></script>
		<script type="text/javascript" src="/mapper/resources/js/link.js"></script>
		<script type="text/javascript" src="/mapper/resources/js/model.js"></script>
		<script type="text/javascript" src="/mapper/resources/js/dialog.js"></script>
		<script src="/mapper/resources/js/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/mapper/resources/js/noty/jquery.noty.js"></script>
		<script type="text/javascript" src="/mapper/resources/js/noty/layouts/center.js"></script>
		<script type="text/javascript" src="/mapper/resources/js/noty/themes/default.js"></script>
	</head>
	<body>
		<!--<div id="home">
			<div id="header">
				<button class="button" id="addBtn">add link</button>
			</div>
			<div class="space"></div>
			<div id="menu"></div>
			<div id="content"></div>
		</div>-->	
		<div class="container-fluid" id="home">
			<div class="row-fluid">
			    <div class="span12">
			      <!--Header content-->
			      	<button class="btn" id="addBtn">Add</button>
			      	<a href="/mapper/j_spring_security_logout">Logout</a>
			      	<form class="navbar-search pull-right">
					  <input type="text" class="search-query" placeholder="Search">
					</form>
			    </div>
		  	</div>
		  	<div class="row-fluid">
			    <div class="span2">
			      <!--Sidebar content-->
			    </div>
			    <div class="span10" id="link-display">
			      <!--Body content-->

			    </div>
		  </div>
		</div>
	</body>	
</html>
