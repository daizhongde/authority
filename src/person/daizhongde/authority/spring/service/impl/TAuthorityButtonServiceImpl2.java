package person.daizhongde.authority.spring.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.constant.AuthorityButton;
import person.daizhongde.authority.hibernate.batch.HibernateBatchInsert;
import person.daizhongde.authority.hibernate.dao.TAuthorityButtonDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityButton;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;
import person.daizhongde.authority.spring.service.TAuthorityButtonService2;

import person.daizhongde.virtue.assemble.hql.HQLAssembleQ;
import person.daizhongde.virtue.assemble.hql.HQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleC;
import person.daizhongde.virtue.assemble.sql.SQLAssembleD;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ_CBB;
import person.daizhongde.virtue.assemble.sql.SQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleU;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.constant.Operator;
import person.daizhongde.virtue.spring.BaseServiceImpl2;

public class TAuthorityButtonServiceImpl2 extends BaseServiceImpl2<TAuthorityButton, Integer> 
	implements TAuthorityButtonService2 {

	private static final Log log = LogFactory.getLog(TAuthorityButtonServiceImpl2.class);
	
	private TAuthorityButtonDAO dataDAO;

	public int add(String jdata, TAuthorityUser user ) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityButton();

		Map data = jsonObject.getJSONObject("data");
		data.put("author", user.getCUlogname() );
		
		SQLAssembleC sqlA = new SQLAssembleC(
				absConstant.getTableName(),
				data,
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	public void curdAllinOne( List<TAuthorityButton> rows, Integer module_id) {
		// TODO Auto-generated method stub
		
	}
	public void mergeRecords( List<TAuthorityButton> rows, Integer module_id) {
		Map condition = new HashMap();
		condition.put("n_mid", module_id);
//		dataDAO.sqlQueryExeUByMap("delete from "+ , condition);
		
		AbstractConstant absConstant = new AuthorityButton();

		SQLAssembleD sqlA = new SQLAssembleD(
				INIT.AUTH_schema,
				absConstant.getSQLDOC(),
				absConstant.getTableName(), 
				condition,
				null,
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap() );
		for(TAuthorityButton e : rows){
			dataDAO.save(e);
		}
//		HibernateBatchInsert batch = new HibernateBatchInsert();
//		batch.batchInsert(rows);
	}
	public void setDataDAO(TAuthorityButtonDAO dataDAO) {
		this.dataDAO = dataDAO;
		super.setBaseDao(dataDAO);
	}
	public static TAuthorityButtonService2 getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityButtonService2) ctx.getBean("tAuthorityButtonService2");
	}

}
