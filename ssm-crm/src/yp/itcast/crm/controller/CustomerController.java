package yp.itcast.crm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import yp.itcast.common.utils.Page;
import yp.itcast.crm.pojo.BaseDict;
import yp.itcast.crm.pojo.Customer;
import yp.itcast.crm.pojo.QueryVo;
import yp.itcast.crm.service.BaseDictService;
import yp.itcast.crm.service.CustomerService;
import yp.itcast.crm.service.impl.CustomerServiceImpl;

/**
 * �͑�����
 * @author ����
 *
 */
@Controller
public class CustomerController {
	
	@Resource(name="baseServiceImpl")
	private BaseDictService baseDictService;

	@Resource(name="customerServiceImpl")
	private CustomerService customerService;
	
	
	//ע���Ա������
	@Value("${fromType.code}")
	private String fromTypeCode;
	
	@Value("${industryType.code}")
	private String industryTypeCode;
	
	@Value("${levelType.code}")
	private String levelTypeCode;
	
	
	//���
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo,Model model){
		System.out.println("QueryVo:"+vo);
		
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//ͨ���ĸ�����  ��ѯ��ҳ����
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		
		//������
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
}
