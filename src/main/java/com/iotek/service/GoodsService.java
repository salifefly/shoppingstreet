package com.iotek.service;

import java.util.List;

import com.iotek.entity.Goods;

public interface GoodsService {
	public List<Goods> queryByKey(String key);
}
