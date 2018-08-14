<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>分页查询员工数据</title>

  </head> 
  
  <body>
  <form id="queryForm" action="${pageContext.request.contextPath}/ListEmpServlet" method="post">
	<%--当前页 --%>
	<input type="hidden" id="currentPage" name="currentPage" value="${pageBean.currentPage }"/>
	<%--每页显示记录数 --%>
	<input type="hidden" id="pageSizeId" name="pageSize" value="${pageBean.pageSize}">
  	<table align="center" border="1" width="1000px">
  		<tr>
			<td>
				姓名：<input type="text" name="name" size="5" value="${param['name']}"/>
				性别：<input type="radio" name="gender" value="男"/>男
					<input type="radio" name="gender" value="女"/>女&nbsp;
				职位：<input type="text" name="title" size="5"/>
				邮箱：<input type="text" name="email"/>
				薪水：从<input type="text" size="3" name="beginSalary"/>
					到<input type="text" size="3" name="endSalary"/>
				部门：
					<select name="deptId">
						<option value="0"></option>
						<c:forEach items="${deptList}" var="dept">
							<option value="${dept.id}">${dept.deptName}</option>
						</c:forEach>
					</select>
					&nbsp;&nbsp;<input type="submit" value="搜索" />
			</td>  		
  		</tr>
  	</table>
  	</form>
  	<table border="1" align="center" width="1000px">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>职位</th>			
			<th>邮箱</th>
			<th>薪水</th>
			<th>部门</th>
		</tr>
	<c:forEach items="${pageBean.data}" var="emp">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.name}</td>
			<td>${emp.gender}</td>
			<td>${emp.title}</td>
			<td>${emp.email}</td>
			<td>${emp.salary}</td>
			<td>${emp.dept.deptName}</td> 
		</tr> 
  	</c:forEach>
  		<tr>
  			<td align="center" colspan="7">
  			<%--
  			需求：
  				1）：如果当前页是首页，那么不能点击"首页"和"上一页",否则可以点击
  				2）：如果当前页是末页，那么不能点击"下一页"和"末页"，否则可以点击
  			 --%>
			<c:choose>
				<c:when test="${pageBean.currentPage==pageBean.firstPage }">
					首页&nbsp;
					上一页&nbsp;
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0)" onclick="toPage(${pageBean.firstPage})">
					首页
					</a>&nbsp;
  					<a href="javascript:void(0)" onclick="toPage(${pageBean.prePage})">
  					上一页
  					</a>&nbsp;
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${pageBean.currentPage==pageBean.totalPage }">
					下一页&nbsp;
					末页&nbsp;
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0)" onclick="toPage(${pageBean.nextPage})">
					下一页
					</a>&nbsp;
  					<a href="javascript:void(0)" onclick="toPage(${pageBean.totalPage})">
  					末页
  					</a>&nbsp;
				</c:otherwise>
			</c:choose>  			 
  				当前为第${pageBean.currentPage}&nbsp;页/共${pageBean.totalPage}页&nbsp;
  				共${pageBean.totalCount}条数据&nbsp;
  				每页显示<input id="pageSize" type="text" size="2" value="${pageBean.pageSize }" onblur="changePageSize()"/>条数据&nbsp;
  				跳转到第<input id="curPage" type="text" size="2" onblur="changePage()"/>页
  			</td>
  		</tr>
  	
  	</table>
  </body>
  <script type="text/javascript">
  	/*改变每页记录数*/
  	function changePageSize(){
  		//1.得到用户输入
  		var pageSize = document.getElementById("pageSize").value;
  		
  		//判断规则：只能输入1-2个数字
  		var reg = /^[1-9][0-9]?$/;
  		if(!reg.test(pageSize)){
  			alert("只能输入1-2位的数字");
  			return;
  		}
  		
  		//2.请求ListEmpServlet,同时发送参数(pageSize)
/*   		var url ="${pageContext.request.contextPath}/ListEmpServlet?pageSize="+pageSize;
  		window.location.href=url; */
  		
  		//提交表单
  		document.getElementById("pageSizeId").value=pageSize;
  		var queryForm = document.getElementById("queryForm");
  		queryForm.submit();//提交表单（）触发submit动作
  	}
  	function changePage(){
  		//1.得到用户输入
  		var curPage = document.getElementById("curPage").value;
  		
  		//判断规则：只能输入1-2个数字
  		var reg = /^[1-9][0-9]?$/;
  		if(!reg.test(curPage)){
  			alert("只能输入1-2位的数字");
  			return;
  		}
  		/*如果输入的页码>=总页数(EL可以在js中，不过要作为一个字符串来写)*/
  		if(curPage>"${pageBean.totalPage}"){
  			alert("已经超过了总页数！！！")
  			return;
  		}
  		
  		//2.请求ListEmpServlet,同时发送参数(pageSize)
/*   		var url ="${pageContext.request.contextPath}/ListEmpServlet?currentPage="+curPage+"&"+"pageSize=${pageBean.pageSize}";
  		window.location.href=url; */
  		
  		//提交表单
  		document.getElementById("currentPage").value = curPage;
  		var queryForm = document.getElementById("queryForm");
  		queryForm.submit();//提交表单（）触发submit动作
  		
  	}
  	//跳转页面，并且提交查询的表单
  	function toPage(pageNo){
  		//提交之前，把当前页设置跳转的页码
  		document.getElementById("currentPage").value = pageNo;
  	
  		//提交表单
  		var queryForm = document.getElementById("queryForm");
  		queryForm.submit();//提交表单（）触发submit动作
  	}
  </script>
</html>
