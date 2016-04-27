package limit.common.base.service;

import java.util.List;

public interface Service<MODEL, EXAM> {

	int countByExample(EXAM exam);

	int deleteByExample(EXAM exam);

	int deleteByPrimaryKey(Long id);

	int insert(MODEL model);

	int insertSelective(MODEL model);

	List<MODEL> selectByExample(EXAM exam);

	MODEL selectByPrimaryKey(Long id);

	int updateByExampleSelective(MODEL model, EXAM exam);

	int updateByExample(MODEL model, EXAM exam);

	int updateByPrimaryKeySelective(MODEL model);

	int updateByPrimaryKey(MODEL model);

}
