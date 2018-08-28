package yp.itcast.b_validate;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

/*	public void validateRegister() {
		if (user == null) {
			super.addFieldError("user.error", "至少填写一个数据！！！");
		} else {

			// 在这里写表单数据验证的逻辑
			// System.out.println("调用了validate方法");
			if (user.getName() == null || user.getName().equals("")) {
				// 用户名为空
				// 把错误信息Map集合
				super.addFieldError("user.error.requried", "用户名不能为空！！！");
			}
			if (user.getPassword() == null || user.getPassword().equals("")) {
				// 密码为空
				// 把错误信息Map集合
				super.addFieldError("password.error.requried", "密码不能为空！！！");
			}
		}
	}*/

	/**
	 * 如果validate方法中出现异常，那么直接返回错误页面 如果validate没有出现任何异常，那么直接运行业务方法（register）
	 * 
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception {
		System.out.println("注册成功！！！");
		return SUCCESS;
	}

	public String detail() throws Exception {
		System.out.println("查看用户详细信息");

		return SUCCESS;
	}

}
