package com.asiainfo.authority.spring.jdbc;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;

import com.asiainfo.authority.constant.AuthorityLevel;
import com.asiainfo.authority.constant.AuthorityModule;
import com.asiainfo.authority.hibernate.dao.TAuthorityModuleDAO;
import com.asiainfo.authority.hibernate.pojo.JEasyUI_CBT;
import com.asiainfo.authority.hibernate.pojo.JEasyUI_Tree;
import com.asiainfo.authority.hibernate.pojo.TAuthorityModule;
import com.asiainfo.authority.hibernate.pojo.TAuthorityModule_Ext_Tree;
import com.asiainfo.authority.hibernate.pojo.TAuthorityModule_GubuSoft_Tree;
import com.asiainfo.authority.hibernate.pojo.TAuthorityModule_YUI2_Menu;
import com.asiainfo.authority.spring.service.TAuthorityModuleService;
import com.asiainfo.authority.util.TreeDataUtil_Module;

import person.daizhongde.virtue.assemble.hql.HQLAssembleQ;
import person.daizhongde.virtue.assemble.hql.HQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleC;
import person.daizhongde.virtue.assemble.sql.SQLAssembleD;
import person.daizhongde.virtue.assemble.sql.SQLAssembleE;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ_CBB;
import person.daizhongde.virtue.assemble.sql.SQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleU;
import person.daizhongde.virtue.configutils.SQLNode;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.constant.Algorithm;
import person.daizhongde.virtue.constant.EXPORT;
import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.constant.Operator;
import person.daizhongde.virtue.constant.Progress;
import person.daizhongde.virtue.constant.Progresses;
import person.daizhongde.virtue.spring.BaseImportService;
import person.daizhongde.virtue.util.ie.HSSFWorkbookUtil4Export;
import person.daizhongde.virtue.config.IESemaphore;
import person.daizhongde.virtue.util.ie.TXTUtil;
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
public class TAuthorityModuleServiceImpl_IMP implements BaseImportService {
	private static final Log log = LogFactory.getLog(TAuthorityModuleServiceImpl_IMP.class);
	
	private TAuthorityModuleDAO dataDAO;
	
	@Override
	public void importXLS(File file,String uploadContentType,  String _) throws Exception {
		// TODO Auto-generated method stub
//		return null;
	}

	@Override
	public void importXLS(File file, String uploadContentType, String _, List columnNames)
			throws Exception {
		// TODO Auto-generated method stub
//		return null;
	}

	@Override
	public void importXLS(File file,String uploadContentType,  String _, Map options) throws Exception {
		// TODO Auto-generated method stub
//		return null;
	}

	@Override
	public void importXLS(File file, String uploadContentType, String _, List columnNames, Map options)
			throws Exception {
		// TODO Auto-generated method stub
//		return null;
	}

	@Override
	public void importTXT(File file, String _) throws Exception {
		// TODO Auto-generated method stub
//		return null;
	}

	@Override
	public void importTXT(File file, String _, List columnNames)
			throws Exception {
		// TODO Auto-generated method stub
//		return null;
	}

	@Override
	public void importTXT(File file, String _, Map options) throws Exception {
		// TODO Auto-generated method stub
//		return null;
	}

	@Override
	public void importTXT(File file, String _, List columnNames, Map options)
			throws Exception {
		// TODO Auto-generated method stub
//		return null;
	}


	public void setDataDAO(TAuthorityModuleDAO dataDAO) {
		this.dataDAO = dataDAO;
	}

	public static BaseImportService getFromApplicationContext(
			ApplicationContext ctx) {
		return (BaseImportService) ctx.getBean("tAuthorityModuleService_IMP");
	}
}
