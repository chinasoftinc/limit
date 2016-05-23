package com.athena.module.congyry.model;

import com.athena.common.base.entity.PageModel;

public class Congyry extends PageModel<Congyry> {
	private static final long serialVersionUID = -84397532557007885L;

	// 从业人员id
	private String congyryid;

	// 人员姓名
	private String xingm;

	// 性别
	private String xingb;

	// 出生日期
	private String chusrq;

	// 身份证件类别
	private String shenfzjlb;

	// 身份证件编号
	private String shenfzjbh;

	// 隶属区县代码
	private String lisqx;

	// 固定电话
	private String guddh;

	// 移动电话
	private String yiddh;

	// 身份证地址
	private String shenfzdz;

	// 现住地地址
	private String xianzdz;

	// 电子信箱
	private String dianzyx;

	// 住址邮政编码
	private String zhuzyzbm;

	// 专业技术
	private String zhuanyjs;

	// 驾驶证号
	private String jiaszh;

	// 准驾车型代码
	private String zhunjcx;

	// 驾照初领日期
	private String jiazclrq;

	// 驾照有效期始
	private String jiazyxqs;

	// 驾照有效期止
	private String jiazyxqz;

	// 驾照有效期限(年)
	private Short jiazyxqx;

	// 驾照发证机关
	private String jiazfzjg;

	// 照片路径
	private String zhaoplj;

	// 从业资格编码
	private String congyzgdm;

	// 从业资格名称
	private String congyzgmc;

	// 安全驾驶经历(中)
	private Short anqjsjl;

	// 行政区划代码
	private String xingzqh;

	// 机构id
	private String jigid;

	// 注册id
	private String zhucid;

	// 创建时间
	private String chuangjsj;

	// 创建人
	private String chuangjr;

	// 修改时间
	private String xiugsj;

	// 修改人
	private String xiugr;

	// 服务器标识
	private String fuwqbs;

	// 备注
	private String beiz;

	public String getCongyryid() {
		return congyryid;
	}

	public void setCongyryid(String congyryid) {
		this.congyryid = congyryid == null ? null : congyryid.trim();
	}

	public String getXingm() {
		return xingm;
	}

	public void setXingm(String xingm) {
		this.xingm = xingm == null ? null : xingm.trim();
	}

	public String getXingb() {
		return xingb;
	}

	public void setXingb(String xingb) {
		this.xingb = xingb == null ? null : xingb.trim();
	}

	public String getChusrq() {
		return chusrq;
	}

	public void setChusrq(String chusrq) {
		this.chusrq = chusrq == null ? null : chusrq.trim();
	}

	public String getShenfzjlb() {
		return shenfzjlb;
	}

	public void setShenfzjlb(String shenfzjlb) {
		this.shenfzjlb = shenfzjlb == null ? null : shenfzjlb.trim();
	}

	public String getShenfzjbh() {
		return shenfzjbh;
	}

	public void setShenfzjbh(String shenfzjbh) {
		this.shenfzjbh = shenfzjbh == null ? null : shenfzjbh.trim();
	}

	public String getLisqx() {
		return lisqx;
	}

	public void setLisqx(String lisqx) {
		this.lisqx = lisqx == null ? null : lisqx.trim();
	}

	public String getGuddh() {
		return guddh;
	}

	public void setGuddh(String guddh) {
		this.guddh = guddh == null ? null : guddh.trim();
	}

	public String getYiddh() {
		return yiddh;
	}

	public void setYiddh(String yiddh) {
		this.yiddh = yiddh == null ? null : yiddh.trim();
	}

	public String getShenfzdz() {
		return shenfzdz;
	}

	public void setShenfzdz(String shenfzdz) {
		this.shenfzdz = shenfzdz == null ? null : shenfzdz.trim();
	}

	public String getXianzdz() {
		return xianzdz;
	}

	public void setXianzdz(String xianzdz) {
		this.xianzdz = xianzdz == null ? null : xianzdz.trim();
	}

	public String getDianzyx() {
		return dianzyx;
	}

	public void setDianzyx(String dianzyx) {
		this.dianzyx = dianzyx == null ? null : dianzyx.trim();
	}

	public String getZhuzyzbm() {
		return zhuzyzbm;
	}

	public void setZhuzyzbm(String zhuzyzbm) {
		this.zhuzyzbm = zhuzyzbm == null ? null : zhuzyzbm.trim();
	}

