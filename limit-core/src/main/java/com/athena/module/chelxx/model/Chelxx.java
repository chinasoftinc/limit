package com.athena.module.chelxx.model;

import java.math.BigDecimal;

import com.athena.common.base.entity.PageModel;

/**
 * 车辆信息
 * @author niebinxiao
 */
public class Chelxx extends PageModel<Chelxx> {
	private static final long serialVersionUID = 7937584795026231435L;

	// 车辆Id
	private String chelid;

	// 车辆(挂车)号牌
	private String cheph;

	// 车牌颜色代码
	private String chepys;

	// 是否挂车
	private String shifgc;

	// 车辆类型(代码)
	private String chellx;

	// 规格
	private String guig;

	// 结构
	private String jieg;

	// 车辆行业类别
	private String chelhylb;

	// 车身颜色
	private String chesys;

	// 厂牌
	private String changp;

	// 型号
	private String xingh;

	// 发动机型号
	private String fadjxh;

	// 发动机号码
	private String fadjhm;

	// 发动机功率
	private BigDecimal fadjgl;

	// 车辆识别VIN码
	private String chelsbvin;

	// 行驶证初领日期
	private String xingszclrq;

	// 车辆登记证号
	private String cheldjh;

	// 登记证登记日期
	private String dengjzdjrq;

	// 登记证发证日期
	private String dengjzffrq;

	// 核定座位数
	private Integer hedzws;

	// 燃料类型代码
	private String ranllxdm;

	// 车辆技术等级
	private String cheljsdj;

	// 出厂日期
	private String chucrq;

	// 购车日期
	private String goucrq;

	// 落户日期
	private String luohrq;

	// 轴距
	private Integer zhouj;

	// 车长
	private Integer chec;

	// 车高
	private Integer cheg;
	
	// 车高范围查询参数
	transient String chegRange;
	
	public String getChegRange() {
		return chegRange;
	}

	public void setChegRange(String chegRange) {
		this.chegRange = chegRange;
	}

	// 车宽
	private Integer chek;

	// 车轴数
	private Short chezs;

	// 后轴钢板弹簧片数
	private Short houzgbthps;

	// 悬架形式
	private String xuanjxs;

	// 档案号
	private String dangah;

	// 道路运输证字号
	private String daolyszzh;

	// 证件校验码
	private String zhengjjym;

	// 证件初领日期
	private String zhengjclrq;

	// 证件有效期起
	private String zhengjyxqq;

	// 证件有效期止
	private String zhengjyxqz;

	// 证件发放日期
	private String zhengjffrq;

	// 发证机构
	private String fazjg;

	// 车载终端厂家
	private String chezzdcj;

	// 车载终端型号
	private String chezzdxh;

	// 车载终端编号
	private String chezzdbh;

	// 终端安装日期
	private String zhongdazrq;

	// 行驶记录仪型号
	private String xingsjlyxh;

	// 行驶记录仪编号
	private String xingsjlybh;

	// 业户Id
	private String yehid;

	// 管辖机构Id
	private String guanxjg;

	// 经营范围代码
	private String jingxfwdm;

	// 经营范围名称
	private String jingxfwmc;

	// 行政区划编码
	private String xingzqhbm;

	// 隶属区县代码
	private String lisqxdm;

	// 创建人
	private String chuangjr;

	// 创建时间
	private String chuangjsj;

	// 修改人
	private String xiugr;

	// 修改时间
	private String xiugsj;

	// 证件状态
	private String zhengjzt;

	// 营运状态
	private String yingyzt;

	// 保险Id
	private String baoxid;

	// 备注
	private String beiz;

	// 年审有效日期
	private String niansyxrq;

	// 二级维护有效日期
	private String erjwhyxrq;

	// 技术等级有效日期
	private String jisdjyxrq;

	// 客车等级
	private Short kecdj;

	// 客车等级有效日期
	private String kecdjyxrq;

	// 核定载质量(kg)
	private BigDecimal hedzzl;

	// IC卡卡号
	private String ickkh;

	public String getChelid() {
		return chelid;
	}

	public void setChelid(String chelid) {
		this.chelid = chelid == null ? null : chelid.trim();
	}

	public String getCheph() {
		return cheph;
	}

