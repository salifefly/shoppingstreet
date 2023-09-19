package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.GoodsDao;
import com.iotek.entity.Goods;
import com.iotek.util.DBUtils;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public List<Goods> queryByKey(String key) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Goods> list = new ArrayList<Goods>();
		try {
			conn = DBUtils.getConn();
			String sql = "select * from t_goods where goods_name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + key + "%");
			rs = pstmt.executeQuery();
			Goods goods;
			while (rs.next()) {
				goods = new Goods();
				goods.setGoodsId(rs.getInt("goods_id"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsDesc(rs.getString("goods_desc"));
				goods.setPrice(rs.getFloat("price"));
				goods.setImgPath(rs.getString("img_path"));
				goods.setTypeId(rs.getInt("type_id"));
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return list;
	}

}
