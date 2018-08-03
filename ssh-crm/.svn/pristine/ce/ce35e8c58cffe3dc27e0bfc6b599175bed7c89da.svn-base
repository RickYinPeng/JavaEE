package yp.itcast.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import yp.itcast.domain.BaseDict;
import yp.itcast.domain.Customer;
import yp.itcast.service.BaseDictService;
import yp.itcast.service.CustomerService;
import yp.itcast.utils.PageBean;

public class BaseDictAction extends ActionSupport {
	
	//属性驱动
	private String dict_type_code;
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	
	private BaseDictService baseDictService;
	//供spring注入
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	@Override
	public String execute() throws Exception {
		//1.调用Service根据typecode获得数据字典对象list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		
		//2.将list转换为json格式
		String json = JSONArray.fromObject(list).toString();
		
		//3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json; charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;//告诉struts2不需要进行结果处理
	}
	
}
