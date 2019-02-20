package person.daizhongde.authority.spring.service;

import person.daizhongde.virtue.spring.BaseService;

public interface TAuthorityInstService extends BaseService{
	
	/**
	 * generate jsondata(array) for instTree
	 * <br>The state is defined in database;
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param userid
	 * @param moduleid
	 * @param WithRoot
	 * @return
	 */
	public abstract String getData_JEasyUI_Tree( Integer moduleid, boolean WithRoot );

	
	/**
	 * generate jsondata(array) for asynchronous instTree
	 * <br>All fold node's state is closed;
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param userid
	 * @param moduleid
	 * @return
	 */
	public abstract String getData_JEasyUI_Tree_Async( Integer moduleid, boolean WithRoot );
	
	/**
	 * generate jsondata(array) for combotree
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param userid
	 * @param moduleid
	 * @return
	 */
	public abstract String getData_JEasyUI_CBT( Integer moduleid, boolean WithRoot );
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
	
	/**
	 * generate jsondata(array) for combotree
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * <p>
	 * 查询头三级的所有数据(第四级异步加载)
	 * <br>如果传入了节点参数-从参数对应的节点开始算,它本身算一级
	 * <br>加载一级_L1(只加载节点本身，等于没有加载)
	 * <br>异步算_L2(只加载它的直接子节点)
	 * @param userid
	 * @param moduleid
	 * @return
	 */
	public abstract String getData_JEasyUI_CBT_L3( Integer moduleid, boolean WithRoot );
	
	/**
	 * generate jsondata(array) for drag and drop tree
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * <p>
	 * full:包括节点(机构)的所有属性
	 * @param userid
	 * @param moduleid
	 * @return
	 */
	public abstract String getData_JEasyUI_FullTree( Integer moduleid, boolean WithRoot );
	/**
	 * Normally, dnd tree are not asynchronous tree
	 * <p>
	 * generate jsondata(array) for drag and drop tree
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param userid
	 * @param moduleid
	 * @return
	 */
	public abstract String getData_JEasyUI_FullTree_Async( Integer moduleid, boolean WithRoot  );
	
	
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
}