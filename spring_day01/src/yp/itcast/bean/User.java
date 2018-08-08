package yp.itcast.bean;

public class User {
	private String name;
	private Integer age;
	private Car car;
	public User() {
		System.out.println("User����ղι���");
	}
	public User(String name, Car car) {
		System.out.println("User(String name, Car car) ");
		this.name = name;
		this.car = car;
	}
	public User(Car car,String name) {
		System.out.println("User(Car car,String name) ");
		this.name = name;
		this.car = car;
	}
	
	public User(Integer name, Car car) {
		System.out.println("User(Integer name, Car car) ");
		this.name = name+"";
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void init(){
		System.out.println("���ǳ�ʼ��������");
	}
	public void destory(){
		System.out.println("�������ٷ�����");
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
