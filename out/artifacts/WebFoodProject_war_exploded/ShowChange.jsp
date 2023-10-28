<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
							
	<form action="Change" method="post" enctype="multipart/form-data">
		<input name="fid" type="hidden" value="${food.fid}" />
		
		食品类别：
		<select name="tid">
			<c:forEach items="${typeList}" var="ty" >
				<c:if test="${ty.tid == food.tid}">  
				    <option value="${ty.tid}" selected>${ty.tname}</option>	
				</c:if>  
				<c:if test="${ty.tid != food.tid}">  
				    <option value="${ty.tid}" >${ty.tname}</option>	
				</c:if>  
			</c:forEach>	
		</select>
		<hr>
		食品名称:
		<input name="fname" type="text" value="${food.fname}" />
		<hr>
		食品图片:
		<img src="http://localhost:8080/webDemo/foods/${food.fpic}" width="100px" height="100px">
		<hr>
		选择新图片:
		<input name="fpic" type="file">
		<hr>
		食品单价:
		<input name="fprice" type="text" value="${food.fprice}" />
		<hr>
		
		<button>修改</button>
		
		
		
	</form>					
	
	<script>
	
		
	
		
		function change(){
			
			
			
		}
		
	
	
	</script>
	
	 
</body>
</html>