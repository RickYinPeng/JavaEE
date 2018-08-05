package yp.itcast.web.action;


import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yp.itcast.domain.Customer;
import yp.itcast.domain.SaleVisit;
import yp.itcast.domain.User;
import yp.itcast.service.SaleVisitService;
import yp.itcast.utils.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{
	
	private SaleVisit saleVisit = new SaleVisit();
	
	private SaleVisitService svs;
	
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		System.out.println("currentPage:"+currentPage);
		System.out.println("pageSize:"+pageSize);
		
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//�жϲ���װ����
		if(saleVisit.getCustomer()!=null && saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		}
		
		
		//1.����Service��ѯ��ҳ���ݣ�PageBean��
		PageBean pb = svs.getPageBean(dc,currentPage,pageSize);
		//2.��PageBean����request��ת�����б�ҳ����ʾ
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}	
	public String toEdit() throws Exception {
		//1.����Service����id��ѯ
		SaleVisit sv = svs.getById(saleVisit.getVisit_id());
		//2.���������reuqest��
		ActionContext.getContext().put("saleVisit", sv);
		//3.ת����add.jsp
		return "edit";
	}
	
	
	
	//��ӿͻ��ݷü�¼
	public String add() throws Exception {
		System.out.println("����SaleVisitAction����add����");
		
		//0.ȡ����¼�û�����SaleVisitʵ�壬����ϵ
		User u = (User) ActionContext.getContext().getSession().get("user");
		
		
		System.out.println(u);
		
		
		saleVisit.setUser(u);
		
		System.out.println("saleVisit2:"+saleVisit);
		
		System.out.println("1");
		if("".equals(saleVisit.getVisit_id())){
			saleVisit.setVisit_id(null);
		}
		
		
		//1.����Service����ͻ��ݷü�¼
		svs.save(saleVisit);
		System.out.println("2");
		//2.�ض��򵽰ݷü�¼�б�Action
		
		return "toList";
	}
	public void setSvs(SaleVisitService svs) {
		this.svs = svs;
	}
	public SaleVisit getModel() {
		// TODO Auto-generated method stub
		return saleVisit;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
