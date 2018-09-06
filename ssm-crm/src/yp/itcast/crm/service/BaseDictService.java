package yp.itcast.crm.service;

import java.util.List;

import yp.itcast.crm.pojo.BaseDict;

public interface BaseDictService {
	
	//≤È—Ø
	public List<BaseDict> selectBaseDictListByCode(String code);
}
