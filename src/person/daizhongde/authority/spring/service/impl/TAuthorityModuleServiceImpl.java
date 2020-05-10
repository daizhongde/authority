package person.daizhongde.authority.spring.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.constant.AuthorityModule;
import person.daizhongde.authority.hibernate.dao.TAuthorityModuleDAO;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_CBT;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_Tree;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_Ext_Tree;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_GubuSoft_Tree;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_YUI2_Menu;
import person.daizhongde.authority.spring.service.TAuthorityModuleService;
import person.daizhongde.authority.util.TreeDataUtil_Module;

import person.daizhongde.virtue.assemble.hql.HQLAssembleQ;
import person.daizhongde.virtue.assemble.hql.HQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleC;
import person.daizhongde.virtue.assemble.sql.SQLAssembleD;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ_CBB;
import person.daizhongde.virtue.assemble.sql.SQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleU;
import person.daizhongde.virtue.configutils.SQLNode;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.constant.Algorithm;
import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.constant.Operator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * seven levels total include root. 
 * This is a compromise 
 * You can modify this class to extend for more levels.
 * gubusoft treeview use
 * @author dzd
 *
 */
public class TAuthorityModuleServiceImpl implements TAuthorityModuleService {
	private static final Log log = LogFactory.getLog(TAuthorityModuleServiceImpl.class);
	
	private TAuthorityModuleDAO dataDAO;
	private TreeDataUtil_Module mdUtil = new TreeDataUtil_Module();
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_Treegrid(){
//		log.debug("service.......getData_JEasyUI_Treegrid...........");
		
		List dataList = new ArrayList();//use to save Treegrid JSON data
		List<TAuthorityModule> mList = dataDAO.findAll();
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level = 0;
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
			
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
//		System.out.println("root module name:"+level0ModuleList.get(0).getCMname());
//		System.out.println("level1 module count:"+level1ModuleList.size());
//		System.out.println("level2 module count:"+level2ModuleList.size());
//		System.out.println("level3 module count:"+level3ModuleList.size());
//		System.out.println("level4 module count:"+level4ModuleList.size());
//		System.out.println("level5 module count:"+level5ModuleList.size());
//		System.out.println("level6 module count:"+level6ModuleList.size());
//		System.out.println("level7 module count:"+level7ModuleList.size());
//		System.out.println("level8 module count:"+level8ModuleList.size());
//		System.out.println("level9 module count:"+level9ModuleList.size());
//		System.out.println("level10 module count:"+level10ModuleList.size());
		
		mdUtil.assembleData_JEasyUI_Treegrid(dataList, (TAuthorityModule)level0ModuleList.get(0), 1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);

		JSONArray jsonArray = JSONArray.fromObject(dataList);
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_Tree(){
//		log.debug("service....AllNode...getData_JEasyUI_Tree...........");
		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
//		List dataList2 = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findAllWithOrder();
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}

		if( level0ModuleList.size()== 0 ){
			return "[]";
		}
		
		for(int i=0, j=level0ModuleList.size(); i<j; i++ )
		{
			List dataList2 = new ArrayList();
			/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
			mdUtil.assembleData_JEasyUI_Tree(dataList2, (TAuthorityModule)level0ModuleList.get(i), 1,	
					level1ModuleList,	level2ModuleList,
					level3ModuleList,	level4ModuleList,
					level5ModuleList,	level6ModuleList,
					level7ModuleList,	level8ModuleList,
					level9ModuleList,	level10ModuleList);
			dataList.add(dataList2);
		}

		/*这里是有且仅有一个root节点的情况
		 * 
		 * TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("url", rootModule.getCMpath());
		
		TAuthorityModule_JEasyUI_Tree mJEU = new TAuthorityModule_JEasyUI_Tree();
		mJEU.setId(rootModule.getNMid());
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		mJEU.setAttributes(attr1);
		mJEU.setChildren(dataList2);*/

		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_Tree( Integer moduleid, boolean WithRoot ){
		if(WithRoot)
		{
			return getData_JEasyUI_TreeWithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_TreeNoRoot(moduleid);
		}
	}

	public String getData_JEasyUI_TreeWithRoot( Integer moduleid )
	{

		List<TAuthorityModule> mList = dataDAO.findChildrenRecursive(moduleid);

		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleid);

		return getData_JEasyUI_TreeWithRoot( rootModule, mList );
	}
	
	public String getData_JEasyUI_CheckBoxTree( Integer moduleId, Integer roleId )
	{

		AbstractConstant absConstant = new AuthorityModule();
		Map map = new HashMap();
		map.put( "moduleId", moduleId );
		map.put( "roleId", roleId );
		
		String queryString = ((SQLNode)absConstant.getSQLDOC()
					.getTree().get("tree_CheckBoxTree")
				).getSQL();
		
		List<TAuthorityModule> mList = dataDAO.sqlQuerylistAllByMap( queryString, map, TAuthorityModule.class );
		

		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleId);

		return getData_JEasyUI_TreeWithRoot( rootModule, mList );
	}
	public String getData_JEasyUI_CheckBoxTree_ExceptDev( Integer moduleId, Integer roleId )
	{
		if(roleId==0)
		{
			List<TAuthorityModule> mList = dataDAO.findChildrenRecursive_ExceptDev(moduleId);

			TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleId);

			return getData_JEasyUI_TreeWithRoot( rootModule, mList );
		}
		else
		{
			AbstractConstant absConstant = new AuthorityModule();
			Map map = new HashMap();
			map.put( "moduleId", moduleId );
			map.put( "roleId", roleId );
			
			String queryString = ((SQLNode)absConstant.getSQLDOC()
						.getTree().get("tree_CheckBoxTree_ExceptDev")
					).getSQL();
			
			List<TAuthorityModule> mList = dataDAO.sqlQuerylistAllByMap( queryString, map, TAuthorityModule.class );
			
			TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleId);

			return getData_JEasyUI_TreeWithRoot( rootModule, mList );
		}
	}
	
	public String getData_JEasyUI_TreeWithRoot( TAuthorityModule rootModule, List<TAuthorityModule>  mList )
	{
//		log.debug("service....AllNode...getData_JEasyUI_Tree...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
		List dataList2 = new ArrayList();//Root's children
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}

		//If moduleid's corresponding module is not exist
		if( mList.size()== 0 ){
			return "[]";
		}
				
		//algorithm is waiting for improve
