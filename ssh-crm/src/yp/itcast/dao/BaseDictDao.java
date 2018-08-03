package yp.itcast.dao;

import java.util.List;

import yp.itcast.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{
	
	//根据类型获得数据字典
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
