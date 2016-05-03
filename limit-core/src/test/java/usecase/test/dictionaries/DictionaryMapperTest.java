package usecase.test.dictionaries;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.athena.module.dictionaries.mapper.DictionaryMapper;
import com.athena.module.dictionaries.model.DictionaryExample;

import usecase.base.BaseUsecase;

public class DictionaryMapperTest extends BaseUsecase {

	@Autowired
	private DictionaryMapper mapper;

	@Test
	public void execute() throws Exception {
		System.out.println(mapper.selectByExample(new DictionaryExample()));
	}

}
