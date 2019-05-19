package person.daizhongde.authority.spring.service;

import person.daizhongde.virtue.spring.BaseService;

public interface TAuthorityModuleService  extends BaseService {

	/**
	 * generate jsondata(array) for treegrid
	 * <br>attention: max level is ten
	 * <br>id,text,attributes
	 * <p><b>used by JEasyUI</b>
	 * @return
	 */
	public abstract String getData_JEasyUI_Treegrid();
	
	/**
	 * It may have Root or havn't
	 * <p>
	 * generate jsondata(array) for tree menu,
	 * <br>The state is defined in database;
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @return
	 */
	public abstract String getData_JEasyUI_Tree();
	
	/**
	 * generate jsondata(array) for menutree
	 * <br>The state is defined in database;
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param userid
	 * @param WithRoot
	 * @return
	 */
	public abstract String getData_JEasyUI_Tree( Integer moduleid, boolean WithRoot );

	/**
	 * It may have Root or havn't
	 * <p>
	 * generate jsondata(array) for asynchronous tree menu,
	 * <br>All fold node's state is closed;
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @return
	 */
	public abstract String getData_JEasyUI_Tree_Async();
	
	/**
	 * generate jsondata(array) for asynchronous menutree
	 * <br>All fold node's state is closed;
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param userid
	 * @param moduleid
	 * @return
	 */
	public abstract String getData_JEasyUI_Tree_Async( Integer moduleid, boolean WithRoot );
	
//	/**
//	 * generate jsondata(array) for menutree
//	 * <br>The state is defined in database;
//	 * <br>attention: max level is ten
//	 * <br>id,text,state,attributes
//	 * <p><b>used by JEasyUI</b>
//	 * @param moduleId
//	 * @param roleId
//	 * @return
//	 */
//	public abstract String getData_JEasyUI_CheckBoxTree( Integer moduleId, Integer roleId  );
	/**
	 * generate jsondata(array) for menutree
	 * <p>管理员用,区别于不带_ExceptDev的方法就是少了开发人员专用模块
	 * <p>开发人员专用模块ID:
	 * (98,9801,9802,9803,9804,9805,9806)
	 * <br>The state is defined in database;
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param moduleId
	 * @param roleId
	 * @return
	 */
	public abstract String getData_JEasyUI_CheckBoxTree_ExceptDev( Integer moduleId, Integer roleId  );
	
	/**
	 * It may have Root or havn't
	 * <p>
	 * generate jsondata(array) for combotree
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @return
	 */
	public abstract String getData_JEasyUI_CBT();
	
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
	 * It may have Root or havn't
	 * <p>
	 * generate jsondata(array) for combotree asynchronous
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @return
	 */
	public abstract String getData_JEasyUI_CBT_Async();
	
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
	 * generate jsondata(array) for drag and drop tree
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * <p>
	 * dnd(full):包括节点(机构)的所有属性
	 * @return
	 */
	public abstract String getData_JEasyUI_Dndtree();
	
	/**
	 * generate jsondata(array) for drag and drop tree
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @param userid
	 * @param moduleid
	 * @return
	 */
	public abstract String getData_JEasyUI_Dndtree( Integer moduleid, boolean WithRoot );
	/**
	 * Normally, dnd tree are not asynchronous tree
	 * <p>
	 * generate jsondata(array) for drag and drop tree
	 * <br>attention: max level is ten
	 * <br>id,text,state,attributes
	 * <p><b>used by JEasyUI</b>
	 * @return
	 */
	public abstract String getData_JEasyUI_Dndtree_Async();
	
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
	public abstract String getData_JEasyUI_Dndtree_Async( Integer moduleid, boolean WithRoot  );
	/**
	 * generate jsondata(array) for menutree
	 * <br>attention： max level is ten
	 * <br>id,text,url,iconSrc
	 * <p><b>used by fason,gubusoft,webfxtree,yui2,yui3,dojo</b>
	 * @return
	 */
	public abstract String getData_GubuSoft_Tree();

	/**
	 * query special user's menu tree 
	 * @param userId user id
	 * @return
	 */
	public abstract String getData_GubuSoft_Tree(Long userId);
	/**
	 * query special user's menu tree 
	 * @param userId user id
	 * @return
	 */
	public abstract String getData_GubuSoft_Tree(Long userId, String logname);
	
	/**
	 * Generate menuitem jsonarray for YUI2
	 * @return
	 */
	public abstract String getData_YUI2_Menu();
	/**
	 * Generate menubar jsonarray for YUI2
	 * @return
	 */
	public abstract String getData_YUI2_Menubar();
	
	/**
	 * generate jsondata(array) for menutree
	 * <br>no root node
	 * <br>attention： max level is ten
	 * <br>id,text,url,iconSrc
	 * <p><b>current only used by dojo</b>
	 * @return
	 */
	public abstract String getData_Dojo_Tree_NoRoot();
	
	/**
	 * generate jsondata(array) for menutree
	 * <br>no root node
	 * <br>attention： max level is ten
	 * <br>id,text,url,iconSrc
	 * <p><b>current only used by dojo</b>
	 *  
	 * 
	 * @return only node's children
	 */
	public abstract String getData_Dojo_Tree_Async( Integer moduleid );
	/**
	 * generate jsondata(object) for menutree
	 * <br>no root node
	 * <br>attention： max level is ten
	 * <br>id,text,url,iconSrc
	 * <p><b>current only used by dojo</b>
	 * @return node and node's children
	 */
	public abstract String getData_Dojo_Tree_LazyNode( Integer moduleid);
	
	/**
	 * generate jsondata(Object) for menutree
	 * attention： max level is ten
	 * id,text,url,iconSrc
	 * <p><b>used by ext3</b>
	 * @return node and node's children
	 */
	public abstract String getData_Ext3_Tree();
	/**
	 * generate jsondata(Object) for menutree
	 * attention： max level is ten
	 * id,text,url,iconSrc
	 * <p><b>used by ext3</b>
	 * @return node and node's children
	 */
	public abstract String getData_Ext3_Tree_Async(Integer moduleid );
	
	/**
	 * generate jsondata(array) for menutree
	 * <br>attention： max level is ten
	 * <br>id,text,url,iconSrc
	 * <p><b>used by ext4</b>
	 * @return
	 */
	public abstract String getData_Ext4_Tree();
	
	/**
	 * generate jsondata InMap for combobox
	 * <br>getCBBData_XXX  XXX: field name
	 * <p><b>used by jquery-easy-ui</b>
	 * @return json
	 */
	public abstract String getCBBData_Parent(String jdata);
	/**
	 * generate array for combobox  
	 * <br>getCBBData_XXX  XXX: field name
	 * <p><b>used by jquery-easy-ui</b>
	 * @return array
	 */
	public abstract String getCBBDataInArray_Parent(String jdata);

	/** Remove 非空目录或叶子节点  **/
	public abstract void remove( int id ) throws Exception;
	/** Remove a node and it's children nodes  **/
	public abstract void removeRecursive( int id );
	
	/**
	 * drag and drop tree node 
	 * @param target
	 * @param source
	 * @param point 'append','top' or 'bottom'.
	 * @return
	 * @throws Exception 
	 */
	public abstract void dndNode( int target, int source, String point ) throws Exception;

}