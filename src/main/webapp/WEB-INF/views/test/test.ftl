<!DOCTYPE html>
<head>
<title>Login One</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="UTF-8">
<meta name="viewport" content="width=50%, initial-scale=1.0">

<link href="../../assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="../../assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="../../assets/vendor/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css">
<link href="../../assets/vendor/templatemo_style/css/templatemo_style.css"
	rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
	<div class="container" style="width: 100%;">
		<div class="col-md-12"
			style="width: 30%; margin: 0 auto; float: inherit;">
			<h1 class="margin-bottom-15">欢迎使用OldMewo管理系统</h1>
			<form
				class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30"
				role="form" action="checkUser" method="post">
				<div class="form-group">
					<div class="col-xs-12">
						<div class="control-wrapper">
							<label for="username" class="control-label fa-label"><i
								class="fa fa-user fa-medium"></i></label> <input type="text"
								class="form-control" id="username" placeholder="Username">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<label for="password" class="control-label fa-label"><i
								class="fa fa-lock fa-medium"></i></label> <input type="password"
								class="form-control" id="password" placeholder="Password">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="checkbox control-wrapper">
							<label> <input type="checkbox"> 记住密码
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<input type="submit" value="点此登录" class="btn btn-info" >
							<a href="forgot-password.html" class="text-right pull-right">忘记密码？</a>
						</div>
					</div>
				</div>
				<hr>
			</form>
		</div>
	</div>
</body>
</html>