package yp.itcast.b_ognl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport {

	// Action的参数数据
	private User user = new User("jack", 30);
	private Book book = new Book("java基础");

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
	 * 在用户每次访问action对象的业务时，struts2框架会创建ActionContext对象（OgnlValueStack对象（Action对象））
	 */
	@Override
	public String execute() throws Exception {
		// 1):获取ActionContext对象
		ActionContext ac = ActionContext.getContext();

		// 往域对象存放数据
		ac.getContextMap().put("request_data", "request_data");
		ac.getSession().put("session_data", "session_data");
		ac.getApplication().put("application_data", "application_data");

		// 2):从ActionContext对象获取OgnlContext对象
		ValueStack vs = ac.getValueStack();

		// 3):查看OgnlValueStack对象的结构

		// 往OgnlValueStack的根对象（List栈）存放数据
		vs.push(user);// 往List栈
		vs.pop();// 从List栈中取出元素（栈顶元素）
		
		vs.push(book);
		return SUCCESS;
	}
}
