package yp.itcast.entity;
/**
 * �ö������ڷ�װ�û������Ա����ѯ����
 * @author ����
 *
 */
public class EmpQuery {
	
	private String name;
	private String gender;
	private String title;
	private String email;
	private double beginSalary;
	private double endSalary;
	private int deptId;//����id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBeginSalary() {
		return beginSalary;
	}
	public void setBeginSalary(double beginSalary) {
		this.beginSalary = beginSalary;
	}
	public double getEndSalary() {
		return endSalary;
	}
	public void setEndSalary(double endSalary) {
		this.endSalary = endSalary;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
}
