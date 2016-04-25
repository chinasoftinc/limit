package apple.module.userOpt.service;

import org.springframework.stereotype.Service;

import apple.common.base.service.AbstractService;
import apple.module.userOpt.model.UserOpt;
import apple.module.userOpt.model.UserOptExam;

/**
 * 用户操作记录业务层实现类
 * @author niebx
 */
@Service
public class UserOptServiceImp extends AbstractService<UserOpt, UserOptExam> implements UserOptService {

	public String getEntityType() {
		return "用户操作记录";
	}

}
