package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.common.ConnectionUtil;
import com.domain.MemberVO;
import com.domain.ProductVO;

public class ProductDao {
	
private DataSource dataSource;
	
	public ProductDao() {
		dataSource = ConnectionUtil.getDataSource();
	}
	
	// 상품목록
		public List<ProductVO> selectAll() {
			String query = "select * from SHOP_PRODUCT order by pno desc";
			List<ProductVO> list = new ArrayList();
			try (
					Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery();
				){
					while(rs.next()) {
						ProductVO vo = ProductVO.builder()
								.pno(rs.getInt("pno"))
								.name(rs.getString("name"))
								.price(rs.getInt("price"))
								.info(rs.getString("info"))
							.build();
						list.add(vo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
		}
		
		// 상품상세
		public ProductVO selectOne(String name) {
			ProductVO vo = null;
			String query = "select * from SHOP_PRODUCT where name=?";
			try (
					Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);
				){
					pstmt.setString(1, name);
					try(ResultSet rs = pstmt.executeQuery();) {
						if(rs.next()) {
							vo = ProductVO.builder()
								.pno(rs.getInt("pno"))
								.name(rs.getString("name"))
								.price(rs.getInt("price"))
								.info(rs.getString("info"))
								.weight(rs.getString("weight"))
								.category(rs.getString("category"))
								.build();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return vo;
			
		}

		public List<ProductVO> productManage() {
			String query = "select * from shop_product";
			List<ProductVO> list = new ArrayList();
			try (
					Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery();
				){
					while(rs.next()) {
						ProductVO vo = ProductVO.builder()
								.pno(rs.getInt("pno"))
								.name(rs.getString("name"))
								.price(rs.getInt("price"))
								.info(rs.getString("info"))
								.weight(rs.getString("weight"))
								.category(rs.getString("category"))
							.build();
						list.add(vo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			return list;
		}

		public void addProduct(ProductVO vo) {
			String query = "INSERT INTO SHOP_PRODUCT(PNO, NAME, PRICE, INFO, WEIGHT, CATEGORY) VALUES(SHOP_PNO_SEQ.NEXTVAL,?,?,?,?,?)";
			try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);	
				
				){
					pstmt.setString(1, vo.getName());
					pstmt.setInt(2, vo.getPrice());
					pstmt.setString(3, vo.getInfo());
					pstmt.setString(4, vo.getWeight());
					pstmt.setString(5, vo.getCategory());
					pstmt.executeUpdate();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
		}

}