package com.max.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.dao.HeadLineDao;
import com.max.entity.HeadLine;
import com.max.service.HeadLineService;

@Service
public class HeadLineServiceImpl implements HeadLineService{
	@Autowired
	private HeadLineDao headLineDao;
	
	@Override
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws Exception {
		return headLineDao.queryHeadLine(headLineCondition);
	}

}
