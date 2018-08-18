package yp.itcast.entity;
/**
 * 该对象用于封装用户输入的部门查询条件
 * @author 鹏鹏
 *
 */
public class DeptQuery {
	private String deptName;
	private String principal;
	private String functional;
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getFunctional() {
		return functional;
	}
	public void setFunctional(String functional) {
		this.functional = functional;
	}
	@Override
	public String toString() {
		return "DeptQuery [deptName=" + deptName + ", principal=" + principal + ", functional=" + functional + "]";
	}
}
