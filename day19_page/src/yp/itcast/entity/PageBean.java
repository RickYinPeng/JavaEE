package yp.itcast.entity;

import java.util.List;

/**
 * ��ҳ�������ڴ洢��ǰ��ҳ��ص�����
 * @author ����
 *
 */
public class PageBean {
	List<Employee> data;	//��ǰҳ����
	int firstPage;			//��ҳ
	int prePage;			//��һҳ
	int nextPage;			//��һҳ
	int totalPage;			//ĩҳ/��ҳ��
	int currentPage;		//��ǰҳ
	int totalCount;			//�ܼ�¼��
	int pageSize;			//ÿҳ��ʾ��¼��
	public List<Employee> getData() {
		return data;
	}
	public void setData(List<Employee> data) {
		this.data = data;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
