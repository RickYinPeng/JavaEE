package yp.itcast.service.impl;

import java.util.List;

import yp.itcast.dao.BaseDictDao;
import yp.itcast.domain.BaseDict;
import yp.itcast.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService{
	
	private BaseDictDao bdd;
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		
		return bdd.getListByTypeCode(dict_type_code);
	}
	
}
