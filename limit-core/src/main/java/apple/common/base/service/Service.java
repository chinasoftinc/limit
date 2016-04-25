package apple.common.base.service;

import java.util.List;

public interface Service<MODEL, EXAM> {

	/**
	 * 根据条件查询记录数量
	 * @param example
	 * @return
	 */
	int countByExample(EXAM exam);

	/**
	 * 说明:　根据条件删除实体
	 * @param example
	 * @return 删除的记录数
	 */
	int deleteByExample(EXAM exam);

	/**
	 * 说明:　根据主键删除实体
	 * @param id
	 * @return 删除的记录数
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 说明:　插入实体
	 * @param record
	 * @return 插入的记录数
	 */
	int insert(MODEL model);

	/**
	 * 说明:　插入实体 [空字段不插入]
	 * @param record
	 * @return 插入的记录数
	 */
	int insertSelective(MODEL model);

	/**
	 * 说明:　根据条件查询实体集合
	 * @param example
	 * @return 查询结果对象集合
	 */
	List<MODEL> selectByExample(EXAM exam);

	/**
	 * 说明:　根据主键查询实体
	 * @param id
	 * @return 查询结果对象
	 */
	MODEL selectByPrimaryKey(Long id);

	/**
	 * 说明:　根据条件更新符合条件的实体 [空字段不更新]
	 * @param record
	 * @param example
	 * @return 更新的记录数
	 */
	int updateByExampleSelective(MODEL model, EXAM exam);

	/**
	 * 说明:　根据条件更新符合条件的实体
	 * @param record
	 * @param example
	 * @return 更新的记录数
	 */
	int updateByExample(MODEL model, EXAM exam);

	/**
	 * 说明:　根据主键更新指定主键的实体 [空字段不更新]
	 * @param record
	 * @return 更新的记录数
	 */
	int updateByPrimaryKeySelective(MODEL model);

	/**
	 * 说明:　根据主键更新指定主键的实体
	 * @param record
	 * @return 更新的记录数
	 */
	int updateByPrimaryKey(MODEL model);

}