	public void setCheph(String cheph) {
		this.cheph = cheph == null ? null : cheph.trim();
	}

	public String getChepys() {
		return chepys;
	}

	public void setChepys(String chepys) {
		this.chepys = chepys == null ? null : chepys.trim();
	}

	public String getShifgc() {
		return shifgc;
	}

	public void setShifgc(String shifgc) {
		this.shifgc = shifgc == null ? null : shifgc.trim();
	}

	public String getChellx() {
		return chellx;
	}

	public void setChellx(String chellx) {
		this.chellx = chellx == null ? null : chellx.trim();
	}

	public String getGuig() {
		return guig;
	}

	public void setGuig(String guig) {
		this.guig = guig == null ? null : guig.trim();
	}

	public String getJieg() {
		return jieg;
	}

	public void setJieg(String jieg) {
		this.jieg = jieg == null ? null : jieg.trim();
	}

	public String getChelhylb() {
		return chelhylb;
	}

	public void setChelhylb(String chelhylb) {
		this.chelhylb = chelhylb == null ? null : chelhylb.trim();
	}

	public String getChesys() {
		return chesys;
	}

	public void setChesys(String chesys) {
		this.chesys = chesys == null ? null : chesys.trim();
	}

	public String getChangp() {
		return changp;
	}

	public void setChangp(String changp) {
		this.changp = changp == null ? null : changp.trim();
	}

	public String getXingh() {
		return xingh;
	}

	public void setXingh(String xingh) {
		this.xingh = xingh == null ? null : xingh.trim();
	}

	public String getFadjxh() {
		return fadjxh;
	}

	public void setFadjxh(String fadjxh) {
		this.fadjxh = fadjxh == null ? null : fadjxh.trim();
	}

	public String getFadjhm() {
		return fadjhm;
	}

	public void setFadjhm(String fadjhm) {
		this.fadjhm = fadjhm == null ? null : fadjhm.trim();
	}

	public BigDecimal getFadjgl() {
		return fadjgl;
	}

	public void setFadjgl(BigDecimal fadjgl) {
		this.fadjgl = fadjgl;
	}

	public String getChelsbvin() {
		return chelsbvin;
	}

	public void setChelsbvin(String chelsbvin) {
		this.chelsbvin = chelsbvin == null ? null : chelsbvin.trim();
	}

	public String getXingszclrq() {
		return xingszclrq;
	}

	public void setXingszclrq(String xingszclrq) {
		this.xingszclrq = xingszclrq == null ? null : xingszclrq.trim();
	}

	public String getCheldjh() {
		return cheldjh;
	}

	public void setCheldjh(String cheldjh) {
		this.cheldjh = cheldjh == null ? null : cheldjh.trim();
	}

	public String getDengjzdjrq() {
		return dengjzdjrq;
	}

	public void setDengjzdjrq(String dengjzdjrq) {
		this.dengjzdjrq = dengjzdjrq == null ? null : dengjzdjrq.trim();
	}

	public String getDengjzffrq() {
		return dengjzffrq;
	}

	public void setDengjzffrq(String dengjzffrq) {
		this.dengjzffrq = dengjzffrq == null ? null : dengjzffrq.trim();
	}

	public Integer getHedzws() {
		return hedzws;
	}

	public void setHedzws(Integer hedzws) {
		this.hedzws = hedzws;
	}

	public String getRanllxdm() {
		return ranllxdm;
	}

	public void setRanllxdm(String ranllxdm) {
		this.ranllxdm = ranllxdm == null ? null : ranllxdm.trim();
	}

	public String getCheljsdj() {
		return cheljsdj;
	}

	public void setCheljsdj(String cheljsdj) {
		this.cheljsdj = cheljsdj == null ? null : cheljsdj.trim();
	}

	public String getChucrq() {
		return chucrq;
	}

	public void setChucrq(String chucrq) {
		this.chucrq = chucrq == null ? null : chucrq.trim();
	}

	public String getGoucrq() {
		return goucrq;
	}

	public void setGoucrq(String goucrq) {
		this.goucrq = goucrq == null ? null : goucrq.trim();
	}

	public String getLuohrq() {
		return luohrq;
	}

