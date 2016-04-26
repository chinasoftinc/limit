package limit.module.area.model;

import limit.common.base.entity.PageModel;

/**
 * 地区model
 * @author niebx
 */
public class Area extends PageModel<Area> {
	private static final long serialVersionUID = 864258146403639343L;

	private Long areaid;
	// 地区名称
	private String areaname;
	// 上级地区ID
	private Long parentareaid;
	// 地区层级
	private Integer arealevel;

	public Long getId() {
		return areaid;
	}

	public Long getAreaid() {
		return areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname == null ? null : areaname.trim();
	}

	public Long getParentareaid() {
		return parentareaid;
	}

	public void setParentareaid(Long parentareaid) {
		this.parentareaid = parentareaid;
	}

	public Integer getArealevel() {
		return arealevel;
	}

	public void setArealevel(Integer arealevel) {
		this.arealevel = arealevel;
	}

}