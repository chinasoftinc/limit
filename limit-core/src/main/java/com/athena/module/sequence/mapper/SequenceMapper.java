package com.athena.module.sequence.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

public interface SequenceMapper {

	BigDecimal next(@Param("sequence") String sequence);

}
