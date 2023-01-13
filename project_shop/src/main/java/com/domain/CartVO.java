package com.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CartVO {
	private int cart_id;
	private int mno;
	private int pno;
	private String cart_pname;
	private String cart_price;
	private Date regDate;
}
