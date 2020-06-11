package com.hxw.springboot.dao;

import java.util.List;
import java.util.Map;

import com.hxw.springboot.pojo.Supplier;

public interface SupplierMapper {
	int deleteByPrimaryKey(Integer sId);

	int insert(Supplier record);

	int insertSelective(Supplier record);

	Supplier selectByPrimaryKey(Integer sId);

	int updateByPrimaryKeySelective(Supplier record);

	int updateByPrimaryKey(Supplier record);

	/**
	 * 查询所有供应商名称
	 */
	List<Supplier> showAllSupName();

	/**
	 * 查询所有供应商（分页+模糊查询）
	 */
	List<Supplier> showAllSupplier(Map<String, Object> map);

	/**
	 * 总页数
	 */
	Integer countSupplier(Supplier record);
}