package com.max.service;

import java.util.List;

import com.max.entity.ShopCategory;

public interface ShopCategoryService {
	/**
	 * 根据查询条件获取ShopCategory列表
	 * 
	 * @param shopcategoryCondition
	 * @return
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
