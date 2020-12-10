package com.max.service;

import java.util.List;

import com.max.dto.ImageHolder;
import com.max.dto.ProductExecution;
import com.max.entity.Product;
import com.max.exceptions.ProductOperationException;

public interface ProductService {
	/**
	 * 添加商品信息以及图片处理
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImgList
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;

	/**
	 * 通过商品id查询唯一的商品信息
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);

	/**
	 * 更新商品信息以及图片处理
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImageHolderList
	 * @return
	 * @throws Exception
	 */
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImageHolderList)
			throws Exception;

	/**
	 * 查询商品列表并分页
	 * 
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
}
