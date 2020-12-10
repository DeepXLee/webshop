package com.max.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.dao.AreaDao;
import com.max.entity.Area;
import com.max.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;
	
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.queryArea();
	}

}
