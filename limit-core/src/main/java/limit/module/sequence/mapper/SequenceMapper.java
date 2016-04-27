package limit.module.sequence.mapper;

import org.apache.ibatis.annotations.Param;

public interface SequenceMapper {

	Long next(@Param("sequence") String sequence);

}
