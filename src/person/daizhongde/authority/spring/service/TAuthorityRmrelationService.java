package person.daizhongde.authority.spring.service;

import java.util.List;

import person.daizhongde.virtue.spring.BaseService;

public interface TAuthorityRmrelationService extends BaseService{
	/**
	 * generate jsondata InMap for combobox
	 * <br>getCBBData_XXX  XXX: field name
	 * <p><b>used by jquery-easy-ui</b>
	 * @return json
	 */
	public abstract String getCBBData_Id(String jdata);
	/**
	 * generate array for combobox  
	 * <br>getCBBData_XXX  XXX: field name
	 * <p><b>used by jquery-easy-ui</b>
	 * @return array
	 */
	public abstract String getCBBDataInArray_Id(String jdata);
	
	/**
	 * @deprecated
	 * @param moduleId
	 * @param userId
	 * @return
	 */
	public abstract List findUserButton4tb(Integer moduleId, Long userId  );
}