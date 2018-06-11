package com.ccttic.entity.car;

public class XMLCar {
		//注册ID
		String id;
		//车辆序号
		String xh;
		//号牌种类
		String hpzl;
		//号牌号码
		String hphm;
		//车辆品牌
		String clpp;
		//所有人
		String syr;
		//初次登记日期
		String ccdjrq;
		//有效期至
		String yxqz;
		//状态
		String zt;
		//车辆类型
		String cllx;
		//绑定时间
		String addtime;
		//车辆识别代号后6位
		String clsbdh;
		
		String codename;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getXh() {
			return xh;
		}

		public void setXh(String xh) {
			this.xh = xh;
		}

		public String getHpzl() {
			return hpzl;
		}

		public void setHpzl(String hpzl) {
			this.hpzl = hpzl;
		}

		public String getHphm() {
			return hphm;
		}

		public void setHphm(String hphm) {
			this.hphm = hphm;
		}

		public String getClpp() {
			return clpp;
		}

		public void setClpp(String clpp) {
			this.clpp = clpp;
		}

		public String getSyr() {
			return syr;
		}

		public void setSyr(String syr) {
			this.syr = syr;
		}

		public String getCcdjrq() {
			return ccdjrq;
		}

		public void setCcdjrq(String ccdjrq) {
			this.ccdjrq = ccdjrq;
		}

		public String getYxqz() {
			return yxqz;
		}

		public void setYxqz(String yxqz) {
			this.yxqz = yxqz;
		}

		public String getZt() {
			return zt;
		}

		public void setZt(String zt) {
			this.zt = zt;
		}

		public String getCllx() {
			return cllx;
		}

		public void setCllx(String cllx) {
			this.cllx = cllx;
		}

		public String getAddtime() {
			return addtime;
		}

		public void setAddtime(String addtime) {
			this.addtime = addtime;
		}

		public String getClsbdh() {
			return clsbdh;
		}

		public void setClsbdh(String clsbdh) {
			this.clsbdh = clsbdh;
		}

		public String getCodename() {
			return codename;
		}

		public void setCodename(String codename) {
			this.codename = codename;
		}

		public XMLCar(String id, String xh, String hpzl, String hphm, String clpp, String syr, String ccdjrq, String yxqz,
				String zt, String cllx, String addtime, String clsbdh, String codename) {
			super();
			this.id = id;
			this.xh = xh;
			this.hpzl = hpzl;
			this.hphm = hphm;
			this.clpp = clpp;
			this.syr = syr;
			this.ccdjrq = ccdjrq;
			this.yxqz = yxqz;
			this.zt = zt;
			this.cllx = cllx;
			this.addtime = addtime;
			this.clsbdh = clsbdh;
			this.codename = codename;
		}

		public XMLCar() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Car [id=" + id + ", xh=" + xh + ", hpzl=" + hpzl + ", hphm=" + hphm + ", clpp=" + clpp + ", syr=" + syr
					+ ", ccdjrq=" + ccdjrq + ", yxqz=" + yxqz + ", zt=" + zt + ", cllx=" + cllx + ", addtime=" + addtime
					+ ", clsbdh=" + clsbdh + ", codename=" + codename + "]";
		}
		
		
}
