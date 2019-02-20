package person.daizhongde.authority.spring.service.impl;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.constant.AuthorityInst;
import person.daizhongde.authority.hibernate.dao.TAuthorityInstDAO;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_CBT;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_Tree;
import person.daizhongde.authority.hibernate.pojo.TAuthorityInst;
import person.daizhongde.authority.spring.service.TAuthorityInstService;
import person.daizhongde.authority.util.TreeDataUtil_Inst;

import person.daizhongde.virtue.assemble.hql.HQLAssembleQ;
import person.daizhongde.virtue.assemble.hql.HQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleC;
import person.daizhongde.virtue.assemble.sql.SQLAssembleD;
import person.daizhongde.virtue.assemble.sql.SQLAssembleE;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ_CBB;
import person.daizhongde.virtue.assemble.sql.SQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleU;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.constant.Operator;

public class TAuthorityInstServiceImpl implements TAuthorityInstService {

	private static final Log log = LogFactory.getLog(TAuthorityInstServiceImpl.class);
	
	private TAuthorityInstDAO dataDAO;
	private TreeDataUtil_Inst mdUtil = new TreeDataUtil_Inst();
	
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

		List<TAuthorityInst> mList = dataDAO.findChildrenRecursive(moduleid );

		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);

		return getData_JEasyUI_TreeWithRoot( rootModule, mList );
	}
	
	public String getData_JEasyUI_TreeWithRoot( TAuthorityInst rootModule, List<TAuthorityInst>  mList )
	{
//		log.debug("service....AllNode...getData_JEasyUI_Tree...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
		List dataList2 = new ArrayList();//Root's children
		List<TAuthorityInst> level0ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level1ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level2ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level3ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level4ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level5ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level6ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level7ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level8ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level9ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level10ModuleList = new ArrayList<TAuthorityInst>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityInst module = (TAuthorityInst)mList.get(i);
			level = module.getNIlevel().intValue();;
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
		mdUtil.assembleData_JEasyUI_Tree(dataList2, rootModule, rootModule.getNIlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();
		
		mJEU.setId(rootModule.getNIid());
		mJEU.setText(rootModule.getCIname());
		
		if(dataList2.size()==0){
			mJEU.setState("closed");
		}else{
			mJEU.setState( "open");
		}
		
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("code", rootModule.getCIcode() );
		attr1.put("level", rootModule.getNIlevel() );
		attr1.put("type", rootModule.getNItype() );
		attr1.put("leaf", rootModule.getCIleaf());
//		attr1.put("superior", rootModule.getTAuthorityInst().getNIid());
		attr1.put("superior", "");
//		attr1.put("manager", m.getCImanager() );
//		attr1.put("mtel", m.getCImtel() );
//		attr1.put("memail", m.getCImemail() );
//		attr1.put("mqq", m.getCImqq() );
//		attr1.put("linkman", m.getCIlinkman() );
//		attr1.put("ltel", m.getCIltel() );
//		attr1.put("lemail", m.getCIlemail() );
//		attr1.put("lqq", m.getCIlqq() );
//		attr1.put("address", m.getCIaddress() );
//		attr1.put("description", m.getCIdescription() );

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
		List<TAuthorityInst> mList = dataDAO.findChildrenRecursive(moduleid );
		List<TAuthorityInst> level0ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level1ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level2ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level3ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level4ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level5ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level6ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level7ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level8ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level9ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level10ModuleList = new ArrayList<TAuthorityInst>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityInst module = (TAuthorityInst)mList.get(i);
			level = module.getNIlevel().intValue();
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
		
		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		
		//algorithm is waiting for improve
//		MenuDataUtil mdUtil = new MenuDataUtil();
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_Tree(dataList2, rootModule, rootModule.getNIlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);

		JSONArray jsonArray = JSONArray.fromObject(dataList2);
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
		
		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		
//		List moduleList = dataDAO.findChildren( rootModule.getNIid(), false );//module's children(POJO)
		
		List moduleList = dataDAO.findChildrenNoRecursive( rootModule.getNIid() );//module's children(POJO)
		log.debug("Children.size():"+moduleList.size());
		mdUtil.assembleData_JEasyUI_Tree_Async( dataList, moduleList );
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();
		
		mJEU.setId(rootModule.getNIid());
		mJEU.setText(rootModule.getCIname());
		
		if(dataList.size()==0){
			mJEU.setState("closed");
		}else{
			mJEU.setState( "open");
		}
		
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("code", rootModule.getCIcode() );
		attr1.put("level", rootModule.getNIlevel() );
		attr1.put("type", rootModule.getNItype() );
		attr1.put("leaf", rootModule.getCIleaf());
//		attr1.put("superior", rootModule.getTAuthorityInst().getNIid());
		attr1.put("superior", "");
//		attr1.put("manager", m.getCImanager() );
//		attr1.put("mtel", m.getCImtel() );
//		attr1.put("memail", m.getCImemail() );
//		attr1.put("mqq", m.getCImqq() );
//		attr1.put("linkman", m.getCIlinkman() );
//		attr1.put("ltel", m.getCIltel() );
//		attr1.put("lemail", m.getCIlemail() );
//		attr1.put("lqq", m.getCIlqq() );
//		attr1.put("address", m.getCIaddress() );
//		attr1.put("description", m.getCIdescription() );

		mJEU.setAttributes(attr1);
		mJEU.setChildren(dataList);
		
		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	public String getData_JEasyUI_Tree_AsyncNoRoot( Integer moduleid ){
//		log.debug("service....lazyload, Async tree...getData_JEasyUI_Tree_Async...........");
		List dataList = new ArrayList();//Root's children
		//findChildrenNoRecursive
//		List moduleList = dataDAO.findChildren( moduleid, false );//module's children
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children
//		System.out.println("total module count:"+dataList.size());
		
//		log.debug("mList.size():"+dataList.size());
		
		mdUtil.assembleData_JEasyUI_Tree_Async( dataList, moduleList );
		
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
//		List<TAuthorityInst> mList = dataDAO.findChildren(moduleid, true, 100);
		List<TAuthorityInst> mList = dataDAO.findChildrenRecursive( moduleid );
		
		List<TAuthorityInst> level0ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level1ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level2ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level3ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level4ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level5ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level6ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level7ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level8ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level9ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level10ModuleList = new ArrayList<TAuthorityInst>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityInst module = (TAuthorityInst)mList.get(i);
			level = module.getNIlevel().intValue();
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
		
//		TAuthorityInst rootModule = (TAuthorityInst)level0ModuleList.get(0);
		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_CBT(dataList2, rootModule, rootModule.getNIlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		JEasyUI_CBT mJEU = new JEasyUI_CBT();

		mJEU.setId(rootModule.getNIid());
		mJEU.setText(rootModule.getCIname());
		
		if(dataList2.size()==0){
			mJEU.setState("closed");
		}else{
			mJEU.setState( "open");
		}

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
//		List<TAuthorityInst> mList = dataDAO.findChildren(moduleid, true,100);
		List<TAuthorityInst> mList = dataDAO.findChildrenRecursive(moduleid);
		
		List<TAuthorityInst> level0ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level1ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level2ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level3ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level4ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level5ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level6ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level7ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level8ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level9ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level10ModuleList = new ArrayList<TAuthorityInst>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityInst module = (TAuthorityInst)mList.get(i);
			level = module.getNIlevel().intValue();
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
		
		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_CBT(dataList2, rootModule, rootModule.getNIlevel().intValue()+1,	
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

		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		
//		List moduleList = dataDAO.findChildren( moduleid, false,1 );//module's children(POJO)
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children(POJO)
		
		log.debug("Children.size():"+moduleList.size());
		
		mdUtil.assembleData_JEasyUI_CBT_Async( dataList, moduleList );
		
		JEasyUI_CBT mJEU = new JEasyUI_CBT();
		
		mJEU.setId(rootModule.getNIid());
		mJEU.setText(rootModule.getCIname());
		
		if(dataList.size()==0){
			mJEU.setState("closed");
		}else{
			mJEU.setState( "open");
		}
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
		
//		List moduleList = dataDAO.findChildren( moduleid, false );//module's children
		
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children
//		System.out.println("total module count:"+dataList.size());
		
//		log.debug("mList.size():"+dataList.size());
		
		mdUtil.assembleData_JEasyUI_CBT_Async( dataList, moduleList );
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());		
		return jsonArray.toString();
	}
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_CBT_L3( Integer moduleid, boolean WithRoot ){
		if(WithRoot)
		{
			return getData_JEasyUI_CBT_L3WithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_CBT_L3NoRoot(moduleid);
		}
	}
	
	public String getData_JEasyUI_CBT_L3WithRoot( Integer moduleid ){
//		log.debug("service....AllNode...getData_JEasyUI_CBTWithRoot...........");
		
		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node
		List dataList2 = new ArrayList();//Root's children
		List<TAuthorityInst> mList = dataDAO.findChildrenRecursive( moduleid, rootModule.getNIlevel()+2 );
		
		List<TAuthorityInst> level0ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level1ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level2ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level3ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level4ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level5ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level6ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level7ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level8ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level9ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level10ModuleList = new ArrayList<TAuthorityInst>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityInst module = (TAuthorityInst)mList.get(i);
			level = module.getNIlevel().intValue();
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

		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_CBT(dataList2, rootModule, rootModule.getNIlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);
		
		JEasyUI_CBT mJEU = new JEasyUI_CBT();

		mJEU.setId(rootModule.getNIid());
		mJEU.setText(rootModule.getCIname());
		
		if(dataList2.size()==0){
			mJEU.setState("closed");
		}else{
			mJEU.setState( "open");
		}

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
	public String getData_JEasyUI_CBT_L3NoRoot( Integer moduleid ) {
//		log.debug("service....AllNode...getData_JEasyUI_CBTNoRoot...........");
		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node
		List dataList2 = new ArrayList();//Root's children		
		List<TAuthorityInst> mList = dataDAO.findChildrenRecursive(moduleid,rootModule.getNIlevel()+2);
		
		List<TAuthorityInst> level0ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level1ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level2ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level3ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level4ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level5ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level6ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level7ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level8ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level9ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level10ModuleList = new ArrayList<TAuthorityInst>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityInst module = (TAuthorityInst)mList.get(i);
			level = module.getNIlevel().intValue();
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
		
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_CBT(dataList2, rootModule, rootModule.getNIlevel().intValue()+1,	
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
	public String getData_JEasyUI_FullTree( Integer moduleid, boolean WithRoot )
	{
		if(WithRoot)
		{
			return getData_JEasyUI_FullTreeWithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_FullTreeNoRoot(moduleid);
		}
	}
	
	public String getData_JEasyUI_FullTreeWithRoot( Integer moduleid )
	{
		log.debug("service....getData_JEasyUI_FullTreeWithRoot ###########DND###########...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
		List dataList2 = new ArrayList();//Root's children
				
//		List<TAuthorityInst> mList = dataDAO.findChildren(moduleid, true);
		
		List<TAuthorityInst> mList = dataDAO.findChildrenRecursive(moduleid);
		
		List<TAuthorityInst> level0ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level1ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level2ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level3ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level4ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level5ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level6ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level7ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level8ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level9ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level10ModuleList = new ArrayList<TAuthorityInst>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityInst module = (TAuthorityInst)mList.get(i);
			level = module.getNIlevel().intValue();
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
		
//		TAuthorityInst rootModule = (TAuthorityInst)level0ModuleList.get(0);
		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		
		//algorithm is waiting for improve
//		MenuDataUtil mdUtil = new MenuDataUtil();
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_FullTree(dataList2, rootModule, rootModule.getNIlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);

		JEasyUI_Tree mJEU = new JEasyUI_Tree();

		mJEU.setId(rootModule.getNIid());
		mJEU.setText(rootModule.getCIname());
		
		if(dataList2.size()==0){
			mJEU.setState("closed");
		}else{
			mJEU.setState( "open");
		}
		
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("code", rootModule.getCIcode() );
		attr1.put("level", rootModule.getNIlevel() );
		attr1.put("type", rootModule.getNItype() );
		attr1.put("leaf", rootModule.getCIleaf());
//		attr1.put("superior", rootModule.getTAuthorityInst().getNIid());
		attr1.put("superior", "");
		attr1.put("manager", rootModule.getCImanager() );
		attr1.put("mtel", rootModule.getCImtel() );
		attr1.put("memail", rootModule.getCImemail() );
		attr1.put("mqq", rootModule.getCImqq() );
		attr1.put("linkman", rootModule.getCIlinkman() );
		attr1.put("ltel", rootModule.getCIltel() );
		attr1.put("lemail", rootModule.getCIlemail() );
		attr1.put("lqq", rootModule.getCIlqq() );
		attr1.put("address", rootModule.getCIaddress() );
		attr1.put("description", rootModule.getCIdescription() );

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
	public String getData_JEasyUI_FullTreeNoRoot( Integer moduleid )
	{
		log.debug("service....getData_JEasyUI_FullTreeNoRoot...........");
//		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
		List dataList2 = new ArrayList();//Root's children
//		List<TAuthorityInst> mList = dataDAO.findChildren(moduleid, true);
		List<TAuthorityInst> mList = dataDAO.findChildrenRecursive(moduleid);
		
		List<TAuthorityInst> level0ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level1ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level2ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level3ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level4ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level5ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level6ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level7ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level8ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level9ModuleList = new ArrayList<TAuthorityInst>();
		List<TAuthorityInst> level10ModuleList = new ArrayList<TAuthorityInst>();
		
//		System.out.println("total module count:"+mList.size());
		
		int level;
//		log.debug("mList.size():"+mList.size());
		//assembling by level ,aim to raise algorithm efficiency;
		for(int i=0,j = mList.size(); i < j; i++){
			TAuthorityInst module = (TAuthorityInst)mList.get(i);
			level = module.getNIlevel().intValue();
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
		
		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		//algorithm is waiting for improve
//		MenuDataUtil mdUtil = new MenuDataUtil();
		/** 如果有特殊情况：有多个root节点(level=0的节点),对这里的方法 按level0ModuleList循环即可  **/
		mdUtil.assembleData_JEasyUI_FullTree(dataList2, rootModule, rootModule.getNIlevel().intValue()+1,	
				level1ModuleList,	level2ModuleList,
				level3ModuleList,	level4ModuleList,
				level5ModuleList,	level6ModuleList,
				level7ModuleList,	level8ModuleList,
				level9ModuleList,	level10ModuleList);

		JSONArray jsonArray = JSONArray.fromObject(dataList2);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	public String getData_JEasyUI_FullTree_Async( Integer moduleid, boolean WithRoot ){
		if(WithRoot)
		{
			return getData_JEasyUI_FullTree_AsyncWithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_FullTree_AsyncNoRoot(moduleid);
		}
	}
	
	public String getData_JEasyUI_FullTree_AsyncWithRoot(Integer moduleid){
//		log.debug("service....All node's state is close...getData_JEasyUI_Tree_Async...........");

		List dataList = new ArrayList();//module's children(Front Type )
		
		TAuthorityInst rootModule = (TAuthorityInst)dataDAO.findById(moduleid);
		
//		List moduleList = dataDAO.findChildren( rootModule.getNIid(), false );//module's children(POJO)
		List moduleList = dataDAO.findChildrenNoRecursive( rootModule.getNIid() );//module's children(POJO)
		
		log.debug("Children.size():"+moduleList.size());
		mdUtil.assembleData_JEasyUI_FullTree_Async( dataList, moduleList );
		
		JEasyUI_Tree mJEU = new JEasyUI_Tree();

		mJEU.setId(rootModule.getNIid());
		mJEU.setText(rootModule.getCIname());
		
		if(dataList.size()==0){
			mJEU.setState("closed");
		}else{
			mJEU.setState( "open");
		}
		
		LinkedHashMap attr1 = new LinkedHashMap();
		attr1.put("code", rootModule.getCIcode() );
		attr1.put("level", rootModule.getNIlevel() );
		attr1.put("type", rootModule.getNItype() );
		attr1.put("leaf", rootModule.getCIleaf());
//		attr1.put("superior", rootModule.getTAuthorityInst().getNIid());
		if( rootModule.getNIsuperior()!=null ){
			attr1.put("superior", rootModule.getNIsuperior());
		}else{
			attr1.put("superior", "");
		}
		
		attr1.put("manager", rootModule.getCImanager() );
		attr1.put("mtel", rootModule.getCImtel() );
		attr1.put("memail", rootModule.getCImemail() );
		attr1.put("mqq", rootModule.getCImqq() );
		attr1.put("linkman", rootModule.getCIlinkman() );
		attr1.put("ltel", rootModule.getCIltel() );
		attr1.put("lemail", rootModule.getCIlemail() );
		attr1.put("lqq", rootModule.getCIlqq() );
		attr1.put("address", rootModule.getCIaddress() );
		attr1.put("description", rootModule.getCIdescription() );

		mJEU.setAttributes(attr1);
		mJEU.setChildren( dataList );
		
		JSONArray jsonArray = JSONArray.fromObject(mJEU);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	public String getData_JEasyUI_FullTree_AsyncNoRoot( Integer moduleid ){
//		log.debug("service....lazyload, Async tree...getData_JEasyUI_Tree_Async...........");
		List dataList = new ArrayList();//Root's children
		
//		List moduleList = dataDAO.findChildren( moduleid, false );//module's children
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children
		
//		System.out.println("total module count:"+dataList.size());
		
//		log.debug("mList.size():"+dataList.size());
		
		mdUtil.assembleData_JEasyUI_FullTree_Async( dataList, moduleList );
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());		
		return jsonArray.toString();
	}
	public String getCBBData_Id(String jdata){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();

		SQLAssembleQ_CBB sqlA = new SQLAssembleQ_CBB(
				absConstant.getSQLDOC(),
				absConstant.getCombobox_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
		return JSONArray.fromObject(dataDAO.sqlQuerylistAllByMap( sqlA.getSQL(), sqlA.getMap() )).toString();
		
	}
	public String getCBBDataInArray_Id(String jdata){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();
		
		SQLAssembleQ_CBB sqlA = new SQLAssembleQ_CBB(
				absConstant.getSQLDOC(),
				absConstant.getCombobox_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
		return JSONArray.fromObject(dataDAO.sqlQuerylistAllRetArrayByMap( sqlA.getSQL(), sqlA.getMap() )).toString();
	}
	
	@Override
	public long getTotal(SQLAssembleQ sqlA) {
//		Object o= dataDAO.sqlQueryfindaValueByMap( sqlA.getCountSQL(), sqlA.getMap() );
		return Long.valueOf(
				dataDAO.sqlQueryfindaValueByMap( sqlA.getCountSQL(), sqlA.getMap() ).toString()
			).longValue();
	}
	
	@Override
	public List getRowsInMap(SQLAssembleQ sqlA) {
		return dataDAO.sqlQuerylistAllByMap( sqlA.getSQL(), sqlA.getMap() );//使用native数据量小
	}
	@Override
	public List getRowsInMap(SQLAssembleQ sqlA, int offset, int pageSize) {
		return dataDAO.sqlQueryfindByPageByMap(sqlA.getSQL(), sqlA.getMap(), 
				offset, pageSize);//使用native数据量小
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
	
	@Override
	public List getRowsInArray(SQLAssembleQ sqlA) {
		return dataDAO.sqlQuerylistAllRetArrayByMap(sqlA.getSQL(), sqlA.getMap());//使用native数据量小
	}
	@Override
	public List getRowsInArray(SQLAssembleQ sqlA, int offset,
			int pageSize) {
		return dataDAO.sqlQueryfindRetArrayByPageByMap(sqlA.getSQL(), sqlA.getMap(), 
				offset, pageSize);//使用native数据量小
	}
	@Override
	public int add(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();
		
		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}

	public int add(Map data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addRetId(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();
		//nextval  CURRVAL
		Integer id = Integer.valueOf(
				dataDAO.sqlQueryfindaValueByMap("select " + INIT.AUTH_schema + "." + absConstant.getPrimaryKeySequence()+".nextval from dual", new HashMap() ).toString()
				);
		
		Map valueMap = new HashMap();
		valueMap.put(absConstant.getPrimaryKeyColumnName(), id);
		if( !jsonObject.getJSONObject("data").containsKey("code") )
		{
			valueMap.put("C_ICODE", new DecimalFormat("000000000").format(id) );
		}
		
		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				valueMap
				);
		
		dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
		
		/* 2.返回记录ID */
		return id.intValue();
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.impl.TAuthorityInstService#addWithId(java.lang.String)
	 */
	@Override
	public int addWithId( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	@Override
	public int addWithIdRetId(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
		
//		return (Integer)sqlA.getMap().get(
//					absConstant.getBack2front().get("NLid")
//				);
		/*The below Code is dependent on front field, 
		 * but sometimes It's compatibility is better then the top Code  */
		return new Integer( sqlA.getMap().get("id").toString()).intValue() ;
	}
	
	@Override
	public void addBySavePOJO(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
		TAuthorityInst pojo = new TAuthorityInst();
		Map map =sqlA.getMap();

		pojo.setNIsuperior(new Integer( 
				String.valueOf(map.get("superior"))
				));
		pojo.setCIcode(String.valueOf(map.get("code")));
		pojo.setCIname(String.valueOf(map.get("name")));
		pojo.setNIlevel( new Short( 
				String.valueOf(map.get("level")) 
				));
		pojo.setCIleaf(String.valueOf(map.get("leaf")));
		pojo.setNItype(  new Short( 
				String.valueOf(map.get("type"))
				));
		pojo.setCImanager(String.valueOf(map.get("manager")));
		pojo.setCImtel(String.valueOf(map.get("mtel")));
		pojo.setCImemail(String.valueOf(map.get("memail")));
		pojo.setCImqq(String.valueOf(map.get("mqq")));
		pojo.setCIlinkman(String.valueOf(map.get("linkman")));
		pojo.setCIltel(String.valueOf(map.get("tel")));
		pojo.setCIlemail(String.valueOf(map.get("email")));
		pojo.setCIlqq(String.valueOf(map.get("qq")));
		pojo.setCIaddress(String.valueOf(map.get("address")));
		pojo.setCIdescription(String.valueOf(map.get("description")));

		dataDAO.save(pojo);
		
	}
	public void addBySavePOJO2( Object pojo ){
		
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.impl.TAuthorityInstService#modify(java.lang.String)
	 */
	@Override
	public int modify( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();

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
	@Override
	public Map browse(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();

		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Map)dataDAO.sqlQuerylistAllByMap(sqlA.getSQL(), sqlA.getMap()).get(0);
	}
	@Override
	public Map browseById(int id) {
		AbstractConstant absConstant = new AuthorityInst();
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
		AbstractConstant absConstant = new AuthorityInst();
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

	public Object[] browseArray(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();

		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Object[])dataDAO.sqlQuerylistAllByMap( sqlA.getSQL(), sqlA.getMap() ).get(0);
	}
	
	public TAuthorityInst browsePOJO(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();

		HQLAssembleR hqlA = new HQLAssembleR(absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2back() );
		
		return (TAuthorityInst)dataDAO.listAllByMap( "from TAuthorityInst t1 where "+hqlA.getWhereBackHQL(), hqlA.getMap() ).get(0);
	}
	public TAuthorityInst browsePOJOById(int id) {
		return dataDAO.findById( new Integer(id) );
	}
	public TAuthorityInst browsePOJOById(String id) {
		return dataDAO.findById( new Integer(id) );
	}
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.impl.TAuthorityInstService#delete(java.lang.String)
	 */
	@Override
	public int delete( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityInst();

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
	@Override
	public int deleteNP(String jdata) {
		return this.modify(jdata);
	}

	public void setDataDAO(TAuthorityInstDAO dataDAO) {
		this.dataDAO = dataDAO;
	}

	public static TAuthorityInstService getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityInstService) ctx.getBean("tAuthorityInstService");
	}

}
