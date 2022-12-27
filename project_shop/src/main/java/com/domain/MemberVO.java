package com.domain;

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
public class MemberVO {
	private int mno;
	private String id;
	private String pwd;
	private String pwdcheck;
	private String name;
	private String email;
	private String birth;
	private String gender;
	private String address;
	
}
