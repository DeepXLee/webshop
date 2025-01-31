package com.max.web.frontend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.max.dto.ProductExecution;
import com.max.entity.Product;
import com.max.entity.ProductCategory;
import com.max.entity.Shop;
import com.max.service.ProductCategoryService;
import com.max.service.ProductService;
import com.max.service.ShopService;
import com.max.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/frontend")
public class ShopDetailController {
	@Autowired
	private ShopService shopService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCategoryService productCategoryService;
	
	/**
	 * 获取店铺信息以及店铺下面的商品类别列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listshopdetailpageinfo",method=RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listShopDetailPageInfo(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		//获取前台传过来的shopId
		long shopId = HttpServletRequestUtil.getLong(request, "shopId");
		Shop shop = null;
		List<ProductCategory> productCategoryList = null;
		if(shopId != -1) {
			//获取店铺Id为shopId的店铺信息
			shop = shopService.queryByShopId(shopId);
			//获取店铺下面的商品类别列表
			productCategoryList = productCategoryService.getProductCategoryList(shopId);
			modelMap.put("shop",shop);
			modelMap.put("productCategoryList",productCategoryList);
			modelMap.put("success",true);
		}else {
			modelMap.put("success",false);
			modelMap.put("errMsg","empty shopId");
		}
		return modelMap;
	}
	
	/**
	 * 依据查询条件分页列出该店铺下面的所有商品
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listproductsbyshop",method=RequestMethod.GET)
	private Map<String, Object> listProductsByShop(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		//获取页码
		int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
		//获取一页需要显示的条数
		int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
		//获取店铺id
		long shopId = HttpServletRequestUtil.getLong(request, "shopId");
		//空值判断
		if((pageIndex > -1) && (pageSize > -1) && (shopId >-1)) {
			//尝试获取商品类别Id
			long productCategoryId = HttpServletRequestUtil.getLong(request, "productCategoryId");
			//尝试获取模糊查找的商品名
			String productName = HttpServletRequestUtil.getString(request, "productName");
			//组合查询条件
			Product productCondition = compactProductCondition4Seach(shopId,productCategoryId,productName);
			//按照传入的查询条件以及分页信息返回相应商品列表以及总数
			ProductExecution pe = productService.getProductList(productCondition, pageIndex, pageSize);
			modelMap.put("proudctList",pe.getProductList());
			modelMap.put("count",pe.getCount());
			modelMap.put("success",true);
		}else {
			modelMap.put("success",false);
			modelMap.put("errMsg","empty pageSize or pageIndex or shopId");
		}
		return modelMap;
	}
	
	
	
	//组合查询条件
	private Product compactProductCondition4Seach(Long shopId, long productCategoryId, String productName) {
		Product productCondition = new Product();
		Shop shop = new Shop();
		shop.setShopId(shopId);
		productCondition.setShop(shop);
		// 若有指定类别的要求则添加进去
		if (productCategoryId != -1L) {
			ProductCategory productCategory = new ProductCategory();
			productCategory.setProductCategoryId(productCategoryId);
			productCondition.setProductCategory(productCategory);
		}
		// 若有商品名模糊查询的要求则添加进去
		if (productName != null) {
			productCondition.setProductName(productName);
		}
		//只允许选出状态为上架的商品
		productCondition.setEnableStatus(1);
		return productCondition;
	}
	
	

}
