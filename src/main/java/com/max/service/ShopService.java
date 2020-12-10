package com.max.service;

import com.max.dto.ImageHolder;
import com.max.dto.ShopExecution;
import com.max.entity.Shop;
import com.max.exceptions.ShopOperationException;

public interface ShopService {
	/**
	 * 通过shop id 查询店铺
	 * 
	 * @param shop
	 * @return
	 */
	public Shop queryByShopId(long shopId);

	/**
	 * 更新店铺信息
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

	/**
	 * 注册店铺信息
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	public ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

	/**
	 * 根据shopCondition分页返回相应店铺列表
	 * 
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
}
