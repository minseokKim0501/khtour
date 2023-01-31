package ksmart42.khtour.dto;

import ksmart42.khtour.dto.Member;

public class LoginHistory {
	//l.login_num	   ,l.login_id	   ,l.login_date	   ,l.logout_date
	private String loginNum;
	private String loginId;
	private String loginDate;
	private String logoutDate;
	
	private Member member;

	public String getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(String logoutDate) {
		this.logoutDate = logoutDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginHistory [loginNum=");
		builder.append(loginNum);
		builder.append(", loginId=");
		builder.append(loginId);
		builder.append(", loginDate=");
		builder.append(loginDate);
		builder.append(", logoutDate=");
		builder.append(logoutDate);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
}
