package yp.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import yp.itcast.entity.Department;
import yp.itcast.entity.DeptQuery;
import yp.itcast.service.DeptService;

public class ListDeptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求参数编码（post提交时iso-）
		request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("text/utf-8");
		
		DeptQuery query = new DeptQuery();
		Map parameterMap = request.getParameterMap();
		try {
			BeanUtils.copyProperties(query,parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//1)得到部门数据
		DeptService deptService = new DeptService();
		
		List<Department> list = deptService.findByCondition(query);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/listDept.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
