package com.iotek.dao;

import java.util.List;

import com.iotek.entity.Goods;

public interface GoodsDao {

	public List<Goods> queryByKey(String key);
}
