<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>黑色时间轴</title>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	         
	function likes(){
		$.ajax({
			 url:'testcustomer.do',
			 data:{bolgId:'hahah'},
			 type:'post',
			 success:function(data){
				 console.log(data);
			}
	 });
	}


</script>
</head>

<body>

<input type="button" value="点我吧··" onclick="likes()"/>
</html>
