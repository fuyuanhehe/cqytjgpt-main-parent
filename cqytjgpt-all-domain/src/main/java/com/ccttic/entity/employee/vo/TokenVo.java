package com.ccttic.entity.employee.vo;

public class TokenVo {
	private String refreshToken;
	private String axjToken;
	public TokenVo() {
		super();
	}
	
	public TokenVo(String refreshToken, String axjToken) {
		super();
		this.refreshToken = refreshToken;
		this.axjToken = axjToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getAxjToken() {
		return axjToken;
	}
	public void setAxjToken(String axjToken) {
		this.axjToken = axjToken;
	}
	
}
