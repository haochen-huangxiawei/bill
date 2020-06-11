package com.hxw.springboot.interfaces;

import java.util.List;

import com.hxw.springboot.pojo.Supplier;

public interface SupplierService {
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
	 * 查询所有供应商
	 */
	List<Supplier> showAllSupplier(Integer pageSize, Integer pageIndex, Supplier supplier);

	/**
	 * 总页数
	 */
	Integer countSupplier(Supplier record);
}