	public void setLuohrq(String luohrq) {
		this.luohrq = luohrq == null ? null : luohrq.trim();
	}

	public Integer getZhouj() {
		return zhouj;
	}

	public void setZhouj(Integer zhouj) {
		this.zhouj = zhouj;
	}

	public Integer getChec() {
		return chec;
	}

	public void setChec(Integer chec) {
		this.chec = chec;
	}

	public Integer getCheg() {
		return cheg;
	}

	public void setCheg(Integer cheg) {
		this.cheg = cheg;
	}

	public Integer getChek() {
		return chek;
	}

	public void setChek(Integer chek) {
		this.chek = chek;
	}

	public Short getChezs() {
		return chezs;
	}

	public void setChezs(Short chezs) {
		this.chezs = chezs;
	}

	public Short getHouzgbthps() {
		return houzgbthps;
	}

	public void setHouzgbthps(Short houzgbthps) {
		this.houzgbthps = houzgbthps;
	}

	public String getXuanjxs() {
		return xuanjxs;
	}

	public void setXuanjxs(String xuanjxs) {
		this.xuanjxs = xuanjxs == null ? null : xuanjxs.trim();
	}

	public String getDangah() {
		return dangah;
	}

	public void setDangah(String dangah) {
		this.dangah = dangah == null ? null : dangah.trim();
	}

	public String getDaolyszzh() {
		return daolyszzh;
	}

	public void setDaolyszzh(String daolyszzh) {
		this.daolyszzh = daolyszzh == null ? null : daolyszzh.trim();
	}

	public String getZhengjjym() {
		return zhengjjym;
	}

	public void setZhengjjym(String zhengjjym) {
		this.zhengjjym = zhengjjym == null ? null : zhengjjym.trim();
	}

	public String getZhengjclrq() {
		return zhengjclrq;
	}

	public void setZhengjclrq(String zhengjclrq) {
		this.zhengjclrq = zhengjclrq == null ? null : zhengjclrq.trim();
	}

	public String getZhengjyxqq() {
		return zhengjyxqq;
	}

	public void setZhengjyxqq(String zhengjyxqq) {
		this.zhengjyxqq = zhengjyxqq == null ? null : zhengjyxqq.trim();
	}

	public String getZhengjyxqz() {
		return zhengjyxqz;
	}

	public void setZhengjyxqz(String zhengjyxqz) {
		this.zhengjyxqz = zhengjyxqz == null ? null : zhengjyxqz.trim();
	}

	public String getZhengjffrq() {
		return zhengjffrq;
	}

	public void setZhengjffrq(String zhengjffrq) {
		this.zhengjffrq = zhengjffrq == null ? null : zhengjffrq.trim();
	}

	public String getFazjg() {
		return fazjg;
	}

	public void setFazjg(String fazjg) {
		this.fazjg = fazjg == null ? null : fazjg.trim();
	}

	public String getChezzdcj() {
		return chezzdcj;
	}

	public void setChezzdcj(String chezzdcj) {
		this.chezzdcj = chezzdcj == null ? null : chezzdcj.trim();
	}

	public String getChezzdxh() {
		return chezzdxh;
	}

	public void setChezzdxh(String chezzdxh) {
		this.chezzdxh = chezzdxh == null ? null : chezzdxh.trim();
	}

	public String getChezzdbh() {
		return chezzdbh;
	}

	public void setChezzdbh(String chezzdbh) {
		this.chezzdbh = chezzdbh == null ? null : chezzdbh.trim();
	}

	public String getZhongdazrq() {
		return zhongdazrq;
	}

	public void setZhongdazrq(String zhongdazrq) {
		this.zhongdazrq = zhongdazrq == null ? null : zhongdazrq.trim();
	}

	public String getXingsjlyxh() {
		return xingsjlyxh;
	}

	public void setXingsjlyxh(String xingsjlyxh) {
		this.xingsjlyxh = xingsjlyxh == null ? null : xingsjlyxh.trim();
	}

	public String getXingsjlybh() {
		return xingsjlybh;
	}

	public void setXingsjlybh(String xingsjlybh) {
		this.xingsjlybh = xingsjlybh == null ? null : xingsjlybh.trim();
	}

	public String getYehid() {
		return yehid;
	}

