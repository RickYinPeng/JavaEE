package yp.itcast.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yp.itcast.entity.Employee;
import yp.itcast.entity.PageBean;

public class ListEmpServleyt extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1)封装PageBean对象
		PageBean pageBean = new PageBean();
		
		//1.1当前页数据
		List<Employee> list = new ArrayList<Employee>();
		for(int i = 1;i<=5;i++){
			list.add(new Employee(i,"张三"+i,"男","软件开发工程师","zhangsan"+i+"@qq.com",4000+i*1000));
		}
		pageBean.setData(list);
		
		//1.2首页
		pageBean.setFirstPage(1);
		
		//1.3从用户参数中获取当前页（currentPage）
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null || currentPage.equals("")){
			//如果用户第一次访问，没有传递currentPage参数，则当前页为1
			currentPage = "1";
		}
		pageBean.setCurrentPage(Integer.valueOf(currentPage));
		
		//1.4上一页	
		//算法：如果当前页是首页，则为1，否则当前页-1
		pageBean.setPrePage(
				pageBean.getCurrentPage()==pageBean.getFirstPage()
				?1
				:pageBean.getCurrentPage()-1
		);
		
		//1.5总记录数
		pageBean.setTotalCount(21);
		
		//1.6每页显示记录数
		pageBean.setPageSize(5);
		
		//1.5末页/总页数	
		//算法：如果   总记录数%每页显示记录数==0（能整除），则为（ 总记录数/每页显示记录数），否则（总记录数/每页显示记录数+1）
		pageBean.setTotalPage(
		pageBean.getTotalCount()%pageBean.getPageSize()==0
				?pageBean.getTotalCount()/pageBean.getPageSize()
				:pageBean.getTotalCount()/pageBean.getPageSize()+1
		);
		
		//1.6下一页	算法：如果当前页为末页，则为末页，否则为当前页+1
		pageBean.setNextPage(
		pageBean.getCurrentPage()==pageBean.getTotalPage()
				?pageBean.getTotalPage()
				:pageBean.getCurrentPage()+1
		);
		//2)把PageBean对象放入域对象中
		request.setAttribute("pageBean", pageBean);
		
		//3)转发到jsp页面显示数据
		request.getRequestDispatcher("/listEmp.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