//		MenuDataUtil mdUtil = new MenuDataUtil();
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_Tree(dataList2, rootModule, rootModule.getNMlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("url", rootModule.getCMpath());
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();
		mJEU.setId(rootModule.getNMid());
		mJEU.setText(rootModule.getCMname());
		mJEU.setIconCls(rootModule.getCMiconcls());
		mJEU.setChecked( new Boolean( rootModule.getCMchecked() ).booleanValue() );
		
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		
		mJEU.setAttributes(attr1);
		mJEU.setChildren(dataList2);

		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	/**
	 * Usually, It would not use this method
	 * @param moduleid
	 * @return
	 */
	public String getData_JEasyUI_TreeNoRoot( Integer moduleid )
	{
//		log.debug("service....AllNode...getData_JEasyUI_Tree...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
		List dataList2 = new ArrayList();//Root's children
		@SuppressWarnings({"unchecked" })
		List<TAuthorityModule> mList = dataDAO.findChildrenRecursive( moduleid );
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
		//This node haven't children
		if( mList.size()== 1 ){
			return "[]";
		}
		
		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleid);
		
		//algorithm is waiting for improve
//		MenuDataUtil mdUtil = new MenuDataUtil();
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_Tree(dataList2, rootModule, rootModule.getNMlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);

		JSONArray jsonArray = JSONArray.fromObject(dataList2);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_Tree_Async(){
//		log.debug("service....All node's state is close...getData_JEasyUI_Tree_Async...........");

		List dataList = new ArrayList();//module's children(Front Type )
		
		List<TAuthorityModule> level0ModuleList = dataDAO.findByNMlevel( new Short("0") );
		log.debug("level0ModuleList.size():"+level0ModuleList.size());
		
		if( level0ModuleList.size()== 0 ){
			return "[]";
		}
		
		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		
		List moduleList = dataDAO.findChildrenNoRecursive( rootModule.getNMid() );//module's children(POJO)
		log.debug("Children.size():"+moduleList.size());
		mdUtil.assembleData_JEasyUI_Tree_Async( dataList, moduleList );
				
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("url", rootModule.getCMpath());
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();
		mJEU.setId(rootModule.getNMid());
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		mJEU.setAttributes(attr1);
		mJEU.setChildren(dataList);

		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	public String getData_JEasyUI_Tree_Async( Integer moduleid, boolean WithRoot ){
		if(WithRoot)
		{
			return getData_JEasyUI_Tree_AsyncWithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_Tree_AsyncNoRoot(moduleid);
		}
	}
	
	public String getData_JEasyUI_Tree_AsyncWithRoot(Integer moduleid){
//		log.debug("service....All node's state is close...getData_JEasyUI_Tree_Async...........");

		List dataList = new ArrayList();//module's children(Front Type )
		
		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleid);
		
		List moduleList = dataDAO.findChildrenNoRecursive( rootModule.getNMid() );//module's children(POJO)
		log.debug("Children.size():"+moduleList.size());
		mdUtil.assembleData_JEasyUI_Tree_Async( dataList, moduleList );
				
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("url", rootModule.getCMpath());
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();
		mJEU.setId(rootModule.getNMid());
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		mJEU.setAttributes(attr1);
		mJEU.setChildren(dataList);

		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	public String getData_JEasyUI_Tree_AsyncNoRoot( Integer moduleid ){
//		log.debug("service....lazyload, Async tree...getData_JEasyUI_Tree_Async...........");
		List dataList = new ArrayList();//Root's children
		
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children
//		System.out.println("total module count:"+dataList.size());
		
//		log.debug("mList.size():"+dataList.size());
		
		mdUtil.assembleData_JEasyUI_Tree_Async( dataList, moduleList );
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());		
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_CBT(){
//		log.debug("service....AllNode...getData_JEasyUI_CBT...........");
		List dataList = new ArrayList();//use to save menu JSON data if it has root node
//		List dataList2 = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findAllWithOrder();
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
		
		if( level0ModuleList.size()== 0 ){
			return "[]";
		}
		
		for(int i=0, j=level0ModuleList.size(); i<j; i++ )
		{
			List dataList2 = new ArrayList();
			/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
			mdUtil.assembleData_JEasyUI_CBT(dataList2, (TAuthorityModule)level0ModuleList.get(i), 1,	
					level1ModuleList,	level2ModuleList,
					level3ModuleList,	level4ModuleList,
					level5ModuleList,	level6ModuleList,
					level7ModuleList,	level8ModuleList,
					level9ModuleList,	level10ModuleList);
			dataList.add(dataList2);
		}
		
		/*这里是有且仅有一个root节点的情况
		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		TAuthorityModule_JEasyUI_CBT mJEU = new TAuthorityModule_JEasyUI_CBT();
		mJEU.setId(rootModule.getNMid());
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		mJEU.setChildren(dataList2);*/
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_CBT( Integer moduleid, boolean WithRoot ){
		if(WithRoot)
		{
			return getData_JEasyUI_CBTWithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_CBTNoRoot(moduleid);
		}
	}
	
	
	public String getData_JEasyUI_CBTWithRoot( Integer moduleid ){
//		log.debug("service....AllNode...getData_JEasyUI_CBTWithRoot...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node
		List dataList2 = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findChildrenRecursive( moduleid );
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
		//If moduleid's corresponding module is not exist
		if( mList.size()== 0 ){
			return "[]";
		}
		
//		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleid);
		
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_CBT(dataList2, rootModule, rootModule.getNMlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		JEasyUI_CBT mJEU = new JEasyUI_CBT();
		mJEU.setId(new Long(rootModule.getNMid()));
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		mJEU.setChildren(dataList2);
		
		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	/**
	 * Usually, It would not use this method
	 * @param moduleid
	 * @return
	 */
	public String getData_JEasyUI_CBTNoRoot( Integer moduleid ) {
//		log.debug("service....AllNode...getData_JEasyUI_CBTNoRoot...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node
		List dataList2 = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findChildrenRecursive( moduleid );
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
		
		//This node haven't children
		if( mList.size()== 1 ){
			return "[]";
		}
		
		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleid);
		
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_CBT(dataList2, rootModule, rootModule.getNMlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		JSONArray jsonArray = JSONArray.fromObject(dataList2);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_CBT_Async(){
//		log.debug("service....AllNode...getData_JEasyUI_CBT_Async...........");
		List dataList = new ArrayList();//module's children(Front Type )
		
		List<TAuthorityModule> level0ModuleList = dataDAO.findByNMlevel( new Short("0") );
		log.debug("level0ModuleList.size():"+level0ModuleList.size());
		
		if( level0ModuleList.size()== 0 ){
			return "[]";
		}
		
		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		
		List moduleList = dataDAO.findChildrenNoRecursive( rootModule.getNMid() );//module's children(POJO)
		log.debug("Children.size():"+moduleList.size());
		mdUtil.assembleData_JEasyUI_CBT_Async( dataList, moduleList );
				
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("url", rootModule.getCMpath());
		
		JEasyUI_CBT mJEU = new JEasyUI_CBT();
		mJEU.setId(new Long(rootModule.getNMid()));
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		mJEU.setChildren(dataList);

		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_CBT_Async( Integer moduleid, boolean WithRoot ){
		if(WithRoot)
		{
			return getData_JEasyUI_CBT_AsyncWithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_CBT_AsyncNoRoot(moduleid);
		}
	}
	
	
	public String getData_JEasyUI_CBT_AsyncWithRoot( Integer moduleid ){
//		log.debug("service....getData_JEasyUI_CBT_AsyncWithRoot...........");
		List dataList = new ArrayList();//Root's children

		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleid);
		
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children(POJO)
		log.debug("Children.size():"+moduleList.size());
		
		mdUtil.assembleData_JEasyUI_CBT_Async( dataList, moduleList );
		
		JEasyUI_CBT mJEU = new JEasyUI_CBT();
		mJEU.setId(new Long(rootModule.getNMid()));
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		mJEU.setChildren(dataList);
		
		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());		
		return jsonArray.toString();
	}
	
	/**
	 * Usually, It would not use this method
	 * @param moduleid
	 * @return
	 */
	public String getData_JEasyUI_CBT_AsyncNoRoot( Integer moduleid ) {
//		log.debug("service....getData_JEasyUI_CBT_AsyncNoRoot...........");
		List dataList = new ArrayList();//Root's children
		
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children
//		System.out.println("total module count:"+dataList.size());
		
//		log.debug("mList.size():"+dataList.size());
		
		mdUtil.assembleData_JEasyUI_CBT_Async( dataList, moduleList );
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());		
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_Dndtree(){
		log.debug("service....AllNode..getData_JEasyUI_Dndtree...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node
		List dataList2 = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findAllWithOrder();
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
		
		if( level0ModuleList.size() == 0 ){
			return "[]";
		}
//		MenuDataUtil mdUtil = new MenuDataUtil();
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_Dndtree(dataList2, (TAuthorityModule)level0ModuleList.get(0), 1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("leaf", rootModule.getCMleaf());
		attr1.put("level", rootModule.getNMlevel());
		attr1.put("parent", rootModule.getNMparent());
		attr1.put("order", rootModule.getNMorder());
		attr1.put("iconcls", rootModule.getCMiconcls());
		attr1.put("expanded", rootModule.getCMexpanded());
		attr1.put("checked", rootModule.getCMchecked());
		attr1.put("url", rootModule.getCMpath());
		attr1.put("note", rootModule.getCMnote());
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();
		mJEU.setId(rootModule.getNMid());
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		mJEU.setAttributes(attr1);
		mJEU.setChildren(dataList2);
		
		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_Dndtree( Integer moduleid, boolean WithRoot )
	{
		if(WithRoot)
		{
			return getData_JEasyUI_DndtreeWithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_DndtreeNoRoot(moduleid);
		}
	}
	
	public String getData_JEasyUI_DndtreeWithRoot( Integer moduleid )
	{
		log.debug("service....getData_JEasyUI_DndtreeWithRoot ###########DND###########...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
		List dataList2 = new ArrayList();//Root's children
				
		List<TAuthorityModule> mList = dataDAO.findChildrenRecursive( moduleid );
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
		//If moduleid's corresponding module is not exist
		if( mList.size()== 0 ){
			return "[]";
		}
		
//		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleid);
		
		//algorithm is waiting for improve
//		MenuDataUtil mdUtil = new MenuDataUtil();
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_Dndtree(dataList2, rootModule, rootModule.getNMlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("url", rootModule.getCMpath());
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();
		mJEU.setId(rootModule.getNMid());
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		
		attr1.put("leaf", rootModule.getCMleaf());
		attr1.put("level", rootModule.getNMlevel());
		attr1.put("parent", rootModule.getNMparent());
//		attr1.put("parent", rootModule.getNMparent().getNMid());
		attr1.put("order", rootModule.getNMorder());
		attr1.put("iconcls", rootModule.getCMiconcls());
		attr1.put("expanded", rootModule.getCMexpanded());
		attr1.put("checked", rootModule.getCMchecked());
		attr1.put("url", rootModule.getCMpath());
		attr1.put("note", rootModule.getCMnote());
		
		mJEU.setAttributes(attr1);
		mJEU.setChildren(dataList2);

		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	/**
	 * Usually, It would not use this method
	 * @param moduleid
	 * @return
	 */
	public String getData_JEasyUI_DndtreeNoRoot( Integer moduleid )
	{
		log.debug("service....getData_JEasyUI_DndtreeNoRoot...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
		List dataList2 = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findChildrenRecursive( moduleid );
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
		//This node haven't children
		if( mList.size()== 1 ){
			return "[]";
		}
		
		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleid);
		//algorithm is waiting for improve
//		MenuDataUtil mdUtil = new MenuDataUtil();
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_Dndtree(dataList2, rootModule, rootModule.getNMlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);

		JSONArray jsonArray = JSONArray.fromObject(dataList2);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_Dndtree_Async(){
//		log.debug("service....All node's state is close...getData_JEasyUI_Tree_Async...........");

		List dataList = new ArrayList();//module's children(Front Type )
		
		List<TAuthorityModule> level0ModuleList = dataDAO.findByNMlevel( new Short("0") );
		log.debug("level0ModuleList.size():"+level0ModuleList.size());
		
		if( level0ModuleList.size()== 0 ){
			return "[]";
		}
		
		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		
		List moduleList = dataDAO.findChildrenNoRecursive( rootModule.getNMid() );//module's children(POJO)
		log.debug("Children.size():"+moduleList.size());
		mdUtil.assembleData_JEasyUI_Dndtree_Async( dataList, moduleList );
				
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("url", rootModule.getCMpath());
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();
		mJEU.setId(rootModule.getNMid());
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		
		attr1.put("leaf", rootModule.getCMleaf());
		attr1.put("level", rootModule.getNMlevel());
		attr1.put("parent", rootModule.getNMparent());
//		attr1.put("parent", rootModule.getNMparent().getNMid());
		attr1.put("order", rootModule.getNMorder());
		attr1.put("iconcls", rootModule.getCMiconcls());
		attr1.put("expanded", rootModule.getCMexpanded());
		attr1.put("checked", rootModule.getCMchecked());
		attr1.put("url", rootModule.getCMpath());
		attr1.put("note", rootModule.getCMnote());
		
		mJEU.setAttributes(attr1);
		mJEU.setChildren(dataList);

		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	public String getData_JEasyUI_Dndtree_Async( Integer moduleid, boolean WithRoot ){
		if(WithRoot)
		{
			return getData_JEasyUI_Dndtree_AsyncWithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_Dndtree_AsyncNoRoot(moduleid);
		}
	}
	
	public String getData_JEasyUI_Dndtree_AsyncWithRoot(Integer moduleid){
//		log.debug("service....All node's state is close...getData_JEasyUI_Tree_Async...........");

		List dataList = new ArrayList();//module's children(Front Type )
		
		TAuthorityModule rootModule = (TAuthorityModule)dataDAO.findById(moduleid);
		
		List moduleList = dataDAO.findChildrenNoRecursive( rootModule.getNMid() );//module's children(POJO)
		log.debug("Children.size():"+moduleList.size());
		mdUtil.assembleData_JEasyUI_Dndtree_Async( dataList, moduleList );
				
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("url", rootModule.getCMpath());
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();
		mJEU.setId(rootModule.getNMid());
		mJEU.setText(rootModule.getCMname());
		mJEU.setState( rootModule.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
		mJEU.setIconCls(rootModule.getCMiconcls());
		
		attr1.put("leaf", rootModule.getCMleaf());
		attr1.put("level", rootModule.getNMlevel());
		attr1.put("parent", rootModule.getNMparent());
//		attr1.put("parent", rootModule.getNMparent().getNMid());
		attr1.put("order", rootModule.getNMorder());
		attr1.put("iconcls", rootModule.getCMiconcls());
		attr1.put("expanded", rootModule.getCMexpanded());
		attr1.put("checked", rootModule.getCMchecked());
		attr1.put("url", rootModule.getCMpath());
		attr1.put("note", rootModule.getCMnote());
		
		mJEU.setAttributes(attr1);
		mJEU.setChildren(dataList);

		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	public String getData_JEasyUI_Dndtree_AsyncNoRoot( Integer moduleid ){
//		log.debug("service....lazyload, Async tree...getData_JEasyUI_Tree_Async...........");
		List dataList = new ArrayList();//Root's children
		
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children
//		System.out.println("total module count:"+dataList.size());
		
//		log.debug("mList.size():"+dataList.size());
		
		mdUtil.assembleData_JEasyUI_Dndtree_Async( dataList, moduleList );
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());		
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_GubuSoft_Tree(){
//		log.debug("service..........getData_GubuSoft_Tree...........");
		List dataList = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findAllWithOrder();
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
	
		if( level0ModuleList.size() == 0 ){
			return "[]";
		}
//		MenuDataUtil mdUtil = new MenuDataUtil();
		mdUtil.assembleData_GubuSoft_Tree(dataList, (TAuthorityModule)level0ModuleList.get(0), 1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		
		TAuthorityModule_GubuSoft_Tree gbsTvM = new TAuthorityModule_GubuSoft_Tree();
		gbsTvM.setId(rootModule.getNMid());
		gbsTvM.setText(rootModule.getCMname());
		gbsTvM.setIconcls(rootModule.getCMiconcls());
		gbsTvM.setChildren(dataList);
	
		JSONArray jsonArray = JSONArray.fromObject(gbsTvM);
		log.debug("jsonArray:"+jsonArray.toString());
		/* struts2's json plugin **/
//		try {
//			log.debug("JSONUtil.serialize(gbsTvM):" + JSONUtil.serialize(gbsTvM));
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_GubuSoft_Tree(Long userId){
//		log.debug("service..........getData_GubuSoft_Tree...........");
		List dataList = new ArrayList();//Root's children
		
		List<TAuthorityModule> mList = dataDAO.findByUserId(userId);
		
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
	
		if(level0ModuleList.size() == 0){
			TAuthorityModule rootModule =new TAuthorityModule();
			rootModule.setNMparent(new Integer(0));
			rootModule.setNMid(1);
			rootModule.setCMname("新一代集邮系统");
			rootModule.setCMpath("");
			rootModule.setNMlevel( (short)(0));
			rootModule.setCMleaf("false");
			rootModule.setNMorder( (short)(1));
			rootModule.setCMiconcls("jyst");
			
			level0ModuleList.add(rootModule);
		}
//		MenuDataUtil mdUtil = new MenuDataUtil();
		mdUtil.assembleData_GubuSoft_Tree(dataList, (TAuthorityModule)level0ModuleList.get(0), 1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		
		TAuthorityModule_GubuSoft_Tree gbsTvM = new TAuthorityModule_GubuSoft_Tree();
		gbsTvM.setId(rootModule.getNMid());
		gbsTvM.setText(rootModule.getCMname());
		gbsTvM.setIconcls(rootModule.getCMiconcls());
		gbsTvM.setChildren(dataList);
	
		JSONArray jsonArray = JSONArray.fromObject(gbsTvM);
//		log.debug("jsonArray:"+jsonArray.toString());
		/* struts2's json plugin **/
//		try {
//			log.debug("JSONUtil.serialize(gbsTvM):" + JSONUtil.serialize(gbsTvM));
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return jsonArray.toString();
	}
	@SuppressWarnings("unchecked")
	public String getData_GubuSoft_Tree(Long userId, String logname ){
		//如果是dev用户，直接查询出所有菜单并组装成树数据返回
		if(logname.equalsIgnoreCase("dev")){
			return getData_GubuSoft_Tree();
		}
		return getData_GubuSoft_Tree( userId);
	}
	@SuppressWarnings("unchecked")
	public String getData_YUI2_Menu(){
//		log.debug("service..........getData_YUI2_Menu...........");
		List dataList = new ArrayList();//Root's children
		
		
		List<TAuthorityModule> mList = dataDAO.findAllWithOrder();
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
	
//		MenuDataUtil mdUtil = new MenuDataUtil();
//		获取某一个根节点(level=1)的子数据项
		
//		System.out.println("level1ModuleList.size():"+level1ModuleList.size());
		for(int i=0; i<level1ModuleList.size(); i++){
			TAuthorityModule module = (TAuthorityModule)level1ModuleList.get(i);
			TAuthorityModule_YUI2_Menu yui2MenuItem = new TAuthorityModule_YUI2_Menu();
			List itemList = new ArrayList();
			
			//####################   menu item #######  begin
			yui2MenuItem.setId(module.getNMid().toString());
			mdUtil.assembleData_YUI2_Menu(itemList, module, 2,	
					level1ModuleList,	level2ModuleList,
					level3ModuleList,	level4ModuleList,
					level5ModuleList,	level6ModuleList,
					level7ModuleList,	level8ModuleList,
					level9ModuleList,	level10ModuleList );
			
			yui2MenuItem.setItemdata(itemList);
			//####################   menu  item #######  end
			
			dataList.add(yui2MenuItem);
		}

		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray YUI MENU:"+jsonArray.toString());
		
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_YUI2_Menubar(){
//		log.debug("service..........getData_YUI2_Menu...........");		
		List<TAuthorityModule> level1ModuleList = dataDAO.findLevel1();
	

		JSONArray jsonArray = JSONArray.fromObject(level1ModuleList);
//		log.debug("jsonArray YUI MENU:"+jsonArray.toString());
		
		return jsonArray.toString();
	}
	@SuppressWarnings("unchecked")
	public String getData_Dojo_Tree_NoRoot(){
//		log.debug("service..........getData_Dojo_Tree_NoRoot...........");
		List dataList = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findAllWithOrder();
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
	
//		MenuDataUtil mdUtil = new MenuDataUtil();
		mdUtil.assembleData_GubuSoft_Tree(dataList, level0ModuleList.get(0), 1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
//		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
//		
//		TAuthorityModule_GubuSoft_Tree gbsTvM = new TAuthorityModule_GubuSoft_Tree();
//		gbsTvM.setId(rootModule.getNMid());
//		gbsTvM.setText(rootModule.getCMname());
//		gbsTvM.setIconcls(rootModule.getCMiconcls());
//		gbsTvM.setChildren(dataList);
	
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());
		
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_Dojo_Tree_Async( Integer moduleid ){
//		log.debug("service..........getData_Dojo_Tree_Async...........");
		List dataList = new ArrayList();//Root's children
		
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children
//		System.out.println("total module count:"+dataList.size());
		
//		log.debug("mList.size():"+dataList.size());
		
		mdUtil.assembleData_Dojo_Tree_Async( dataList, moduleList );
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());		
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_Dojo_Tree_LazyNode(Integer moduleid){
//		log.debug("service..........getData_Dojo_Tree_LazyNode...........");
		List dataList = new ArrayList();//Root's children
		
		TAuthorityModule node = dataDAO.findById( moduleid );
		List<TAuthorityModule> children = dataDAO.findChildrenNoRecursive( moduleid );//module's children
//		System.out.println("total module count:"+dataList.size());
		
//		log.debug("mList.size():"+dataList.size());
		
		mdUtil.assembleData_Dojo_Tree_Async( dataList, children );
				
		TAuthorityModule_GubuSoft_Tree gbsTvM = new TAuthorityModule_GubuSoft_Tree();
		gbsTvM.setId(node.getNMid());
		gbsTvM.setText(node.getCMname());
		gbsTvM.setIconcls(node.getCMiconcls());
		gbsTvM.setChildren(dataList);
		
		JSONObject jsonObject = JSONObject.fromObject(gbsTvM);
//		log.debug("jsonObject:"+jsonObject.toString());		
		return jsonObject.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_Ext3_Tree(){
//		log.debug("service..........getData_Ext3_Tree...........");
		List dataList = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findAllWithOrder();
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
	
//		log.debug("TreeView by gubusoft --->b");
		if( level0ModuleList.size()== 0 ){
			return "[]";
		}
//		MenuDataUtil mdUtil = new MenuDataUtil();
		mdUtil.assembleData_Ext_Tree(dataList, (TAuthorityModule)level0ModuleList.get(0), 1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
//		log.debug("TreeView by gubusoft --->e");
		
		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		
		//ext3's rootnode write in the javascript
//		TAuthorityModule_Ext_TreeView extTvM = new TAuthorityModule_Ext_TreeView();
//		extTvM.setDbid(rootModule.getNMid());
//		extTvM.setText(rootModule.getCMname());
//		extTvM.setId(rootModule.getCMpath());
//		extTvM.setCls(rootModule.getCMiconcls());
//		extTvM.setChildren(dataList);
	
//		log.debug("hello3");
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_Ext3_Tree_Async(Integer moduleid ){
//		log.debug("service..........getData_Ext3_Tree_Async...........");
		List dataList = new ArrayList();//Root's children
		
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children
//		System.out.println("total module count:"+dataList.size());
		
//		log.debug("mList.size():"+dataList.size());
		
		mdUtil.assembleData_Ext_Tree_Async( dataList, moduleList );
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());		
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_Ext4_Tree(){
//		log.debug("service..........getData_Ext4_Tree...........");
		List dataList = new ArrayList();//Root's children
		List<TAuthorityModule> mList = dataDAO.findAllWithOrder();
		List<TAuthorityModule> level0ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level1ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level2ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level3ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level4ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level5ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level6ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level7ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level8ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level9ModuleList = new ArrayList<TAuthorityModule>();
		List<TAuthorityModule> level10ModuleList = new ArrayList<TAuthorityModule>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityModule module = (TAuthorityModule)mList.get(i);
			level = module.getNMlevel().intValue();
//			log.debug("..level--->"+level);
			switch(level){
				case 0 : level0ModuleList.add(module); break;
				case 1 : level1ModuleList.add(module); break;
				case 2 : level2ModuleList.add(module); break;
				case 3 : level3ModuleList.add(module); break;
				case 4 : level4ModuleList.add(module); break;
				case 5 : level5ModuleList.add(module); break;
				case 6 : level6ModuleList.add(module); break;
				case 7 : level7ModuleList.add(module); break;
				case 8 : level8ModuleList.add(module); break;
				case 9 : level9ModuleList.add(module); break;
				case 10 : level10ModuleList.add(module); break;
				default : 
					System.out.println("level:"+level);
					System.out.println("module level invalid");
			}
		}
	
//		log.debug("TreeView by gubusoft --->b");
		if( level0ModuleList.size()== 0 ){
			return "[]";
		}
//		MenuDataUtil mdUtil = new MenuDataUtil();
		mdUtil.assembleData_Ext_Tree(dataList, (TAuthorityModule)level0ModuleList.get(0), 1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
//		log.debug("TreeView by gubusoft --->e");
		
		TAuthorityModule rootModule = (TAuthorityModule)level0ModuleList.get(0);
		
		//ext4's rootnode read from server jsondata
		TAuthorityModule_Ext_Tree extTvM = new TAuthorityModule_Ext_Tree();
		extTvM.setId(rootModule.getNMid());
		extTvM.setText(rootModule.getCMname());
		extTvM.setCls(rootModule.getCMiconcls());
		extTvM.setUrl(rootModule.getCMpath());
		extTvM.setTarget(rootModule.getCMtarget());
		extTvM.setExpanded( new Boolean(rootModule.getCMexpanded()).booleanValue() );
		extTvM.setChildren(dataList);
	
//		log.debug("hello3");
		JSONArray jsonArray = JSONArray.fromObject(extTvM);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}

	public String getCBBData_Parent(String jdata){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();

		SQLAssembleQ_CBB sqlA = new SQLAssembleQ_CBB(
				absConstant.getSQLDOC(),
				absConstant.getCombobox_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
//		return JSONArray.fromObject(dataDAO.sqlQueryfindComboboxDataInMap( sqlA.getSQL(), sqlA.getMap() )).toString();
		return JSONArray.fromObject(dataDAO.sqlQuerylistAllByMap( sqlA.getSQL(), sqlA.getMap() )).toString();
		
		//HQL Case sensitive
		//HQL use map(),so HQL query result is map
//		String hql="select new map( NMid as id, CMname as text)  from TAuthorityModule where CMleaf='false'  ";
		
//		SQLAssembleQ_CBB_HQL sqlA = new SQLAssembleQ_CBB_HQL( jsonObject, absConstant );
//		return JSONArray.fromObject( dataDAO.findComboboxData( sqlA.getHQL(), sqlA.getMap() ) ).toString();
	}
	public String getCBBDataInArray_Parent(String jdata){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		
		SQLAssembleQ_CBB sqlA = new SQLAssembleQ_CBB(
				absConstant.getSQLDOC(),
				absConstant.getCombobox_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
		return JSONArray.fromObject(dataDAO.sqlQuerylistAllRetArrayByMap( sqlA.getSQL(), sqlA.getMap() )).toString();

//		String hql="select NMid, CMname  from TAuthorityModule where CMleaf='false'";
//		SQLAssembleQ_CBB_HQL sqlA = new SQLAssembleQ_CBB_HQL( jsonObject, absConstant );
//		return JSONArray.fromObject(dataDAO.findComboboxData( sqlA.getHQL(), sqlA.getMap() )).toString();
	}

	@Override
	public long getTotal(SQLAssembleQ sqlA){
//		return dataDAO.sqlQueryGetTotal( sqlA.getCountSQL(), sqlA.getMap() );//使用native数据量小, Assemble sql in dao interface implements
		return Long.valueOf(
				dataDAO.sqlQueryfindaValueByMap( sqlA.getCountSQL(), sqlA.getMap() ).toString()
			).longValue();//使用native数据量小, Assemble sql in dao interface implements
	}
	
	public List getRowsInMap(SQLAssembleQ sqlA){
//		return dataDAO.sqlQueryGetRowsInMap(sqlA.getSQL(), sqlA.getMap(), offset, pageSize);//使用native数据量小
		return dataDAO.sqlQuerylistAllByMap( sqlA.getSQL(), sqlA.getMap() );//使用native数据量小
	}
	/*
	 * (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.TAuthorityModuleService#getRows(person.daizhongde.authority.util.SQLAssemble, java.lang.Integer, java.lang.Integer)
	 */
	public List getRowsInMap(SQLAssembleQ sqlA, int offset,int pageSize){
//		return dataDAO.sqlQueryGetRowsInMap(sqlA.getSQL(), sqlA.getMap(), offset, pageSize);//使用native数据量小
		return dataDAO.sqlQueryfindByPageByMap(sqlA.getSQL(), sqlA.getMap(), offset, pageSize);//使用native数据量小
	}

	@Override
	public long getTotal(HQLAssembleQ hqlA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getRowsInMap(HQLAssembleQ hqlA) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getRowsInMap(HQLAssembleQ sqlA, int offset, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	public List getRowsInArray(SQLAssembleQ sqlA){
		return dataDAO.sqlQuerylistAllRetArrayByMap(sqlA.getSQL(), sqlA.getMap());//使用native数据量小
	}
	public List getRowsInArray(SQLAssembleQ sqlA, int offset,int pageSize){
		return dataDAO.sqlQueryfindRetArrayByPageByMap(sqlA.getSQL(), sqlA.getMap(), offset, pageSize);//使用native数据量小
	}

	public int add( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
//		SQLAssembleC sqlA = new SQLAssembleC( jsonObject, absConstant );
		Map valueMap = new HashMap();
		valueMap.put(absConstant.getPrimaryKeyColumnName(), INIT.AUTH_schema + "." + absConstant.getPrimaryKeySequence()+".nextval");

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				valueMap
				);
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	
	/** 
	 * 新增记录并返回记录ID
	 * <p>
	 *     1.判断parent.leaf=true
	 * <br> Y: goto next step, N: update parent.leaf=false
	 * <br>2.保存记录
	 * <br>3.查询记录ID
	 * <br>4.返回记录ID
	 * <p>not all table id use sequence, so the method for get id write in service  **/
	public int addRetId( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();

		Map valueMap = new HashMap();
//		valueMap.put(absConstant.getPrimaryKeyColumnName(), INIT.AUTH_schema + "." + absConstant.getPrimaryKeySequence()+".nextval");
		int id = dataDAO.sqlQueryAuto_increment( absConstant.getTableName() );
		valueMap.put(absConstant.getPrimaryKeyColumnName(), id );
		
		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				valueMap 
				);
		
		/* 1.判断parent.leaf==true
		 *  Y: update parent.leaf=false, N: goto next step., 
		 *   */
		TAuthorityModule parent = dataDAO.findById( (Integer)sqlA.getMap().get("parent") );
		if( parent.getCMleaf().trim().equalsIgnoreCase("true") ){
			String modifyLeaf = "{'act':'update'," +
					"        'data':{'leaf':'false','expanded':'true'}," +
					"	'condition':{'id':" + parent.getNMid() + "}," +
					"	 'operator':{'id':"+Operator.EQUAL+"}" +
				"}";
			modify( modifyLeaf );
		}
		/* 2.保存 */
		dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
		
		/* 3.返回记录ID */
//		return Integer.valueOf(
//				dataDAO.sqlQueryfindaValueByMap("select " + INIT.AUTH_schema + "." + absConstant.getPrimaryKeySequence()+".CURRVAL from dual", new HashMap() ).toString()
//				);
		return id;
	}

	public int addWithId( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	public int addWithIdRetId( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
//		return (Integer)sqlA.getMap().get(
//			absConstant.getBack2front().get("NMid")
//		);
		/*The below Code is dependent on front field, 
		* but sometimes It's compatibility is better then the top Code  */
		return new Integer(sqlA.getMap().get("id").toString()).intValue();
	}
	
	public void addBySavePOJO( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();

		SQLAssembleC sqlA = new SQLAssembleC(
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		TAuthorityModule pojo = new TAuthorityModule();
		Map map =sqlA.getMap();

		pojo.setCMname(String.valueOf(map.get("cmname")));
		pojo.setCMpath(String.valueOf(map.get("cmpath")));
		pojo.setCMleaf(String.valueOf(map.get("cmleaf")));
		pojo.setNMparent(Integer.valueOf(map.get("nmparent").toString()));
//		pojo.setNMparent(dataDAO.findById( Integer.valueOf(map.get("nmparent").toString()) ));
		pojo.setNMlevel(Short.valueOf(map.get("nmlevel").toString()));
		pojo.setNMorder(Short.valueOf(map.get("nmorder").toString()));
		pojo.setCMnote(String.valueOf(map.get("cmnote")));

		dataDAO.save(pojo);
	}
	public void addBySavePOJO2( Object pojo ){
		
	}
	
	public int add(Map data) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modify( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		
		SQLAssembleU sqlA = new SQLAssembleU(
				INIT.AUTH_schema,
				absConstant.getSQLDOC(),
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				jsonObject.getJSONObject("algorithm"),
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	
	public Map browse( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		
		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Map)dataDAO.sqlQuerylistAllByMap(sqlA.getSQL(), sqlA.getMap()).get(0);
//		SQLAssembleR_HQL sqlA = new SQLAssembleR_HQL( jsonObject, absConstant );
//		return dataDAO.findARecordInMap(sqlA.getHQL(), sqlA.getMap());
	}
	@Override
	public Map browseById(int id) {
		AbstractConstant absConstant = new AuthorityModule();
		String pkcolName = absConstant.getPrimaryKeyColumnName();
		
		Map cond = new HashMap(1);
		cond.put( pkcolName, id);
		Map oper = new HashMap(1); 
		oper.put( pkcolName, Operator.EQUAL);
		
		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				cond,
				oper,
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Map)dataDAO.sqlQuerylistAllByMap(sqlA.getSQL(), sqlA.getMap()).get(0);
	}
	@Override
	public Map browseById(String id) {
		AbstractConstant absConstant = new AuthorityModule();
		String pkcolName = absConstant.getPrimaryKeyColumnName();
		
		Map cond = new HashMap(1);
		cond.put( pkcolName, id);
		Map oper = new HashMap(1); 
		oper.put( pkcolName, Operator.EQUAL);
		
		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				cond,
				oper,
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Map)dataDAO.sqlQuerylistAllByMap(sqlA.getSQL(), sqlA.getMap()).get(0);
	}
	public Object[] browseArray( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();

		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Object[])dataDAO.sqlQuerylistAllRetArrayByMap( sqlA.getSQL(), sqlA.getMap() ).get(0);
	}
	public TAuthorityModule browsePOJO( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		
		HQLAssembleR hqlA = new HQLAssembleR(absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2back() );
		
		return (TAuthorityModule)dataDAO.listAllByMap( "from TAuthorityModule t1 where "+hqlA.getWhereBackHQL(), hqlA.getMap() ).get(0);
	}
	public TAuthorityModule browsePOJOById( long id ){
		return dataDAO.findById( new Long(id).intValue() );
	}
	public TAuthorityModule browsePOJOById( String id ){
		return dataDAO.findById(new Integer(id).intValue());
	}
	
	public int delete( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();

		SQLAssembleD sqlA = new SQLAssembleD(
				INIT.AUTH_schema,
				absConstant.getSQLDOC(),
				absConstant.getTableName(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	
	public int deleteNP( String jdata){
		return this.modify(jdata);
	}
	
	public void remove( int id ) throws Exception{
		/*if node.leaf=false && node.children.length>0
		 * 	return false;并提示不能删除非空目录
		 */
		TAuthorityModule m = dataDAO.findById( new Integer(id) );
		if( new Boolean( m.getCMleaf()).booleanValue()  
				|| this.getChildrenLength( id )==0 ){
			
			/* C: children, PC: parent children*/
			int oldE_CLength = this.getChildrenLength( m.getNMparent().intValue() );
//			int oldE_PCLength = this.getChildrenLength(src);
			
			String deleteNode = "{act: 'del', " +
					"condition: {id:"+id+"}, " +
					"operator : {id:"+ Operator.EQUAL +"}" +
				"}";
			this.delete( deleteNode );
			
			this.modifyOrderByRange( m.getNMparent().intValue(), m.getNMorder().intValue()+1, oldE_CLength, -1 );
		}else{
			throw new Exception("不能删除非空目录!");
		}
	}
	
	public void removeRecursive( int id ){
		//recursive invocation--[计] 递归调用 
		//recursive remove--如果是目录递归删除子节点（慎用）
		TAuthorityModule m = dataDAO.findById( new Integer(id) );
		int oldE_CLength = this.getChildrenLength( m.getNMparent().intValue() );
		
		if( new Boolean( m.getCMleaf()).booleanValue() 
				|| this.getChildrenLength( id )==0 ){
			
			String deleteNode = "{act: 'del', " +
					"condition: {id:"+id+"}, " +
					"operator : {id:"+ Operator.EQUAL +"}" +
				"}";
			this.delete( deleteNode );
		}else{
			//删除节点及它的所有子节点
			String deleteNodesSQL ="delete from "+ INIT.AUTH_schema +".T_AUTHORITY_module" +
									"where n_mid in (select N_Mid " +
												   "   from "+ INIT.AUTH_schema +".T_AUTHORITY_Module " +
												   "  where FIND_IN_SET( t1.N_Mid, f_getChildModuleList( "+id+" ) ) "
												   + ")";
			dataDAO.sqlQueryExeUByMap( deleteNodesSQL, new HashMap());
		}
		this.modifyOrderByRange( m.getNMparent().intValue(), m.getNMorder().intValue()+1, oldE_CLength, -1 );
	}
	
	public void dndNode( int target, int source, String point ) throws Exception{
		/* two node data  */
		/*TAuthorityModule t = dataDAO.findById( target );
		TAuthorityModule src = dataDAO.findById( source );
		
		int oldT_NMparent = t.getNMparent();
		int oldT_NMorder = t.getNMorder();
		
		int oldSrc_NMparent = src.getNMparent();
		int oldSrc_NMorder = src.getNMorder();
		switch( point ){
			case "bottom": 
				if( oldT_NMparent == oldSrc_NMparent ){
					上移:oldT_NMorder<=oldSrc_NMorder,
					 *下移:oldT_NMorder>oldSrc_NMorder
					int order = oldT_NMorder<=oldSrc_NMorder ? oldT_NMorder+1 : oldT_NMorder;
					this.dndInnerMove(src, order);
				}else{
					this.dndOuterInsert(t, src, oldT_NMorder+1 );
				}
				break;
			case "top": 
				if( oldT_NMparent == oldSrc_NMparent ){
					上移:oldT_NMorder<=oldSrc_NMorder,
					 *下移:oldT_NMorder>oldSrc_NMorder
					int order = oldT_NMorder<=oldSrc_NMorder ? oldT_NMorder : oldT_NMorder-1;
					this.dndInnerMove(src, order);
				}else{
					this.dndOuterInsert(t, src, oldT_NMorder );
				}
				break;
			case "append": 
				if( target == oldSrc_NMparent ){
					 C: children, PC: parent children
					int oldT_CLength = this.getChildrenLength(target);
					this.dndInnerMove( src, oldT_CLength );
				}else{
					this.dndOuterAppend(t, src);
				}
				break;
		}*/
		if( target==1 && !point.equalsIgnoreCase("append") ){
			return;
//			throw new Exception("只允许存在一个零级模块!");
		}
		/** below jdk 1.6-  */
		if(point.trim().equalsIgnoreCase("bottom"))
		{
			this.dndInsertAfter( target, source );
		}
		else if(point.trim().equalsIgnoreCase("top"))
		{
			this.dndInsertBefore( target, source );
		}
		else if(point.trim().equalsIgnoreCase("append"))
		{
			this.dndAppend( target, source );
		}
		else
		{
			System.out.println("ERROR!!"+this.getClass().getName());
		}
		/** below jdk 1.7+  */
//		switch( point ){
//			case "bottom": this.dndInsertAfter( target, source ); break;
//			case "top": this.dndInsertBefore( target, source ); break;
//			case "append": this.dndAppend( target, source ); break;
//		}
	}
	
	/**
	 * directory inner movement
	 * 
	 * <p> order = src.order
	 * <br> &nbsp;&nbsp;Y: return, N:goto next step.
	 * 
	 * <p>enable constraint UK_AUTHORITY_MODULE_PARENTORDE;
	 * <br>上移
	 * <br>update node[order ~  src.order-1].order + 1
	 * <br>update src.order = order
	 * <p> 下移
	 * <br>update node[src.order+1 ~ order] - 1
	 * <br>update src.order = order
	 * <br>enable constraint UK_AUTHORITY_MODULE_PARENTORDE;
	 * 
	 * @param src
	 * @param order newSrc_NMorder
	 */
	private void dndInnerMove( TAuthorityModule src, int order ){
		int oldSrc_NMid = src.getNMid().intValue();
		int oldSrc_NMorder = src.getNMorder().intValue(); 
		if(order == oldSrc_NMorder){
			return;
		}
		
		int order0 = order < oldSrc_NMorder ? order : oldSrc_NMorder+1;
		int order1 = order < oldSrc_NMorder ? oldSrc_NMorder-1 : order;
		int plusNumber = order < oldSrc_NMorder ? 1 : -1;
		
		String modifyOrder2Temp = "update "+ INIT.AUTH_schema +".T_AUTHORITY_module " +
			"  set n_morder = 0 "+
			"where n_mid="+oldSrc_NMid;
		dataDAO.sqlQueryExeUByMap( modifyOrder2Temp, null );
		
		this.modifyOrderByRange(
				src.getNMparent().intValue(), 
				order0,
				order1,
				plusNumber
			);
		/*--可以让后台开发人员在不知道表名的前提下进行开发
		 * String modifyOrder = "{act:'update'," +
				"     data:{nmorder:" + order + "}," +
				"condition:{nmid:" + oldSrc_NMid + "}," +
				" operator:{nmid:"+Operator.EQUAL+"}" +
			"}";
		this.modify( modifyOrder );*/
		String modifyOrderSQL = "update "+ INIT.AUTH_schema +".T_AUTHORITY_module " +
			"  set n_morder = " +order+" "+
			"where n_mid="+oldSrc_NMid;
		dataDAO.sqlQueryExeUByMap( modifyOrderSQL, null );
	}
	
	/**
	 * outer insert
	 * 
	 * <p> disable constraint UK_AUTHORITY_MODULE_PARENTORDE;
	 * <br>	update node[t.order+1 ~  t.parent.children.length].order + 1
	 * <br> update src.parent = t.parent
	 * <br> update src.order = t.order+1
	 * <br> update src.level = t.level  
	 * <br> 
	 * <br> if(src.leaf == false && t.level != src.level ){
	 * <br> 	&nbsp;&nbsp;update src.getChildren.level = level + ( t.level - src.level ) //recursion
	 * <br> }
	 * <br> update node[src.order+1 ~ src.parent.children.length].order - 1
	 * <br> enable constraint UK_AUTHORITY_MODULE_PARENTORDE;
	 * 
	 * @param t
	 * @param src
	 * @param order newSrc_NMorder
	 */
	private void dndOuterInsert( TAuthorityModule t, TAuthorityModule src, int order ){
//		int oldT_NMid = t.getNMid();
		int oldT_NMparent = t.getNMparent().intValue();
		
		int oldSrc_NMid = src.getNMid().intValue();
		int oldSrc_NMparent = src.getNMparent().intValue();
		int oldSrc_NMorder = src.getNMorder().intValue(); 
		
		int oldT_PCLength = this.getChildrenLength(oldT_NMparent);
		int oldSrc_PCLength = this.getChildrenLength(oldSrc_NMparent);
//		System.out.println("oldT_PCLength:"+oldT_PCLength+",oldSrc_PCLength:"+oldSrc_PCLength);	
//		System.out.println("oldT_NMparent:"+oldT_NMparent);
		
		this.modifyOrderByRange( 
				oldT_NMparent, 
				order,
				oldT_PCLength,
				1
			);
		//如果src是目录而且e和src不在同一级就修改源节点的所有子节点的级别
		if( !new Boolean( src.getCMleaf()).booleanValue() 
				&& t.getNMlevel().shortValue() != src.getNMlevel().shortValue() 
				 ){
			this.modifyChildrenLevel( oldSrc_NMid, t.getNMlevel().intValue()-src.getNMlevel().intValue());
		}
		
		/*src = dataDAO.findById(oldSrc_NMid);//if don't do this, when before if condition is true the source level lost update
		src.setNMparent( oldT_NMparent );
		src.setNMorder( 
				Integer.valueOf( order ).shortValue() 
			);
		if( new Boolean( m.getCMleaf()).booleanValue() 
				&& t.getNMlevel() != src.getNMlevel().intValue() 
				){
			System.out.println("modify a leaf level...");
			src.setNMlevel( Integer.valueOf( t.getNMlevel() ).shortValue() );
		}
		dataDAO.attachDirty( src );*/
		
		String modifySourceSQL = "";
		if( new Boolean( src.getCMleaf()).booleanValue() 
				&& t.getNMlevel().shortValue() != src.getNMlevel().shortValue()
				){
			modifySourceSQL = "update "+ INIT.AUTH_schema +".T_AUTHORITY_module " +
				"  set N_Mparent="+oldT_NMparent+", N_Morder="+order+", N_Mlevel="+t.getNMlevel()+" " +
				"where N_Mid="+oldSrc_NMid;
		}else{
			modifySourceSQL =  "update "+ INIT.AUTH_schema +".T_AUTHORITY_module " +
				"  set N_Mparent="+oldT_NMparent+", N_Morder="+order+" " +
				"where N_Mid="+oldSrc_NMid;
		}
		dataDAO.sqlQueryExeUByMap(modifySourceSQL, null );
		
		this.modifyOrderByRange(
			oldSrc_NMparent, 
			oldSrc_NMorder + 1,
			oldSrc_PCLength,
			-1
		);
//		int newT_PCLength = this.getChildrenLength(t.getNMparent());
//		int newSrc_PCLength = this.getChildrenLength(src.getNMparent());
//		System.out.println("newT_PCLength:"+newT_PCLength+",newSrc_PCLength:"+newSrc_PCLength);
	}
	
	/**
	 * outer Append, node change to target's last child
	 * 
	 * <p>  disable constraint UK_AUTHORITY_MODULE_PARENTORDE;
	 * <br> target.leaf==true
	 * <br>  Y: update target.leaf=false, N: goto next step.
	 * <br>
	 * <br> if(src.leaf == false && t.level != src.level-1 ){
	 * <br>   &nbsp;&nbsp;update src.getChildren.level = level + ( t.level - src.level + 1 ) //recursion include itself
	 * <br> }
	 * <br>
	 * <br>	update src.parent = t.id
	 * <br> update src.order = t.children.length+1
	 * <br> if(src.leaf == true && t.level != src.level-1 ){ 
	 * <br>   &nbsp;&nbsp;update src.level = t.level + 1
	 * <br> } 
	 * <br>
	 * <br> update node[src.order+1 ~ src.parent.children.length].order - 1
	 * <br> enable constraint UK_AUTHORITY_MODULE_PARENTORDE;
	 * 
	 * @param t
	 * @param src
	 */
	private void dndOuterAppend( TAuthorityModule t, TAuthorityModule src ){
		
		int oldT_NMid = t.getNMid().intValue();
//		int oldT_NMparent = t.getNMparent();
		
		int oldSrc_NMid = src.getNMid().intValue();
		int oldSrc_NMparent = src.getNMparent().intValue();
		int oldSrc_NMorder = src.getNMorder().intValue(); 
		
		/* C: children, PC: parent children*/
		int oldT_CLength = this.getChildrenLength( oldT_NMid );
		int order = oldT_CLength+1;
		
//		int oldT_CLength = this.getChildrenLength(oldT_NMid);
		int oldSrc_PCLength = this.getChildrenLength( oldSrc_NMparent );
//		System.out.println("oldT_CLength:"+oldT_CLength+",oldSrc_PCLength:"+oldSrc_PCLength);
//		System.out.println("oldT_NMid:"+oldT_NMid);
		
		/* target.leaf==true
		 *  Y: update target.leaf=false, N: goto next step.
		 *   */
		/*--可以让后台开发人员在不知道表名的前提下进行开发
		 * if( t.getCMleaf().trim().equalsIgnoreCase("true") ){
			System.out.println("modify target leaf...");
			String modifyLeaf = "{act:'update'," +
					"     data:{CMleaf:'false',CMexpanded:'true'}," +
					"condition:{nmid:" + oldT_NMid + "}," +
					" operator:{nmid:"+Operator.EQUAL+"}" +
				"}";
			modify( modifyLeaf );
		}*/
		if( t.getCMleaf().trim().equalsIgnoreCase("true") ){
			String modifyLeafSQL = "update "+ INIT.AUTH_schema +".T_AUTHORITY_module " +
					"  set C_Mleaf = 'false', C_Mexpanded='true' "+
					"where n_mid="+oldT_NMid;
				dataDAO.sqlQueryExeUByMap( modifyLeafSQL, null );
		}
		//如果src是目录 && t.level+1 != src.level 修改源节点的所有子节点的级别
		if( !new Boolean( src.getCMleaf()).booleanValue() 
				&& t.getNMlevel().intValue()+1 != src.getNMlevel().intValue() 
				 ){
//			System.out.println("recursive modify level...");
			this.modifyChildrenLevel( oldSrc_NMid, t.getNMlevel().intValue()-src.getNMlevel().intValue()+1 );
		}
		
		/*src = dataDAO.findById(oldSrc_NMid);//if don't do this, when before if condition is true the source level lost update 
		src.setNMparent( oldT_NMid );
		src.setNMorder( Integer.valueOf(
				order
			).shortValue() );
		if( new Boolean( src.getCMleaf()).booleanValue() 
				&& t.getNMlevel()+1 != src.getNMlevel().intValue() 
				){
			System.out.println("modify a leaf level...");
			src.setNMlevel( Integer.valueOf( t.getNMlevel()+1 ).shortValue() );
		}
		dataDAO.attachDirty( src );*/
		String modifySourceSQL = "";
		if( new Boolean( src.getCMleaf()).booleanValue() 
				&& t.getNMlevel()+1 != src.getNMlevel().intValue() 
				){
			modifySourceSQL = "update "+ INIT.AUTH_schema +".T_AUTHORITY_module " +
				"  set N_Mparent="+oldT_NMid+", N_Morder="+order+", N_Mlevel="+(t.getNMlevel().intValue()+1)+" " +
				"where N_Mid="+oldSrc_NMid;
		}else{
			modifySourceSQL =  "update "+ INIT.AUTH_schema +".T_AUTHORITY_module " +
				"  set N_Mparent="+oldT_NMid+", N_Morder="+order+" " +
				"where N_Mid="+oldSrc_NMid;
		}
		dataDAO.sqlQueryExeUByMap(modifySourceSQL, null );
		
		this.modifyOrderByRange(
			oldSrc_NMparent, 
			oldSrc_NMorder + 1,
			oldSrc_PCLength,
			-1
		);
		
//		int newT_CLength = this.getChildrenLength( oldT_NMid );
//		int newSrc_PCLength = this.getChildrenLength( src.getNMparent() );
//		System.out.println("newT_CLength:"+newT_CLength+",newSrc_PCLength:"+newSrc_PCLength);
	}
	
	/**
	 * src-source, t-target
	 * <br>外部插入-节点后插入insertAfter
	 * <p><b>注:
	 * <br>  &nbsp;&nbsp;1.同一级不一定在同一目录
	 * <br>  &nbsp;&nbsp;2.注释中的类语言 node[1..n]中的索引并不是数组的索引，这里是从1开始的
	 * 
	 * <p> t.parent=src.parent
	 * <br> &nbsp;&nbsp;Y:dndInnerMove, return; N:go to next step;
	 * 
	 * @param target
	 * @param source
	 */
	private void dndInsertAfter( int target, int source ){
		TAuthorityModule t = dataDAO.findById( new Integer(target) );
		TAuthorityModule src = dataDAO.findById( new Integer(source) );
//		if(t.getNMparent()==null){
//			return;
//		}
		int oldT_NMparent = t.getNMparent();
		int oldT_NMorder = t.getNMorder();
		
		int oldSrc_NMparent = src.getNMparent();
		int oldSrc_NMorder = src.getNMorder();
		
		if( oldT_NMparent == oldSrc_NMparent ){
			/*上移:oldT_NMorder<=oldSrc_NMorder,
			 *下移:oldT_NMorder>oldSrc_NMorder*/
			int order = oldT_NMorder<=oldSrc_NMorder ? oldT_NMorder+1 : oldT_NMorder;
			this.dndInnerMove(src, order);
		}else{
			this.dndOuterInsert(t, src, oldT_NMorder+1 );
		}
	}
	
	/**
	 * src-source, t-target
	 * <br>外部插入-节点前插入insertBefore
	 * <p><b>注:
	 * <br>  &nbsp;&nbsp;1.同一级不一定在同一目录
	 * <br>  &nbsp;&nbsp;2.注释中的类语言 node[1..n]中的索引并不是数组的索引，这里是从1开始的
	 * 
	 * <p> t.parent=src.parent
	 * <br> &nbsp;&nbsp;Y:dndInnerMove, return; N:go to next step;
	 * 
	 * @param target
	 * @param source
	 */
	private void dndInsertBefore( int target, int source ){
		TAuthorityModule t = dataDAO.findById( new Integer(target) );
		TAuthorityModule src = dataDAO.findById( new Integer(source) );
		
		int oldT_NMparent = t.getNMparent().intValue();
		int oldT_NMorder = t.getNMorder().intValue();
		
		int oldSrc_NMparent = src.getNMparent().intValue();
		int oldSrc_NMorder = src.getNMorder().intValue();
		
		if( oldT_NMparent == oldSrc_NMparent ){
			/*上移:oldT_NMorder<=oldSrc_NMorder,
			 *下移:oldT_NMorder>oldSrc_NMorder*/
			int order = oldT_NMorder<=oldSrc_NMorder ? oldT_NMorder : oldT_NMorder-1;
			this.dndInnerMove(src, order);
		}else{
			this.dndOuterInsert(t, src, oldT_NMorder );
		}
	}
	/**
	 * src-source, t-target
	 * <br>内部插入-append
	 * <br>将source放在target之中,放在target最后一个child之后
	 * 
	 * <p> t=src.parent
	 * <br> &nbsp;&nbsp;Y:dndInnerMove,N:dndAppend;
	 * 
	 * @param target
	 * @param source
	 */
	private void dndAppend( int target, int source ){
		TAuthorityModule t = dataDAO.findById( new Integer(target) );
		TAuthorityModule src = dataDAO.findById( new Integer(source) );
		
		int oldSrc_NMparent = src.getNMparent().intValue();
		
		/* t=src.parent */
		if( target == oldSrc_NMparent ){
			/* C: children, PC: parent children*/
			int oldT_CLength = this.getChildrenLength(target);
			this.dndInnerMove( src, oldT_CLength );
		}else{
			this.dndOuterAppend(t, src);
		}
	}
	/**
	 * 获取指定节点的直接子节点的个数
	 * @param parentId
	 * @return
	 */
	private int getChildrenLength( int parentId ){
		String countHQL = "select count(*) from TAuthorityModule where NMparent = " + parentId;
		return Integer.valueOf(
					dataDAO.findaValue( countHQL ).toString()
				);
	}
	/**
	 * 修改指定节点的所有子节点（包含间接子节点）的的级别--如果没有指明子节点就都包含间接子节点
	 * @param parentId
	 * @param plusNumber parentId下面的子节点加多少级
	 */
	@SuppressWarnings("unchecked")
	private void modifyChildrenLevel( int parentId, int plusNumber ){
		if(plusNumber==0){
			return;
		}
		
		String modifyLevelSQL = "update "+ INIT.AUTH_schema +".T_AUTHORITY_module " +
								"   set n_mlevel=n_mlevel+ :NMlevel " +
								" where n_mid in (select N_Mid " +
								"                   from "+ INIT.AUTH_schema +".T_AUTHORITY_Module " +
								"                  where FIND_IN_SET( N_Mid, f_getChildModuleList( :NMid ) )"
								+ ")";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("NMid", new Integer(parentId) );
		map.put("NMlevel", new Integer(plusNumber) );
		dataDAO.sqlQueryExeUByMap( modifyLevelSQL, map);
		
	}
	/**
	 * modify node order by order range
	 * @param parentId
	 * @param order0
	 * @param order1
	 * @param plusNumber
	 */
	private void modifyOrderByRange( int parentId, int order0, int order1, int plusNumber ){
		if( order0 > order1){
			return;
		}
		
		String modifyOrder = "{act:'update'," +
				"data:{order:"+plusNumber+"}," +
				"algorithm:{order : "+ Algorithm.PLUS +"}," +
				"condition:{parent:" + parentId + ",order:["+order0+","+order1+"]}," +
				"operator:{parent:"+ Operator.EQUAL +",order:"+ Operator.BETWEEN +"}" +
			"}";
		modify( modifyOrder );
	}

	public void setDataDAO(TAuthorityModuleDAO dataDAO) {
		this.dataDAO = dataDAO;
	}

	public static TAuthorityModuleService getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityModuleService) ctx.getBean("tAuthorityModuleService");
	}
}
