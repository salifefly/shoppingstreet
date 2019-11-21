package com.iotek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.Goods;
import com.iotek.service.GoodsService;
import com.iotek.service.impl.GoodsServiceImpl;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {

	private GoodsService goodsService = new GoodsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String words = req.getParameter("searchWords");
		List<Goods> list = goodsService.queryByKey(words);
		req.setAttribute("glist", list);
		req.getRequestDispatcher("category_list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
