<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div,h2,table{
	width:600px;
	margin: auto;
}
h2,p,table{
	text-align: center;
}
#add,#del{
	text-decoration: none;
}
 tr:nth-child(odd){ 
  	background-color: lightgrey;  
 }
</style>

</head>
<body>
<div>
	<h2>请假记录列表</h2>
	<a href="${pageContext.request.contextPath }/addLeave" id="add">添加请假记录</a>
	<table border="1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>请假时间</th>
			<th>请假原因</th>
			<th>操作</th>
		</tr>
		<c:forEach var="leave" items="${leave }">
		<tr>
			<td>${leave.id }</td>
			<td>${leave.name }</td>
			<td>
				<fmt:formatDate value="${leave.leaveTime }" pattern="yyyy-MM-dd"/>
			</td>
			<td>${leave.reason }</td>
			<td><a href="javascript:;" id="del" onclick="del(${leave.id})">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	<p>
		<a href="${pageContext.request.contextPath }/indexs?pageIndex=1">首页</a>
		<a href="${pageContext.request.contextPath }/indexs?pageIndex=${page.currPageNo - 1 < 1 ? page.currPageNo : page.currPageNo - 1 }">上一页</a>
		<a href="${pageContext.request.contextPath }/indexs?pageIndex=${page.currPageNo + 1 > page.totalPageCount ? page.currPageNo : page.currPageNo + 1 }">下一页</a>
		<a href="${pageContext.request.contextPath }/indexs?pageIndex=${page.totalPageCount }">末页</a>
		<span>第${page.currPageNo }页/共${page.totalPageCount }页</span>
	</p>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.3.js"></script>
<script type="text/javascript">
	function del(id){
		if(confirm("确认要删除嘛？")){
			location.href="${pageContext.request.contextPath}/delLeave?id="+id;
// 			alert("111");
// 			jQuery.ajax({
// 				url	:	"/delLeave",
// 				type:	"post",
// 				data:	"id="+id,
// 				dataType:	"text",
// 				success	:	callBack,
// 				error	:	function(){
// 					alert("出现异常");
// 				}
// 			});
// 			function callBack(data){
// 				if(data > 0){
// 					alert("删除成功!");
// 					location.reload();
// 				}else{
// 					alert("删除失败");
// 				}
// 			}
		}
	}
</script>
</body>
</html>