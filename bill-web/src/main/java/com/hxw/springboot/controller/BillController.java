package com.hxw.springboot.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hxw.springboot.interfaces.BillService;
import com.hxw.springboot.interfaces.SupplierService;
import com.hxw.springboot.pojo.Bill;
import com.hxw.springboot.pojo.Supplier;

@Controller
public class BillController {

	@Reference
	BillService billService;// 账单
	@Reference
	SupplierService supplierService;// 供应商

	/**
	 * 显示所有账单
	 * 
	 * @param pageIndex
	 * @param bill
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public String showAll(Integer pageIndex, Bill bill, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pageSize = 4;
		/* 模糊查询加分页显示所有账单 */
		List<Bill> billList = billService.showAllBill(pageSize, pageIndex, bill);
		/* 总页码 */
		Integer count = billService.countBill(bill);
		/* 总页数 */
		int totalPageCount = count % pageSize == 0 ? (count / pageSize) : (count / pageSize + 1);
		model.addAttribute("pageNo", pageIndex);
		model.addAttribute("count", totalPageCount);
		model.addAttribute("billList", billList);
		return "showAllBill";
	}

	/**
	 * 新增账单（显示所有供应商）
	 */
	@RequestMapping(value = "/bill", method = RequestMethod.POST)
	public String showSupplier(Model model) {
		List<Supplier> supplierList = supplierService.showAllSupName();
		model.addAttribute("supplierList", supplierList);
		return "addBill";
	}

	/**
	 * 新增账单
	 */
	@RequestMapping(value = "/bill", method = RequestMethod.PUT)
	public String addBill(Bill bill, PrintWriter out) {
		/* 新增账单 */
		int result = billService.insertSelective(bill);
		if (result > 0) {
			System.out.println("新增成功！");
		} else {
			System.out.println("新增失败！");
		}
		return "redirect:bill";
	}

	/**
	 * 修改（显示当前账单）
	 */
	@RequestMapping(value = "/bill/{bId}", method = RequestMethod.DELETE)
	public String showThisBill(Model model, @PathVariable Integer bId) {
		/* 根据id查询当前账单 */
		Bill bill = billService.selectByPrimaryKey(bId);
		/* 所有供应商 */
		List<Supplier> supplierList = supplierService.showAllSupName();

		model.addAttribute("supplierList", supplierList);
		model.addAttribute("bill", bill);
		return "updateBill";
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "/addBill", method = RequestMethod.GET)
	public String showBill(Model model, Bill bill) {
		int result = billService.updateByPrimaryKeySelective(bill);
		if (result > 0) {
			System.out.println("修改成功！");
		} else {
			System.out.println("修改失败！");
		}
		return "redirect:bill";
	}
}
