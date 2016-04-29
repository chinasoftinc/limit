package usecase.test.sequence;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.athena.module.sequence.mapper.SequenceMapper;

import usecase.base.BaseUsecase;

public class SequenceMapperTest extends BaseUsecase {

	@Autowired
	private SequenceMapper mapper;

	@Test
	public void execute() throws Exception {
		System.out.println(mapper.next("user_sequence"));
	}

}
