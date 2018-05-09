<html>
<head>
<meta http-equiv="charset" content="utf-8">
<title>GreedyCat在线点餐系统</title>
<meta charset="utf-8">
<meta content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
<meta content="telephone=no,email=no,adress=no" name="format-detection">
<script src="../../assets/vendor/jquery/jquery-1.11.0.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../../assets/css/common.css" type="text/css" />
</head>
<body>
	<div id="content">
		<div id="orderTable">
		</div>
		<table border="0">
			<thead>
				<tr>
					<td width="60">序号</td>
					<td width="120">订单号</td>
					<td width="100">桌号</td>
					<td width="80">状态</td>
					<td width="200">菜品  数量</td>
					<td width="80">总价</td>
					<td width="120">操作</td>
				</tr>
			</thead>
			<tbody id="orderTBody">
			</tbody>
		</table>
	</div>
<script>
	$(window).on('ready',function() {
		$.ajax({
			type : "POST",
			url : "../order/list",
			dataType : "json",
			data : JSON.stringify({}),
			contentType : "application/json; charset=utf-8",
			success : function(msg) {
				var _html = "";
				var height = 30;
				for(var i = 0; i < msg.length; i++){
					if(msg[i].itemDtos.length != 0) {
						height *= msg[i].itemDtos.length;
					}
					_html += "<tr><td width=\"60\" height=\"" + height +"\">" + (i+1) + "</td>" +
							 "<td width=\"120\" height=\"" + height +"\">" + msg[i].orderId + "</td>" +
							 "<td width=\"100\" height=\"" + height +"\">" + msg[i].tableNumber + "</td>";
					if(msg[i].status == 0){
						_html += "<td width=\"80\" height=\"" + height +"\">待接单</td>";
					} else if(msg[i].status == 1){
						_html += "<td width=\"80\" height=\"" + height +"\">待支付</td>";
					} else if(msg[i].status == 2){
						_html += "<td width=\"80\" height=\"" + height +"\">已支付</td>";
					}
					_html += "<td width=\"200\" height=\"" + height +"\" style=\"padding:0;\">";
					for(var j = 0; j < msg[i].itemDtos.length; j++){
						_html += "<div class=\"order-item\">" + msg[i].itemDtos[j].foodName + "\t x " + msg[i].itemDtos[j].quantity + "</div>";
					}
					
					_html += "</td><td width=\"80\" height=\"" + height +"\">￥" + msg[i].totalPrice/100 
							+ "</td><td width=\"120\" height=\"" + height +"\">";
					 	   
					if(msg[i].status == 0){
						_html += "<button>接单</button><button>修改</button>";
					} else if(msg[i].status == 1){
						_html += "<button>支付</button><button>修改</button>";
					}else if(msg[i].status == 2){
						_html += "<button>删除</button>";
					}
					
					_html += "</td></tr>";
					height = 30;
				}
				$('#orderTBody').html(_html);
			},
			error : function(){
				alert(msg);
			}
		});
	})
</script>
</body>
</html>