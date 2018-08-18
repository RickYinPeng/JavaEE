package yp.itcast.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yp.itcast.dao.EmpDao;
import yp.itcast.entity.Employee;
import yp.itcast.entity.PageBean;
import yp.itcast.service.EmpService;

public class ListEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**   1)�����û�����Ĳ�����currentPage                    **/
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null || currentPage.equals("")){
			//����û���һ�η��ʣ�û�д���currentPage��������ǰҳΪ1
			currentPage = "1";
		}
		
		//�����û������ÿҳ��ʾ��¼��
		String pageSize = request.getParameter("pageSize");
		//���ÿ�д������pageSize��������ΪĬ��ֵ5
		if(pageSize==null || pageSize.equals("")){
			pageSize = "5";
		}
		
		
		/**   2)����ҵ���߼���������ȡ���                    					**/
		// 1)��װPageBean����
		EmpService service = new EmpService();
		PageBean pageBean = service.queryPageBean(currentPage,pageSize);
		
		/**   3)�ѽ�����棬��ת��								*/
		// 2)��PageBean��������������
		request.setAttribute("pageBean", pageBean);

		// 3)ת����jspҳ����ʾ����
		request.getRequestDispatcher("/listEmp.jsp").forward(request, response);
	}

	public void t2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1)��װPageBean����
		PageBean pageBean = new PageBean();
		System.out.println(pageBean);

		// 1.1��ǰҳ����
		// �����ݿ��ж�ȡ��ǰҳ������

		// 1.3���û������л�ȡ��ǰҳ��currentPage��
		String currentPage = request.getParameter("currentPage");
		if (currentPage == null || currentPage.equals("")) {
			// ����û���һ�η��ʣ�û�д���currentPage��������ǰҳΪ1
			currentPage = "1";
		}
		pageBean.setCurrentPage(Integer.valueOf(currentPage));

		EmpDao empdao = new EmpDao();
		// 1.5�ܼ�¼��
		pageBean.setTotalCount(empdao.queryCount());

		// 1.6ÿҳ��ʾ��¼��
		pageBean.setPageSize(2);

		List<Employee> list = empdao.queryData(pageBean.getCurrentPage(), pageBean.getPageSize());
		System.out.println(list);
		pageBean.setData(list);

		// 2)��PageBean��������������
		request.setAttribute("pageBean", pageBean);

		// 3)ת����jspҳ����ʾ����
		request.getRequestDispatcher("/listEmp.jsp").forward(request, response);
	}

	public void t1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1)��װPageBean����
		PageBean pageBean = new PageBean();
		System.out.println(pageBean);

		// 1.1��ǰҳ����
		List<Employee> list = new ArrayList<Employee>();
		for (int i = 1; i <= 5; i++) {
			list.add(new Employee(i, "����" + i, "��", "�����������ʦ", "zhangsan" + i + "@qq.com", 4000 + i * 1000));
		}
		System.out.println(list);
		pageBean.setData(list);

		// 1.2��ҳ
		pageBean.setFirstPage(1);

		// 1.3���û������л�ȡ��ǰҳ��currentPage��
		String currentPage = request.getParameter("currentPage");
		if (currentPage == null || currentPage.equals("")) {
			// ����û���һ�η��ʣ�û�д���currentPage��������ǰҳΪ1
			currentPage = "1";
		}
		pageBean.setCurrentPage(Integer.valueOf(currentPage));

		// 1.4��һҳ
		// �㷨�������ǰҳ����ҳ����Ϊ1������ǰҳ-1
		pageBean.setPrePage(pageBean.getCurrentPage() == pageBean.getFirstPage() ? 1 : pageBean.getCurrentPage() - 1);

		// 1.5�ܼ�¼��
		pageBean.setTotalCount(21);

		// 1.6ÿҳ��ʾ��¼��
		pageBean.setPageSize(5);

		// 1.5ĩҳ/��ҳ��
		// �㷨����� �ܼ�¼��%ÿҳ��ʾ��¼��==0��������������Ϊ�� �ܼ�¼��/ÿҳ��ʾ��¼�����������ܼ�¼��/ÿҳ��ʾ��¼��+1��
		pageBean.setTotalPage(pageBean.getTotalCount() % pageBean.getPageSize() == 0
				? pageBean.getTotalCount() / pageBean.getPageSize()
				: pageBean.getTotalCount() / pageBean.getPageSize() + 1);

		// 1.6��һҳ �㷨�������ǰҳΪĩҳ����Ϊĩҳ������Ϊ��ǰҳ+1
		pageBean.setNextPage(pageBean.getCurrentPage() == pageBean.getTotalPage() ? pageBean.getTotalPage()
				: pageBean.getCurrentPage() + 1);
		// 2)��PageBean��������������
		request.setAttribute("pageBean", pageBean);

		// 3)ת����jspҳ����ʾ����
		request.getRequestDispatcher("/listEmp.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
