<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div,table,h2{
	width:500px;
	margin:auto;
}
h2{
	text-align: center;
}
span{
	font-size: 12px;
}
</style>
</head>
<body>
<div>
	<h2>添加请假记录</h2>
	<form action="${pageContext.request.contextPath }/leaveSave" method="post">
		<table>
		<tr>
			<th>姓名:</th>
			<td>
				<input type="text" name="name" id="name">
			</td>
		</tr>
		<tr>
			<th>请假时间:</th>
			<td>
				<input type="text" name="leaveTime" id="leaveTime"><span>格式要求：yyyy-mm-dd</span>				
			</td>
		</tr>
		<tr>
			<th>请假原因:</th>
			<td>
				<textarea rows="4" cols="35" name="reason" id="reason"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="提交">
				<input type="reset" value="清空">
			</td>
		</tr>
	</table>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.3.js"></script>
	<script type="text/javascript">
		$("form").submit(function(){
			alert("123");
			var name = $("#name").val();
			var leaveTime = $("#leaveTime").val();
			var reason = $("#reason").val();
			//var checkDate = /^\d{4}-(0[1-9]|1[12])-(0[1-9]|12[0-9]|3[0-1])/$;
			if(name == null || name == ""){
				alert("姓名不能为空！");
				return false;
			}else if(leaveTime == null || leaveTime == ""){
				alert("请假时间不能为空!");
				return false;
// 			}else if(!checkDate.test(leaveTime)){
// 				alert("日期格式不正确!");
// 				return false;
			}else if(reason == null || reason == ""){
				alert("请假原因不能为空！");
				return false;
			}
			return true;
		});
	</script>
</div>
</body>
</html>