	public void setYehid(String yehid) {
		this.yehid = yehid == null ? null : yehid.trim();
	}

	public String getGuanxjg() {
		return guanxjg;
	}

	public void setGuanxjg(String guanxjg) {
		this.guanxjg = guanxjg == null ? null : guanxjg.trim();
	}

	public String getJingxfwdm() {
		return jingxfwdm;
	}

	public void setJingxfwdm(String jingxfwdm) {
		this.jingxfwdm = jingxfwdm == null ? null : jingxfwdm.trim();
	}

	public String getJingxfwmc() {
		return jingxfwmc;
	}

	public void setJingxfwmc(String jingxfwmc) {
		this.jingxfwmc = jingxfwmc == null ? null : jingxfwmc.trim();
	}

	public String getXingzqhbm() {
		return xingzqhbm;
	}

	public void setXingzqhbm(String xingzqhbm) {
		this.xingzqhbm = xingzqhbm == null ? null : xingzqhbm.trim();
	}

	public String getLisqxdm() {
		return lisqxdm;
	}

	public void setLisqxdm(String lisqxdm) {
		this.lisqxdm = lisqxdm == null ? null : lisqxdm.trim();
	}

	public String getChuangjr() {
		return chuangjr;
	}

	public void setChuangjr(String chuangjr) {
		this.chuangjr = chuangjr == null ? null : chuangjr.trim();
	}

	public String getChuangjsj() {
		return chuangjsj;
	}

	public void setChuangjsj(String chuangjsj) {
		this.chuangjsj = chuangjsj == null ? null : chuangjsj.trim();
	}

	public String getXiugr() {
		return xiugr;
	}

	public void setXiugr(String xiugr) {
		this.xiugr = xiugr == null ? null : xiugr.trim();
	}

	public String getXiugsj() {
		return xiugsj;
	}

	public void setXiugsj(String xiugsj) {
		this.xiugsj = xiugsj == null ? null : xiugsj.trim();
	}

	public String getZhengjzt() {
		return zhengjzt;
	}

	public void setZhengjzt(String zhengjzt) {
		this.zhengjzt = zhengjzt == null ? null : zhengjzt.trim();
	}

	public String getYingyzt() {
		return yingyzt;
	}

	public void setYingyzt(String yingyzt) {
		this.yingyzt = yingyzt == null ? null : yingyzt.trim();
	}

	public String getBaoxid() {
		return baoxid;
	}

	public void setBaoxid(String baoxid) {
		this.baoxid = baoxid == null ? null : baoxid.trim();
	}

	public String getBeiz() {
		return beiz;
	}

	public void setBeiz(String beiz) {
		this.beiz = beiz == null ? null : beiz.trim();
	}

	public String getNiansyxrq() {
		return niansyxrq;
	}

	public void setNiansyxrq(String niansyxrq) {
		this.niansyxrq = niansyxrq == null ? null : niansyxrq.trim();
	}

	public String getErjwhyxrq() {
		return erjwhyxrq;
	}

	public void setErjwhyxrq(String erjwhyxrq) {
		this.erjwhyxrq = erjwhyxrq == null ? null : erjwhyxrq.trim();
	}

	public String getJisdjyxrq() {
		return jisdjyxrq;
	}

	public void setJisdjyxrq(String jisdjyxrq) {
		this.jisdjyxrq = jisdjyxrq == null ? null : jisdjyxrq.trim();
	}

	public Short getKecdj() {
		return kecdj;
	}

	public void setKecdj(Short kecdj) {
		this.kecdj = kecdj;
	}

	public String getKecdjyxrq() {
		return kecdjyxrq;
	}

	public void setKecdjyxrq(String kecdjyxrq) {
		this.kecdjyxrq = kecdjyxrq == null ? null : kecdjyxrq.trim();
	}

	public BigDecimal getHedzzl() {
		return hedzzl;
	}

	public void setHedzzl(BigDecimal hedzzl) {
		this.hedzzl = hedzzl;
	}

	public String getIckkh() {
		return ickkh;
	}

	public void setIckkh(String ickkh) {
		this.ickkh = ickkh == null ? null : ickkh.trim();
	}

	@Override
	public Object getId() {
		return this.chelid;
	}
}