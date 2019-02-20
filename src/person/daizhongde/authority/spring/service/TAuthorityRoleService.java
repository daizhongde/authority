package person.daizhongde.authority.spring.service;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityRole;

import person.daizhongde.virtue.spring.BaseService;

public interface TAuthorityRoleService extends BaseService{
	
	/**
	 * Find Roles by UserId
	 * @param userId
	 * @return
	 */
	public abstract List<TAuthorityRole> findRoleByUserId(Integer userId );
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
	 * It may have Root or havn't
	 * <p>
	 * generate jsondata(array) for role tree,
	 * <br>The state is defined in database;
	 * <br>attention: only two level
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @return
	 */
	public abstract String getData_JEasyUI_Tree();
	/**
	 * It may have Root or havn't
	 * <p>管理员用,区别于query_JEasyUI_Tree就是少了开发人员角色
	 * <p>
	 * generate jsondata(array) for role tree,
	 * <br>The state is defined in database;
	 * <br>attention: only two level
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @return
	 */
	public abstract String getData_JEasyUI_Tree_ExceptDev();
//	public abstract String getData_JEasyUI_Tree_ExceptDev( Short userRLevel);
	
	/**
	 * generate jsondata(array) for menutree
	 * <br>The state is defined in database;
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param userId
	 * @return
	 */
	public abstract String getData_JEasyUI_CheckBoxTree( Integer userId  );
	/**
	 * role checkbox tree except developer role
	 * @param userId
	 * @return
	 */
	public abstract String getData_JEasyUI_CheckBoxTree_ExceptDev( Integer userId  );
}