package limit.module.area.dao;

import org.springframework.stereotype.Repository;

import limit.common.base.dao.AbstractDao;
import limit.module.area.model.Area;
import limit.module.area.model.AreaExam;

@Repository
public class AreaDaoImp extends AbstractDao<Area, AreaExam> implements AreaDao {
}
