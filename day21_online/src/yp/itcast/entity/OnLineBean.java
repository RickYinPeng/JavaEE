package yp.itcast.entity;
/**
 * �ö������ڷ�װ��¼�û�����������
 * @author ����
 *
 */
public class OnLineBean {
	private String sessionID;//session�����id
	private String name;//��¼��
	private String ip;//ip
	private String login;//��¼ʱ��
	private String lastTime;//������ʱ��
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	@Override
	public String toString() {
		return "OnLineBean [sessionID=" + sessionID + ", name=" + name + ", ip=" + ip + ", login=" + login
				+ ", lastTime=" + lastTime + "]";
	}
	
}
