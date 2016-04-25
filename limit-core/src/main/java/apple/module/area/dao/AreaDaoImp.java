package apple.module.area.dao;

import org.springframework.stereotype.Repository;

import apple.common.base.dao.AbstractDao;
import apple.module.area.model.Area;
import apple.module.area.model.AreaExam;

@Repository
public class AreaDaoImp extends AbstractDao<Area, AreaExam> implements AreaDao {
}
