package com.max.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.dao.ShopDao;
import com.max.dto.ImageHolder;
import com.max.dto.ShopExecution;
import com.max.entity.Shop;
import com.max.enums.ShopStateEnum;
import com.max.exceptions.ShopOperationException;
import com.max.service.ShopService;
import com.max.util.ImageUtil;
import com.max.util.PageCalculator;
import com.max.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;
	
	@Override
	public ShopExecution addShop(Shop shop, ImageHolder thumbnail) {
		//空值判断
		if(shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			//给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if(effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			}else {
				if(thumbnail.getImage() !=null) {
					//存储图片
					try {
						addShopImg(shop,thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error:"+e.getMessage());
					}
					//更新店铺的图片地址
					effectedNum = shopDao.updateShop(shop);
					if(effectedNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error:"+e.getMessage());
		}
		
		
		
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

	public void addShopImg(Shop shop, ImageHolder thumbnail) {
		//获取shop图片目录的相对路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shop.setShopImg(shopImgAddr);
		
	}

	@Override
	public Shop queryByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}

	@Override
	public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail)
			throws ShopOperationException {
		if(shop == null || shop.getShopId() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}else {
			//1.判断是否需要处理图片
			try {
				if(thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					System.out.println("tempshop:"+tempShop);
					if(tempShop.getShopImg() != null) {
						System.out.println("img:"+tempShop.getShopImg());
						ImageUtil.deleteFileOrPath(tempShop.getShopImg());
					}
					addShopImg(shop, thumbnail);
				}
				//2.更新店铺信息
				shop.setLastEditTime(new Date());
				int effectedNum = shopDao.updateShop(shop);
				if(effectedNum <= 0) {
					return new ShopExecution(ShopStateEnum.INNER_ERROR);
				}else {
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopExecution(ShopStateEnum.SUCCESS, shop);
				}
			} catch (Exception e) {
				throw new ShopOperationException("modifyShop error:" + e.getMessage());
			}
		}
	}

	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int count = shopDao.queryShopCount(shopCondition);
		ShopExecution se = new ShopExecution();
		if(shopList != null) {
			se.setShopList(shopList);
			se.setCount(count);
		}else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}

}
