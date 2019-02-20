package person.daizhongde.authority.util;

import java.util.LinkedHashMap;
import java.util.List;

import person.daizhongde.authority.hibernate.pojo.JEasyUI_Tree_Leaf;
import person.daizhongde.authority.hibernate.pojo.TAuthorityLevel;
import person.daizhongde.authority.hibernate.pojo.TAuthorityRole;

public class TreeDataUtil_Role {

	/**
	 * Only menu data
	 * <p>
	 * recursive assemble Data for tree
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityRole is the pojo mapping database module table
	 *            JEasyUI_Tree and JEasyUI_Tree_Leaf must overload method hasCode and equals
	 *            JEasyUI_Tree is noleaf node ,JEasyUI_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  save menu JSON data
	 * @param parentM  this is noleaf
	 * @param level  the level of the nodes that will add
	 * @param list1
	 * @param list2
	 * @param list3
	 * @param list4
	 * @param list5
	 * @param list6
	 * @param list7
	 * @param list8
	 * @param list9
	 * @param list10
	 */
	public void assembleData_JEasyUI_Tree(List dataList, TAuthorityLevel parentM, List<TAuthorityRole> list2) {
		
//		log.debug("#########assembleData_JEasyUI_Tree###########");
		
		String ip;//store checked state sometimes
		
		for (int i = 0, j = list2.size(); i < j; i++) {
			TAuthorityRole r = (TAuthorityRole) list2.get(i);
//			if( r.getTAuthorityLevel().getNLid().compareTo( parentM.getNLid() ) == 0){
			if( r.getNRlevel().compareTo( parentM.getNLid() ) == 0){
				JEasyUI_Tree_Leaf mJEU_L = new JEasyUI_Tree_Leaf();
				LinkedHashMap attr2 = new LinkedHashMap();
				
				mJEU_L.setId( new Integer(r.getNRid().intValue()) );
				mJEU_L.setText( r.getCRname() );
				mJEU_L.setState( "open" );
				
				ip = r.getCRcip();
				if( ip!=null && (ip.trim().equalsIgnoreCase("true") || ip.trim().equalsIgnoreCase("false")) )
				{
					mJEU_L.setChecked( new Boolean( ip ).booleanValue() );
				}
				else
				{
					mJEU_L.setChecked( false );
				}
				
				attr2.put("no", r.getCRno() );
				attr2.put("level", new Integer(2) );
//				attr2.put("rlevel", r.getTAuthorityLevel().getNLid() );
				attr2.put("rlevel", r.getNRlevel() );
				attr2.put("note", r.getCRnote() );

				mJEU_L.setAttributes(attr2);
				dataList.add(mJEU_L);
			}
		}
//		log.debug("#########assembleData_JEasyUI_Tree   over###########");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
