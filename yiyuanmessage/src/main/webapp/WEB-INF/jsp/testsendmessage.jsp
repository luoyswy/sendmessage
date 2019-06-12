<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>http发送信息测试</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function testSendMessage(){
		var classType = $("#classType").val();
		var tagAccount = $("#tagAccount").val();
		var receiveAccount = $("#receiveAccount").val();
		var type = $("#type").val();
		var content = $("#content").val();
		var subject = $("#subject").val();
		var datas = {classType:classType,tagAccount:tagAccount,receiveAccount:receiveAccount,content:content,type:type,subject:subject};
		$.ajax({
			url:"sendmessage",
			type:"POST",
			data:datas,
			dataType:"json",
			success: function(data){}
		});
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td colspan="2" align="center">邮箱开通的步骤</td>
		</tr>
		<tr>
			<td>1</td>
			<td>是否开启IMAP/SMTP服务</td>
		</tr>
		<tr>
			<td>2</td>
			<td>开启后获取生成授权码</td>
		</tr>
	</table>
	<div>
		<div>
			<label>采用方式:</label>
			<input type="text" id="classType" />
		</div>
		<div>
			<label>采用的用户:</label>
			<input type="text" id="tagAccount" />
		</div>
		<div>
			<label>接收账号:</label>
			<input type="text" id="receiveAccount" />
		</div>
		<div>
			<label>类型</label>
			<input type="text" id="type" />
		</div>
		<div>
			<label>发送内容:</label>
			<input type="text" id="content" />
		</div>
		<div>
			<label>内容标题:</label>
			<input type="text" id="subject" />
		</div>
	</div>
	<input type="button" onClick="testSendMessage()" value="测试发送信息" />
</body>
</html>