	public String getZhuanyjs() {
		return zhuanyjs;
	}

	public void setZhuanyjs(String zhuanyjs) {
		this.zhuanyjs = zhuanyjs == null ? null : zhuanyjs.trim();
	}

	public String getJiaszh() {
		return jiaszh;
	}

	public void setJiaszh(String jiaszh) {
		this.jiaszh = jiaszh == null ? null : jiaszh.trim();
	}

	public String getZhunjcx() {
		return zhunjcx;
	}

	public void setZhunjcx(String zhunjcx) {
		this.zhunjcx = zhunjcx == null ? null : zhunjcx.trim();
	}

	public String getJiazclrq() {
		return jiazclrq;
	}

	public void setJiazclrq(String jiazclrq) {
		this.jiazclrq = jiazclrq == null ? null : jiazclrq.trim();
	}

	public String getJiazyxqs() {
		return jiazyxqs;
	}

	public void setJiazyxqs(String jiazyxqs) {
		this.jiazyxqs = jiazyxqs == null ? null : jiazyxqs.trim();
	}

	public String getJiazyxqz() {
		return jiazyxqz;
	}

	public void setJiazyxqz(String jiazyxqz) {
		this.jiazyxqz = jiazyxqz == null ? null : jiazyxqz.trim();
	}

	public Short getJiazyxqx() {
		return jiazyxqx;
	}

	public void setJiazyxqx(Short jiazyxqx) {
		this.jiazyxqx = jiazyxqx;
	}

	public String getJiazfzjg() {
		return jiazfzjg;
	}

	public void setJiazfzjg(String jiazfzjg) {
		this.jiazfzjg = jiazfzjg == null ? null : jiazfzjg.trim();
	}

	public String getZhaoplj() {
		return zhaoplj;
	}

	public void setZhaoplj(String zhaoplj) {
		this.zhaoplj = zhaoplj == null ? null : zhaoplj.trim();
	}

	public String getCongyzgdm() {
		return congyzgdm;
	}

	public void setCongyzgdm(String congyzgdm) {
		this.congyzgdm = congyzgdm == null ? null : congyzgdm.trim();
	}

	public String getCongyzgmc() {
		return congyzgmc;
	}

	public void setCongyzgmc(String congyzgmc) {
		this.congyzgmc = congyzgmc == null ? null : congyzgmc.trim();
	}

	public Short getAnqjsjl() {
		return anqjsjl;
	}

	public void setAnqjsjl(Short anqjsjl) {
		this.anqjsjl = anqjsjl;
	}

	public String getXingzqh() {
		return xingzqh;
	}

	public void setXingzqh(String xingzqh) {
		this.xingzqh = xingzqh == null ? null : xingzqh.trim();
	}

	public String getJigid() {
		return jigid;
	}

	public void setJigid(String jigid) {
		this.jigid = jigid == null ? null : jigid.trim();
	}

	public String getZhucid() {
		return zhucid;
	}

	public void setZhucid(String zhucid) {
		this.zhucid = zhucid == null ? null : zhucid.trim();
	}

	public String getChuangjsj() {
		return chuangjsj;
	}

	public void setChuangjsj(String chuangjsj) {
		this.chuangjsj = chuangjsj == null ? null : chuangjsj.trim();
	}

	public String getChuangjr() {
		return chuangjr;
	}

	public void setChuangjr(String chuangjr) {
		this.chuangjr = chuangjr == null ? null : chuangjr.trim();
	}

	public String getXiugsj() {
		return xiugsj;
	}

	public void setXiugsj(String xiugsj) {
		this.xiugsj = xiugsj == null ? null : xiugsj.trim();
	}

	public String getXiugr() {
		return xiugr;
	}

	public void setXiugr(String xiugr) {
		this.xiugr = xiugr == null ? null : xiugr.trim();
	}

	public String getFuwqbs() {
		return fuwqbs;
	}

	public void setFuwqbs(String fuwqbs) {
		this.fuwqbs = fuwqbs == null ? null : fuwqbs.trim();
	}

	public String getBeiz() {
		return beiz;
	}

	public void setBeiz(String beiz) {
		this.beiz = beiz == null ? null : beiz.trim();
	}

	@Override
	public Object getId() {
		return this.congyryid;
	}
}