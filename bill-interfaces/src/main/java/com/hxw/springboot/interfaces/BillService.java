package com.hxw.springboot.interfaces;

import java.util.List;

import com.hxw.springboot.pojo.Bill;

public interface BillService {
	int deleteByPrimaryKey(Integer bId);

	int insert(Bill record);

	int insertSelective(Bill record);

	Bill selectByPrimaryKey(Integer bId);

	int updateByPrimaryKeySelective(Bill record);

	int updateByPrimaryKey(Bill record);

	/**
	 * 显示所有账单（分页加模糊查询）
	 */
	List<Bill> showAllBill(Integer pageSize, Integer pageIndex, Bill bill);

	/**
	 * 总记录数
	 */
	Integer countBill(Bill bill);
}