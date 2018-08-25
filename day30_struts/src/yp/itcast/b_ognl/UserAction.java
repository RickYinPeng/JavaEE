package yp.itcast.b_ognl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport {

	// Action�Ĳ�������
	private User user = new User("jack", 30);
	private Book book = new Book("java����");

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ���û�ÿ�η���action�����ҵ��ʱ��struts2��ܻᴴ��ActionContext����OgnlValueStack����Action���󣩣�
	 */
	@Override
	public String execute() throws Exception {
		// 1):��ȡActionContext����
		ActionContext ac = ActionContext.getContext();

		// �������������
		ac.getContextMap().put("request_data", "request_data");
		ac.getSession().put("session_data", "session_data");
		ac.getApplication().put("application_data", "application_data");

		// 2):��ActionContext�����ȡOgnlContext����
		ValueStack vs = ac.getValueStack();

		// 3):�鿴OgnlValueStack����Ľṹ

		// ��OgnlValueStack�ĸ�����Listջ���������
		vs.push(user);// ��Listջ
		vs.pop();// ��Listջ��ȡ��Ԫ�أ�ջ��Ԫ�أ�
		
		vs.push(book);
		return SUCCESS;
	}
}
