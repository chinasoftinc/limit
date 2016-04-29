package com.athena.module.area.dao;

import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.area.model.Area;
import com.athena.module.area.model.AreaExam;

@Repository
public class AreaDaoImp extends AbstractDao<Area, AreaExam> implements AreaDao {
}
