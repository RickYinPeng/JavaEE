package yp.itcast.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//<bean name="user" class="yp.itcast.bean.User" />�൱������
/*@Component("user")
	@Service("user")		service��
	@Controller("user")		web��
*/
@Repository("user")		//dao��
//ָ����������÷�Χ
@Scope(scopeName="singleton")
public class User {
	
	
	private String name;
	
	@Value("18")
	private Integer age;
	
	//@Autowired	//�Զ�װ��
	//���⣺���ƥ�䵽�������һ�µĶ��󣬽��޷�ѡ�����ע����һ������
	//@Qualifier("car2")//ʹ��@Qualifierע�����Spring�����Զ�װ���ĸ����ƵĶ���
	
	@Resource(name="car")//�ֶ�ע�룬ָ��ע���ĸ����ƵĶ���
	private Car car;
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}
	
	@Value("tom")
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@PostConstruct  //������� post��֮��construct������ ������󱻴��������
	public void init(){
		System.out.println("���ǳ�ʼ��������");
	}
	@PreDestroy		//��������֮ǰ���õ�
	public void destory(){
		System.out.println("�������ٷ�����");
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
