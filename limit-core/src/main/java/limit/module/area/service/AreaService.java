package limit.module.area.service;

import java.util.List;

import limit.common.base.service.Service;
import limit.common.dto.EasyUITreeNode;
import limit.module.area.model.Area;
import limit.module.area.model.AreaExam;

/**
 * 地区Service
 * @author Binxiao
 */
public interface AreaService extends Service<Area, AreaExam> {

	/**
	 * 获取地区树结构 [eaysuiTreeNode]
	 * @param parentId
	 * @param level
	 * @return
	 */
	List<EasyUITreeNode> selectAreaTree(Long parentareaid);

	/**
	 * 删除多个地区, 级联子地区
	 * @param areaidList
	 */
	void deleteMultiArea(List<Long> areaidList);

	/**
	 * 根据parentareaid获取子地区树结构 [eaysuiTreeNode]
	 * @param parentAreaId
	 * @param areaName
	 * @return
	 */
	List<EasyUITreeNode> selectAreaChildTree(Long parentAreaId, String areaName);

}
