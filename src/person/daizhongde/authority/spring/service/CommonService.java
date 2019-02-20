package person.daizhongde.authority.spring.service;

import java.util.Map;

public interface CommonService {
	/**
	 * get DB table names
	 * @return
	 */
	public abstract String getTableNames();
	public abstract Map getTableNames_Map();
}
