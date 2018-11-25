<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Core CSS - Include with every page -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

<!-- Page-Level Plugin CSS - Forms -->

<!-- SB Admin CSS - Include with every page -->
<link href="css/sb-admin.css" rel="stylesheet">

<title>Menu</title>
</head>
<body>

	<div id="wrapper">
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
			<!--Nav Header-->
			<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="restaurants">FoodAdda</a>
			</div>

			<!-- Right Navigation Buttons-->
			<ul class="nav navbar-top-links navbar-right">
			<c:if test="${not empty customerName}">
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
					</a>
					<ul class="dropdown-menu dropdown-user">
						
							<li><a href="#"><i class="fa fa-user fa-fw"></i> Hi ${customerName}</a>
							</li>
							<li class="divider"></li>
							<li><a href="chatbot"><i class="fa fa-sign-out fa-fw"></i> Chat Bot</a>
							<li class="divider"></li>
							<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
							</li>
						
					</ul>
				</li>
				</c:if>
				
				<c:if test="${empty customerName}">
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
					</a>
					<ul class="dropdown-menu dropdown-user">
						
							<li><a href="#"><i class="fa fa-user fa-fw"></i> Login to access Cart </a>
							</li>
							<li class="divider"></li>
							<li><a href="login"><i class="fa fa-sign-out fa-fw"></i> Login</a>
							</li>
						
					</ul>
				</li>
				</c:if>
				
			</ul>
		</nav>
	</div>
	<br><br>

	<div class="col-lg-6">
			<div class="panel-body">
					<form role="form" action="feedback" method="POST">
						<fieldset>
							<div class="form-group" >
								<input class="form-control" placeholder="Restaurant Id" name="id" value="${id}">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Comment" name="comment" type="text" required>
							</div>
							<!-- Change this to a button or input when using this as a form -->
							<input type="submit" class="btn btn-primary" value="Submit">
						   
						</fieldset>
					</form>
				</div>
		</div>

		<!-- Core Scripts - Include with every page -->
		<script src="js/jquery-1.10.2.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	
		<!-- Page-Level Plugin Scripts - Forms -->
	
		<!-- SB Admin Scripts - Include with every page -->
		<script src="js/sb-admin.js"></script>

</body>
</html>