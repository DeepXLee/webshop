package com.max.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/shopadmin", method= {RequestMethod.GET})
public class ShopAdminController {
	@RequestMapping("/shopoperation")
	public String shopOperation() {
		//转发至店铺注册/编辑页面
		return "shop/shopoperation";
	}
	
	@RequestMapping("/shoplist")
	public String shopList() {
		//转发至店铺列表页面
		return "shop/shoplist";
	}
	
	@RequestMapping("/shopmanagement")
	public String shopManagement() {
		//转发至商品类别管理页面
		return "shop/shopmanagement";
	}
	
	@RequestMapping(value="/productcategorymanagement",method=RequestMethod.GET)
	public String productCategoryManage() {
		// 转发至商品添加/编辑页面
		return "shop/productcategorymanagement";
	}
	
	@RequestMapping(value="/productoperation")
	public String productoperation() {
		// 转发至商品添加/编辑页面
		return "shop/productoperation";
	}
	
	@RequestMapping(value="/productmanagement")
	public String productmanagement() {
		// 转发至商品添加/编辑页面
		return "shop/productmanagement";
	}

}
