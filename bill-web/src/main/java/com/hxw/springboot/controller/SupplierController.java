package com.hxw.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hxw.springboot.interfaces.SupplierService;
import com.hxw.springboot.pojo.Supplier;

@Controller
public class SupplierController {

	@Reference
	private SupplierService supplierService;

	/**
	 * 显示所有供应商（分页+模糊查询）
	 */
	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public String showAllSupplier(Supplier supplier, Integer pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pageSize = 4;
		/* 模糊查询加分页显示所有供应商 */
		List<Supplier> supplierLisy = supplierService.showAllSupplier(pageSize, pageIndex, supplier);
		/* 总页码 */
		Integer count = supplierService.countSupplier(supplier);
		/* 总页数 */
		int totalPageCount = count % pageSize == 0 ? (count / pageSize) : (count / pageSize + 1);
		model.addAttribute("pageNo", pageIndex);
		model.addAttribute("count", totalPageCount);
		model.addAttribute("supplierLisy", supplierLisy);
		return "showAllSupplier";
	}

	/**
	 * 跳转新增供应商
	 */
	@RequestMapping(value = "/supplier", method = RequestMethod.POST)
	public String addGoSupplier() {
		return "addSupplier";
	}

	/**
	 * 新增供应商
	 */
	@RequestMapping(value = "/supplier", method = RequestMethod.PUT)
	public String addSupplier(Supplier supplier) {
		int result = supplierService.insertSelective(supplier);
		if (result > 0) {
			System.out.println("新增成功！");
		} else {
			System.out.println("新增失败！");
		}
		return "redirect:supplier";
	}

	/**
	 * 根据id显示当前供应商
	 */
	@RequestMapping(value = "/supplier/{sId}", method = RequestMethod.DELETE)
	public String updateShowSupplier(@PathVariable Integer sId, Model model) {
		/* 根据id查询当前供应商 */
		Supplier supplier = supplierService.selectByPrimaryKey(sId);

		model.addAttribute("supp", supplier);
		return "updateSupplier";
	}

	/**
	 * 修改供应商
	 */
	@RequestMapping(value = "/addSupplier", method = RequestMethod.GET)
	public String updateSupplier(Supplier supplier) {
		int result = supplierService.updateByPrimaryKeySelective(supplier);

		if (result > 0) {
			System.out.println("修改供应商成功！");
		} else {
			System.out.println("修改供应商失败！");
		}
		return "redirect:supplier";
	}
}
