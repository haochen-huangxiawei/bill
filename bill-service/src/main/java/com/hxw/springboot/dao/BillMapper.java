package com.hxw.springboot.dao;

import java.util.List;
import java.util.Map;

import com.hxw.springboot.pojo.Bill;


public interface BillMapper {

	int deleteByPrimaryKey(Integer bId);

	int insert(Bill record);

	int insertSelective(Bill record);

	Bill selectByPrimaryKey(Integer bId);

	int updateByPrimaryKeySelective(Bill record);

	int updateByPrimaryKey(Bill record);

	/**
	 * 显示所有账单（分页加模糊查询）
	 */
	List<Bill> showAllBill(Map<String, Object> map);

	/**
	 * 总记录数
	 */
	Integer countBill(Map<String, Object> map);
}