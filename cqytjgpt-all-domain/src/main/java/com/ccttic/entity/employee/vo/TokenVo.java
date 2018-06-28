package com.ccttic.entity.employee.vo;

public class TokenVo {
	private String refreshToken;
	private String axjToken;
	private String access_token;
	public TokenVo() {
		super();
	}
	public TokenVo(String refreshToken, String axjToken, String access_token) {
		super();
		this.refreshToken = refreshToken;
		this.axjToken = axjToken;
		this.access_token = access_token;
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
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
