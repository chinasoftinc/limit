package limit.common.base.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import limit.common.base.mapper.Mapper;

/**
 * @author niebinxiao
 * @param <MODEL> model类型
 * @param <EXAM> 查询器类型
 */
public abstract class AbstractDao<MODEL, EXAM> implements Dao<MODEL, EXAM> {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Mapper<MODEL, EXAM> mapper;

	public int countByExample(EXAM example) {
		return mapper.countByExample(example);
	}

	public int deleteByExample(EXAM example) {
		return mapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int insert(MODEL record) {
		return mapper.insert(record);
	}

	public int insertSelective(MODEL record) {
		return mapper.insertSelective(record);
	}

	public List<MODEL> selectByExample(EXAM example) {
		return mapper.selectByExample(example);
	}

	public MODEL selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(MODEL record, EXAM example) {
		return mapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(MODEL record, EXAM example) {
		return mapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(MODEL record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MODEL record) {
		return mapper.updateByPrimaryKey(record);
	}

}