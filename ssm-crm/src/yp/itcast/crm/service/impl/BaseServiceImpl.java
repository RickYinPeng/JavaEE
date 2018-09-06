package yp.itcast.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yp.itcast.crm.mapper.BaseDictDao;
import yp.itcast.crm.pojo.BaseDict;
import yp.itcast.crm.service.BaseDictService;

@Service
//@Transactional
public class BaseServiceImpl implements BaseDictService {
	
	@Resource(name="baseDictDao")
	private BaseDictDao baseDictDao;

	public List<BaseDict> selectBaseDictListByCode(String code) {
		return baseDictDao.selectBaseDictListByCode(code);
	}
}
