package com.service;

import java.util.List;

import com.dao.CartDao;
import com.domain.CartVO;
import com.domain.MemberVO;

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
}
