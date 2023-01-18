package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.common.ConnectionUtil;
import com.domain.CartVO;
import com.domain.ReplyVO;

public class CartDao {
	
	private DataSource dataSource;
	
	public CartDao() {
		dataSource = ConnectionUtil.getDataSource();
	}
	
	public boolean checkCart(CartVO vo) {
		boolean result = false;
		String query = "select decode(count(*),1,'TRUE','FALSE') as result from shop_cart where id=? and pno=?";
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getPno());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					result = Boolean.parseBoolean(rs.getString("result"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void addCart(CartVO vo) {
		String query = "INSERT INTO SHOP_CART(CART_ID, ID, PNO, CART_CNT) VALUES(SHOP_CART_ID_SEQ.NEXTVAL, ?, ?, ?)";
		String query2 = "update SHOP_CART set CART_CNT = CART_CNT+1 where id=? and pno=?";
		try(Connection conn = dataSource.getConnection();){
			try (
				PreparedStatement pstmt = conn.prepareStatement(query);
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
			){
				conn.setAutoCommit(false);
				if(checkCart(vo) == false) {
					pstmt.setString(1, vo.getId());
					pstmt.setInt(2, vo.getPno());
					pstmt.setInt(3, 1);
					pstmt.executeUpdate();
					conn.commit();
				
				} else {
					pstmt2.setString(1, vo.getId());
					pstmt2.setInt(2, vo.getPno());
					pstmt2.executeUpdate();
					conn.commit();
				}
				
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			} finally {
				conn.setAutoCommit(true);
			}
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
