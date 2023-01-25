package com.service;

import java.util.List;

import com.dao.CartDao;
import com.domain.CartVO;
import com.domain.MemberVO;
import com.domain.OrderVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CartService {
	
	private CartDao dao;
	
	// 장바구니
	public void addCart(CartVO vo) {
		dao.addCart(vo);
	}

	public List<CartVO> cartIn(String id) {
		return dao.cartIn(id);
	}

	public void delAllCart(String id) {
		dao.delAllCart(id);
	}
	
	public void delCheckCart(String id, String[] list) {
		dao.delCheckCart(id, list);
	}

	public void updateCount(CartVO vo) {
		dao.updateCount(vo);
		
	}

	public void orderCheck(String id, String[] list) {
		dao.orderCheck(id, list);
	}

	public List<OrderVO> orderList(String id) {
		return dao.orderList(id);
	}

	
}
