<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>" type="text/css">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.3.min.js"/>"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工</title>
<base href="<%=basePath%>">
</head>
<body>    

</body> 
  
<script type="text/javascript">
var json = '${emp}';
//var json2 = JSON.parse(json);
alert(json);

</script>

</html>