package apple.common.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author NieBinxiao
 * @param <MODEL>
 * @param <EXAM>
 */
public interface Mapper<MODEL, EXAM> {

	/**
	 * 查询指定条件记录数
	 * @param example
	 * @return
	 */
	int countByExample(EXAM example);

	/**
	 * 删除指定条件记录
	 * @param example
	 * @return
	 */
	int deleteByExample(EXAM example);

	/**
	 * 删除指定primaryKey字段记录
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 插入记录
	 * @param record
	 * @return
	 */
	int insert(MODEL record);

	/**
	 * 插入记录, 不插入NULL值的字段
	 * @param record
	 * @return
	 */
	int insertSelective(MODEL record);

	/**
	 * 查询指定条件的记录
	 * @param example
	 * @return
	 */
	List<MODEL> selectByExample(EXAM example);

	/**
	 * 查询指定PrimaryKey记录
	 * @param id
	 * @return
	 */
	MODEL selectByPrimaryKey(Long id);

	/**
	 * 更新指定条件的记录, 不更新空值参数的字段
	 * @param record [更新]
	 * @param example [条件]
	 * @return
	 */
	int updateByExampleSelective(@Param("record") MODEL record, @Param("example") EXAM example);

	/**
	 * 更新指定条件的记录
	 * @param record [更新]
	 * @param example [条件]
	 * @return
	 */
	int updateByExample(@Param("record") MODEL record, @Param("example") EXAM example);

	/**
	 * 更新指定PrimaryKey记录, 不更新空值参数的字段
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(MODEL record);

	/**
	 * 更新指定PrimaryKey的记录
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(MODEL record);

}
