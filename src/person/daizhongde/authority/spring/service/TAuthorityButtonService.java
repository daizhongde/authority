package person.daizhongde.authority.spring.service;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityButton;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;

import person.daizhongde.virtue.spring.BaseService;

public interface TAuthorityButtonService extends BaseService{

	public abstract int add( String jdata, TAuthorityUser user );
	/**
	 * 此方法在操作时可能会存在主键冲突，所以最好还是采用先全部删除再逐条插入的方式
	 * @param rows
	 * @return 删除和行数+更新的行数+插入的行数
	 */
	public abstract void curdAllinOne( List<TAuthorityButton> rows, Integer module_id );
	/**
	 * 目前此方法采用先刪除再插入的方式實現
	 * @param rows
	 * @param module_id
	 */
	public abstract void mergeRecords( List<TAuthorityButton> rows, Integer module_id );
}