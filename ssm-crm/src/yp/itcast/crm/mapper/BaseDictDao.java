package yp.itcast.crm.mapper;

import java.util.List;

import yp.itcast.crm.pojo.BaseDict;

public interface BaseDictDao {
	
	//��ѯ
	public List<BaseDict> selectBaseDictListByCode(String code);
}
