package com.occamasrazor.web.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	private String name,userid,password,ssn,addr;
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", userid,password,name,ssn,addr);
	}
}
