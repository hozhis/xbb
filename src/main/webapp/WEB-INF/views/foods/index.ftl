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
		<div class="row search-area">
			<input id="searchButton" type="text">
			<button class="searchBtn primary">查询</button>
			<button class="addBtn primary">添加</button>
		</div>
		<table border="0">
			<thead>
				<tr>
					<td width="60">序号</td>
					<td width="180">菜品名称</td>
					<td width="240">描述</td>
					<td width="80">价格</td>
					<td width="100">分类</td>
					<td width="120">操作</td>
				</tr>
			</thead>
			<tbody id="orderTBody">
			</tbody>
		</table>
	
		<!-- 添加弹出框 -->
		<div id="addBox" class="pop-up hidden">
			<div class="pop-shade"></div>
			<div class="pop-box">
				<div class="pop-header">添加菜品</div>
				<div class="pop-content">
					<div class="row">
						<span>菜品名称</span>
						<input type="text" id="foodName">
					</div>
					<div class="row">
						<span>描述</span>
						<input type="text" id="description">
					</div>
					<div class="row">
						<span>价格</span>
						<input type="text" id="price">
					</div>
					<div class="row">
						<span>分类</span>
						<select id="type">
							<option>凉菜</option>
							<option>江浙菜</option>
							<option>川菜</option>
							<option>鲁菜</option>
							<option>主食</option>
							<option>酒水饮料</option>
						</select>
					</div>
				</div>
				<div class="pop-footer">
					<button class="cancel">取消</button>
					<button id="saveBtn" class="primary">保存</button>
				</div>
			</div>
		</div>
	
		<!-- 修改弹出框 -->
		<div id="modifyBox" class="pop-up hidden">
			<div class="pop-shade"></div>
			<div class="pop-box">
				<div class="pop-header">修改菜品</div>
				<div class="pop-content">
					<input type="text" id="foodId" hidden>
					<div class="row">
						<span>菜品名称</span>
						<input type="text" id="foodName1">
					</div>
					<div class="row">
						<span>描述</span>
						<input type="text" id="description1">
					</div>
					<div class="row">
						<span>价格</span>
						<input type="text" id="price1">
					</div>
					<div class="row">
						<span>分类</span>
						<select id="type1">
							<option>凉菜</option>
							<option>江浙菜</option>
							<option>川菜</option>
							<option>鲁菜</option>
							<option>主食</option>
							<option>酒水饮料</option>
						</select>
					</div>
				</div>
				<div class="pop-footer">
					<button class="cancel">取消</button>
					<button id="modifyBtn" class="primary">保存</button>
				</div>
			</div>
		</div>
	
		<!-- 删除弹出框 -->
		<div id="deleteBox" class="pop-up hidden">
			<div class="pop-shade"></div>
			<div class="pop-box">
				<div class="pop-header">删除确认</div>
				<div class="pop-content">
					<input type="text" id="foodId" hidden>
					<span class="pop-tip">是否删除该菜品？</span>
				</div>
				<div class="pop-footer">
					<button class="cancel">取消</button>
					<button id="deleteBtn" class="primary">确认</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		var that = this;
	
		<!--点击添加按钮后进行的操作-->
		$('.addBtn').click(function() {
			$('#addBox').removeClass('hidden');
		});

		$('.cancel').click(function() {
			$('.pop-up').addClass('hidden');
		});

		$('#saveBtn').click(function() {
			$.ajax({
				type : "POST",
				url : "../foods/save",
				dataType : "json",
				data : JSON.stringify({
					foodName : $('#foodName').val(),
					price : $('#price').val(),
					description : $('#description').val(),
					type : $('#type').val()
				}),
				contentType : "application/json; charset=utf-8",
				success : function(msg) {
					//alert(msg.message);
					location.reload();
				}
			});
		});

		// 修改
		$('#modifyBtn').click(function() {
			$.ajax({
				type : "POST",
				url : "../foods/update",
				dataType : "json",
				data : JSON.stringify({
					id : $('#foodId').val(),
					foodName : $('#foodName1').val(),
					price : $('#price1').val(),
					description : $('#description1').val(),
					type : $('#type1').val()
				}),
				contentType : "application/json; charset=utf-8",
				success : function(msg) {
					//alert(msg.message);
					location.reload();
				}
			});
		});

		// 删除
		$('#deleteBtn').click(function() {
			$.ajax({
				type : "POST",
				url : "../foods/delete/" + $('#foodId').val(),
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(msg) {
					//alert(msg.message);
					location.reload();
				}
			})
		});
		
		function init() {
			$.ajax({
				type : "POST",
				url : "../foods/list",
				dataType : "json",
				data : JSON.stringify({
					foodName : $('#searchButton').val()
				}),
				contentType : "application/json; charset=utf-8",
				success : function(msg) {
					var _html = '';
					for (var i = 0; i < msg.length; i++) {
						var food = msg[i];
						_html += '<tr><td width="60">'
								+ (i + 1)
								+ '</td><td width="180">'
								+ food.foodName
								+ '</td>'
								+ '<td width="240">'
								+ food.description
								+ '</td><td width="80">￥'
								+ food.price
								/ 100
								+ '</td><td width="100">'
								+ food.type
								+ '</td>'
								+ '<td width="120" data-id="'+ food.id +'" data-name="'+ food.foodName +'" data-desc="'+ food.description 
						+ '" data-price="'+ food.price +'" data-type="'+ food.type +'">'
								+ '<button class="modify">修改</button><button class="delete">删除</button></td></tr>';
						//+ food.id + ' ' + food.foodName + ' ' + food.price + ' ' + food.description + '</div>';
					}
					$('#orderTBody').html(_html);
					$('.modify').click(function() {
						$('#foodId').val($(this).parent().data('id'));
						$('#foodName1').val($(this).parent().data('name'));
						$('#price1').val($(this).parent().data('price'));
						$('#description1').val($(this).parent().data('desc'));
						$('#type1').val($(this).parent().data('type'));
						$('#modifyBox').removeClass('hidden');
					});

					// 显示删除弹出框
					$('.delete').click(function(){
						$('#foodId').val($(this).parent().data('id'));
						$('#deleteBox').removeClass('hidden');
					});
				},
				error : function() {
					alert(msg);
				}
			});
		}

		// 查询
		$('.searchBtn').click(function() {
			that.init();
		});
		
		$(window).on('ready', function() {
			that.init();
		})
	</script>
</body>
</html>