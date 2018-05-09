<html>
<head>
<title>GreedyCat在线点餐系统 - 登录</title>
<meta charset="utf-8">
<meta content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
<meta content="telephone=no,email=no,adress=no" name="format-detection">
<script src="../../assets/vendor/jquery/jquery-1.11.0.js" type="text/javascript"></script>
</head>
<body>
	<div id="content">
		<td>账号:</td>
		<input type="text" name="loginId">
		<br>
		<td>密码:</td>
		<input type="password" name="password">
		<br>
		<button type="submit" id="loginBtn">登录</button>
	</div>
	<script>
		$('#loginBtn').on('click', function() {
			$.ajax({
				type : "POST",
				url : "../auth/login/authc",
				dataType : "json",
				data : JSON.stringify({
					loginId : $('input[name=loginId]').val(),
					password : $('input[name=password]').val()
				}),
				contentType : "application/json; charset=utf-8",
				success : function(msg) {
					if (msg.code == "success") {
						window.location.href = "../order/index";
					} else {
						alert(msg.message);
					}
				},
				error : function() {
					alert(msg.message);
				}
			});
		})
	</script>
</body>
</html>