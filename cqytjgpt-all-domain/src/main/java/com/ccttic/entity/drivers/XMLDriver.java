package com.ccttic.entity.drivers;

public class XMLDriver {
	// 注册ID
		private String id;
		// 档案编号
		private String dabh;
		// 身份证明名称
		private String sfzmmc;
		// 身份证明号码
		private String sfzmhm;
		// 姓名
		private String xm;
		// 准驾车型
		private String zjcx;
		// 状态
		private String zt;
		// 累计积分
		private String ljjf;
		// 有效期至
		private String yxqz;
		// 初次登记
		private String ccdjrq;
		// 绑定时间
		private String addtime;
		// 手机号码
		private String sjhm;
		//token
		private String token;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getDabh() {
			return dabh;
		}
		public void setDabh(String dabh) {
			this.dabh = dabh;
		}
		public String getSfzmmc() {
			return sfzmmc;
		}
		public void setSfzmmc(String sfzmmc) {
			this.sfzmmc = sfzmmc;
		}
		public String getSfzmhm() {
			return sfzmhm;
		}
		public void setSfzmhm(String sfzmhm) {
			this.sfzmhm = sfzmhm;
		}
		public String getXm() {
			return xm;
		}
		public void setXm(String xm) {
			this.xm = xm;
		}
		public String getZjcx() {
			return zjcx;
		}
		public void setZjcx(String zjcx) {
			this.zjcx = zjcx;
		}
		public String getZt() {
			return zt;
		}
		public void setZt(String zt) {
			this.zt = zt;
		}
		public String getLjjf() {
			return ljjf;
		}
		public void setLjjf(String ljjf) {
			this.ljjf = ljjf;
		}
		public String getYxqz() {
			return yxqz;
		}
		public void setYxqz(String yxqz) {
			this.yxqz = yxqz;
		}
		public String getCcdjrq() {
			return ccdjrq;
		}
		public void setCcdjrq(String ccdjrq) {
			this.ccdjrq = ccdjrq;
		}
		public String getAddtime() {
			return addtime;
		}
		public void setAddtime(String addtime) {
			this.addtime = addtime;
		}
		public String getSjhm() {
			return sjhm;
		}
		public void setSjhm(String sjhm) {
			this.sjhm = sjhm;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public XMLDriver(String id, String dabh, String sfzmmc, String sfzmhm, String xm, String zjcx, String zt, String ljjf,
				String yxqz, String ccdjrq, String addtime, String sjhm, String token) {
			super();
			this.id = id;
			this.dabh = dabh;
			this.sfzmmc = sfzmmc;
			this.sfzmhm = sfzmhm;
			this.xm = xm;
			this.zjcx = zjcx;
			this.zt = zt;
			this.ljjf = ljjf;
			this.yxqz = yxqz;
			this.ccdjrq = ccdjrq;
			this.addtime = addtime;
			this.sjhm = sjhm;
			this.token = token;
		}
		public XMLDriver() {
			super();
			// TODO Auto-generated constructor stub
		}

		
}
