package person.daizhongde.authority.spring.service;

import java.util.List;
import java.util.Map;

import person.daizhongde.virtue.spring.BaseService;

public interface TAuthorityRbrelationService extends BaseService{
	/**
	 * 
	 * @param moduleId
	 * @param userId
	 * @return 返回值是纵向的值，和db的记录结构一致
	 */
	public abstract List findUserButton4tb(Integer moduleId, Integer userId  );
	/**
	 * 
	 * @param moduleId
	 * @param userId
	 * @return 返回值是横向的值，和使用rmrel实现按钮权限的数据结构一致
	 */
	public abstract Map findUserButton4tb2(Integer moduleId, Integer userId  );
}