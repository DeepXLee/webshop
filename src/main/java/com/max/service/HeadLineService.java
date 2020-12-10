package com.max.service;

import java.util.List;

import com.max.entity.HeadLine;

public interface HeadLineService {
	/**
	 * 根据传入的条件返回指定的头条列表
	 * 
	 * @param headLineCondition
	 * @return
	 * @throws Exception
	 */
	List<HeadLine>getHeadLineList(HeadLine headLineCondition) throws Exception;
}
