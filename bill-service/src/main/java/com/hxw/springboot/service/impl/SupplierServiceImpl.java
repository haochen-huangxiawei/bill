package com.hxw.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hxw.springboot.dao.SupplierMapper;
import com.hxw.springboot.interfaces.SupplierService;
import com.hxw.springboot.pojo.Supplier;

@com.alibaba.dubbo.config.annotation.Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierMapper supplierMapper;

	public int deleteByPrimaryKey(Integer sId) {
		// TODO Auto-generated method stub
		return supplierMapper.deleteByPrimaryKey(sId);
	}

	public int insert(Supplier record) {
		// TODO Auto-generated method stub
		return supplierMapper.insert(record);
	}

	public int insertSelective(Supplier record) {
		// TODO Auto-generated method stub
		return supplierMapper.insertSelective(record);
	}

	public Supplier selectByPrimaryKey(Integer sId) {
		// TODO Auto-generated method stub
		return supplierMapper.selectByPrimaryKey(sId);
	}

	public int updateByPrimaryKeySelective(Supplier record) {
		// TODO Auto-generated method stub
		return supplierMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Supplier record) {
		// TODO Auto-generated method stub
		return supplierMapper.updateByPrimaryKey(record);
	}

	public List<Supplier> showAllSupName() {
		// TODO Auto-generated method stub
		return supplierMapper.showAllSupName();
	}

	public Integer countSupplier(Supplier record) {
		// TODO Auto-generated method stub
		return supplierMapper.countSupplier(record);
	}

	public List<Supplier> showAllSupplier(Integer pageSize, Integer pageIndex, Supplier supplier) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer sum = (pageIndex - 1) * pageSize;

		map.put("pageSize", pageSize);
		map.put("pageNo", sum);
		map.put("supName", supplier.getSupName());
		map.put("intro", supplier.getIntro());

		List<Supplier> supplierList = supplierMapper.showAllSupplier(map);
		return supplierList;
	}
}