package com.hxw.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hxw.springboot.dao.BillMapper;
import com.hxw.springboot.interfaces.BillService;
import com.hxw.springboot.pojo.Bill;

@com.alibaba.dubbo.config.annotation.Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillMapper billMapper;

	public int deleteByPrimaryKey(Integer bId) {
		// TODO Auto-generated method stub
		return billMapper.deleteByPrimaryKey(bId);
	}

	public int insert(Bill record) {
		// TODO Auto-generated method stub
		return billMapper.insert(record);
	}

	public int insertSelective(Bill record) {
		// TODO Auto-generated method stub
		return billMapper.insertSelective(record);
	}

	public Bill selectByPrimaryKey(Integer bId) {
		// TODO Auto-generated method stub
		return billMapper.selectByPrimaryKey(bId);
	}

	public int updateByPrimaryKeySelective(Bill record) {
		// TODO Auto-generated method stub
		return billMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Bill record) {
		// TODO Auto-generated method stub
		return billMapper.updateByPrimaryKey(record);
	}

	public List<Bill> showAllBill(Integer pageSize, Integer pageIndex, Bill bill) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer sum = (pageIndex - 1) * pageSize;

		map.put("pageSize", pageSize);
		map.put("pageNo", sum);
		map.put("bName", bill.getbName());
		map.put("payment", bill.getPayment());

		List<Bill> billList = billMapper.showAllBill(map);
		return billList;
	}

	public Integer countBill(Bill bill) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bName", bill.getbName());
		map.put("payment", bill.getPayment());

		Integer count = billMapper.countBill(map);
		return count;
	}

}