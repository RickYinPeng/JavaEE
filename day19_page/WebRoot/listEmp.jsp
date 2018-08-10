<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>分页查询员工数据</title>

  </head> 
  
  <body>
  	<table border="1" align="center" width="700px">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>职位</th>			
			<th>邮箱</th>
			<th>薪水</th>
		</tr>
	<c:forEach items="${pageBean.data}" var="emp">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.name}</td>
			<td>${emp.gender}</td>
			<td>${emp.title}</td>
			<td>${emp.email}</td>
			<td>${emp.salary}</td> 
		</tr> 
  	</c:forEach>
  		<tr>
  			<td align="center" colspan="6">
  				首页${pageBean.firstPage}&nbsp;上一页${pageBean.prePage }&nbsp;
  				下一页${pageBean.nextPage}&nbsp;末页${pageBean.totalPage}&nbsp;
  				当前为第${pageBean.currentPage}&nbsp;页/共${pageBean.totalPage}页&nbsp;
  				共${pageBean.totalCount}条数据&nbsp;每页显示${pageBean.pageSize}条数据&nbsp;
  			</td>
  		</tr>
  	
  	</table>
  </body>
</html>
