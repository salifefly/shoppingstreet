package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.GoodsDao;
import com.iotek.dao.impl.GoodsDaoImpl;
import com.iotek.entity.Goods;
import com.iotek.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	private GoodsDao goodsDao = new GoodsDaoImpl();

	@Override
	public List<Goods> queryByKey(String key) {
		return goodsDao.queryByKey(key);
	}

}
