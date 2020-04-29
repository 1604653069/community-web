<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 我是测试界面
 <form action="${pageContext.request.contextPath}/test_upload.action" method="post" enctype="multipart/form-data">
 	<input type="file" name="myFile"  />
 	<input type="submit" value="提交" />
 </form>
 
</body>
</html>