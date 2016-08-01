<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <title>客户管理</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" >
    	function testajax(){
    		$.ajax({
    			type:"POST",
    			url:"testcustomer",
    			data:{test:"test"},
    			dataType:"json",
    			success:function(data){
    				console.log(data);
    			}
    		});
    		
    	}
    </script>
</head>
<body>



<table>
    <tr>
        <th>客户名称</th>
        <th>联系人</th>
        <th>电话号码</th>
        <th>邮箱地址</th>
        <th>操作</th>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.id}</td>
        </tr>
    </c:forEach>
    <input type="button" value="点我吧··" onclick="testajax()"/>
</table>

</body>
</html>