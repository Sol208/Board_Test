package com.login.prac.member.model;

public class MemberDTO {
	private String pid, pw;


	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "UserDTO [ pid=" + pid + ", pw=" + pw + "]";
	}
}
