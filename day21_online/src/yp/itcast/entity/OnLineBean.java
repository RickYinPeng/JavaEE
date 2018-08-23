package yp.itcast.entity;
/**
 * 该对象用于封装登录用户的所有数据
 * @author 鹏鹏
 *
 */
public class OnLineBean {
	private String sessionID;//session对象的id
	private String name;//登录名
	private String ip;//ip
	private String login;//登录时间
	private String lastTime;//最后访问时间
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
