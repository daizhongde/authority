package person.daizhongde.authority.spring.service;

import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;

import person.daizhongde.virtue.spring.BaseService;

public interface TAuthorityUserService extends BaseService{
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
	 * generate jsondata(array) for combotree asynchronous
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param userid
	 * @param moduleid
	 * @return
	 */
	public abstract String getData_JEasyUI_CBT_Async( Integer moduleid, boolean WithRoot );
	
	
	/** U  **/
	public abstract int modifyPWD( String jdata ) throws Exception;
	
	public abstract TAuthorityUser findById( int id );
	public abstract TAuthorityUser findByLogname( String logname );
	public abstract long getOnlineCount();
	
	public abstract void updateLogState( String state, Integer N_UID, String ip );
}