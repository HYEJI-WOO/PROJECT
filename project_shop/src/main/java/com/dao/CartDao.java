package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.common.ConnectionUtil;
import com.domain.CartVO;

public class CartDao {
	
	private DataSource dataSource;
	
	public CartDao() {
		dataSource = ConnectionUtil.getDataSource();
	}
	
	public void addCart(CartVO vo) {
		String query = "INSERT INTO SHOP_CART(CART_ID, ID, PNO, CART_CNT) VALUES(SHOP_CART_ID_SEQ.NEXTVAL, ?, ?, ?)";
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);	
			){
				pstmt.setString(1, vo.getId());
				pstmt.setInt(2, vo.getPno());
				pstmt.setInt(3, 1);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public List<CartVO> cartIn(String id) {
		List<CartVO> list = new ArrayList();
		String query = "select M.id, p.Name, c.CART_CNT, p.price from shop_cart C inner join shop_product P on P.pno = C.pno inner join shop_member M on C.ID = M.ID where m.id = ?";
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
				pstmt.setString(1, id);
				try(ResultSet rs = pstmt.executeQuery();) {
					while(rs.next()) {
						CartVO vo = CartVO.builder()
								.id(rs.getString("id"))
								.name(rs.getString("name"))
								.cart_cnt(rs.getInt("cart_cnt"))
								.price(rs.getString("price"))
								.build();
						list.add(vo);
								
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}
}
