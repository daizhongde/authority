package person.daizhongde.authority.util;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import person.daizhongde.authority.hibernate.pojo.JEasyUI_CBT;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_CBT_Leaf;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_Tree;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_Tree_Leaf;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;

/**
 * 
 * 组装机构树所需的json数据类
 * <p>
 * 注：
 * <br>java 方法参数传递：
 * <br>pojo和list类型参数都是引用传递
 * 
 * @author dzd
 *
 */
public class TreeDataUtil_User {
	private static final Log log = LogFactory.getLog(TreeDataUtil_User.class);
	/**
	 * recursive assemble Data for JEasyUI Tree's lazy children
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityUser is the pojo mapping database module table
	 *            TAuthorityUser_GubuSoft_Tree and TAuthorityUser_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityUser_GubuSoft_Tree is noleaf node ,TAuthorityUser_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  node's children
	 * @param list module list
	 */
	public void assembleData_JEasyUI_CBT_Async(List dataList, List<TAuthorityUser> children ) {
		
//		log.debug("#########assembleData_JEasyUI_CBT_Async###########");
		for (int i = 0, j = children.size(); i < j; i++) {
			TAuthorityUser m = (TAuthorityUser) children.get(i);
//			if(m.getTAuthorityUser().getNIid().compareTo(parentM.getNIid()) == 0){
//			if(m.getTAuthorityUser().getNIid().getNIid().compareTo( parentM.getNIid() ) == 0){
			if ( m.getFollowerNum() != 0 ) {// not leaf
				JEasyUI_CBT mJEU = new JEasyUI_CBT();
				mJEU.setId( new Long(m.getNUid()) );
				mJEU.setText( m.getTAuthorityInst().getCIname() +"-" + m.getCUname()+ "("+m.getFollowerNum()+")" );
				mJEU.setState("closed");
				dataList.add( mJEU );
				
			} else{ // 下属数量为0
				JEasyUI_CBT_Leaf mJEU_L = new JEasyUI_CBT_Leaf();
				mJEU_L.setId( m.getNUid() );
				mJEU_L.setText( m.getTAuthorityInst().getCIname()+"-"+m.getCUname()  );
				mJEU_L.setState( "open" );
				dataList.add( mJEU_L );
			}
//			}
		}
//		log.debug("#########assembleData_JEasyUI_CBT_Async   over###########");
	}
}
