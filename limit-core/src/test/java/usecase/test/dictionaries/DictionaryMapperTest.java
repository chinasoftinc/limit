package usecase.test.dictionaries;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.athena.module.dictionaries.mapper.DictionaryMapper;

import usecase.base.BaseUsecase;

public class DictionaryMapperTest extends BaseUsecase {

	@Autowired
	private DictionaryMapper mapper;

	@Test
	public void execute() throws Exception {
		// System.out.println(mapper.selectByExample(new DictionaryExample()));
		System.out.println(mapper.selectMaxSortNo(new BigDecimal(1)));
	}

}
