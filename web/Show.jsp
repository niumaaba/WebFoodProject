<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
			table{
				border: 1px solid lightblue;
				width: 100%;
			}
			
			table td{
				text-align: center;
			}
			
			thead td{
				border: 1px solid red;
				font-weight: 700;
				
			}
			tbody td{
				border: 1px solid green;
			}
		</style>
</head>
<body>
	
	<table>
				<thead>
					<tr>
						<td>食品ID</td>
						<td>食品类别</td>
						<td>食品名字</td>
						<td>食品图片</td>
						<td>食品单价</td>
						<td>食品详情</td>
						<td>注册时间</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					
				<c:forEach items="${list}" var="food" >
					<tr>
						<td>${food.fid} </td>
						<td>${food.ftype.tname}</td>
						<td>${food.fname}</td>
						<td><img src="web/foods/${food.fpic}" width="100px" height="100px"></td>
						<td>${food.fprice}</td>
						<td>${food.fdesc}</td>
						<td>${food.fregtime}</td>
						<td>
							<button onclick="location.href='../Food/ShowChange?fid='+${food.fid}">修改</button>
							<button>删除</button>
						</td>				
					</tr>
				</c:forEach>	
					
				</tbody>

		</table>
</body>
</html>