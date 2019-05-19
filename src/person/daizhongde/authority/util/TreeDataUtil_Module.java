package person.daizhongde.authority.util;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import person.daizhongde.authority.hibernate.pojo.JEasyUI_CBT;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_CBT_Leaf;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_Tree;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_Tree_Leaf;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_Dojo_Tree_LazyNode;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_Ext_Tree;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_Ext_Tree_LazyNode;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_Ext_Tree_Leaf;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_GubuSoft_Tree;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_GubuSoft_Tree_Leaf;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_JEasyUI_TreeGrid;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_JEasyUI_TreeGrid_Leaf;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_YUI2_Menu;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_YUI2_Menu_Fold;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule_YUI2_Menu_Leaf;

/**
 * 
 * 组装菜单树所需的json数据类
 * <p>
 * 注：
 * <br>java 方法参数传递：
 * <br>pojo和list类型参数都是引用传递
 * 
 * @author dzd
 *
 */
public class TreeDataUtil_Module {
	private static final Log log = LogFactory.getLog(TreeDataUtil_Module.class);
	/**
	 * recursive assemble Data for treegrid
	 * attention： max level is seven,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModuleJEU and TAuthorityModuleJEU_L must overload method hasCode and equals
	 *            TAuthorityModuleJEU is noleaf node ,TAuthorityModuleJEU_L is leaf node
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
	public void assembleData_JEasyUI_Treegrid(List dataList, TAuthorityModule parentM, int level, 
			List<TAuthorityModule> list1, List<TAuthorityModule> list2, 
			List<TAuthorityModule> list3, List<TAuthorityModule> list4, 
			List<TAuthorityModule> list5, List<TAuthorityModule> list6,
			List<TAuthorityModule> list7, List<TAuthorityModule> list8, 
			List<TAuthorityModule> list9, List<TAuthorityModule> list10) {
		
		int nextLevel = level+1; 
		List<TAuthorityModule> tempList = new ArrayList<TAuthorityModule>();
		switch (level) {
		case 0: break;
		case 1: tempList = list1; break;
		case 2: tempList = list2; break;
		case 3: tempList = list3; break;
		case 4:	tempList = list4; break;
		case 5:	tempList = list5; break;
		case 6:	tempList = list6; break;
		case 7: tempList = list7; break;
		case 8:	tempList = list8; break;
		case 9:	tempList = list9; break;
		case 10:tempList = list10;break;
		default:
			System.out.println("level:"+level);
			System.out.println("module level invalid!");
		}
		for (int i = 0, j = tempList.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) tempList.get(i);
			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
				if ( !new Boolean( m.getCMleaf() ) ) {// not leaf
					List nextList = new ArrayList();
					TAuthorityModule_JEasyUI_TreeGrid m3 = new TAuthorityModule_JEasyUI_TreeGrid();
					assembleData_JEasyUI_Treegrid(nextList, m, nextLevel,
							list1, list2,
							list3, list4,
							list5, list6,
							list7, list8,
							list9, list10);
					m3.setId(m.getNMid());
					m3.setText(m.getCMname());
					m3.setNote(m.getCMnote());
					m3.setChildren(nextList);
					dataList.add(m3);
				} else{
					TAuthorityModule_JEasyUI_TreeGrid_Leaf m3L = new TAuthorityModule_JEasyUI_TreeGrid_Leaf();
					m3L.setId(m.getNMid());
					m3L.setText(m.getCMname());
					m3L.setUrl(m.getCMpath());
					m3L.setNote(m.getCMnote());
					dataList.add(m3L);
				}
			}
		}
	}
	/**
	 * Only menu data
	 * <p>
	 * recursive assemble Data for tree
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_JEasyUI_Tree and TAuthorityModule_JEasyUI_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_JEasyUI_Tree is noleaf node ,TAuthorityModule_JEasyUI_Tree_Leaf is leaf node
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
	public void assembleData_JEasyUI_Tree(List dataList, TAuthorityModule parentM, int level, 
			List<TAuthorityModule> list1, List<TAuthorityModule> list2, 
			List<TAuthorityModule> list3, List<TAuthorityModule> list4, 
			List<TAuthorityModule> list5, List<TAuthorityModule> list6,
			List<TAuthorityModule> list7, List<TAuthorityModule> list8,
			List<TAuthorityModule> list9, List<TAuthorityModule> list10) {
		
//		log.debug("#########assembleData_JEasyUI_Tree###########");
		int nextLevel = level+1;
		List<TAuthorityModule> tempList = new ArrayList<TAuthorityModule>();
		switch (level) {
		case 0: break;
		case 1: tempList = list1; break;
		case 2:	tempList = list2; break;
		case 3:	tempList = list3; break;
		case 4:	tempList = list4; break;
		case 5:	tempList = list5; break;
		case 6:	tempList = list6; break;
		case 7:	tempList = list7; break;
		case 8:	tempList = list8; break;
		case 9:	tempList = list9; break;
		case 10:tempList = list10;break;
		default:
			System.out.println("level:"+level);
			System.out.println("module level invalid!");
		}
		for (int i = 0, j = tempList.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) tempList.get(i);
			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
//				System.out.println(m.getCMname()+" is "+parentM.getCMname()+"'s child");
				if ( !new Boolean(m.getCMleaf()).booleanValue() ) {// not leaf
//					System.out.println(m.getCMname()+" is not leaf ");
					List nextList = new ArrayList();
					JEasyUI_Tree mJEU = new JEasyUI_Tree();
					this.assembleData_JEasyUI_Tree(nextList, m, nextLevel, 
							list1, list2,
							list3, list4,
							list5, list6,
							list7, list8,
							list9, list10);
					
					LinkedHashMap attr1 = new LinkedHashMap();
					mJEU.setId(m.getNMid());
					mJEU.setText(m.getCMname());
					mJEU.setIconCls(m.getCMiconcls());
					mJEU.setChecked( new Boolean( m.getCMchecked() ).booleanValue() );
					
					if(nextList.size()==0){
						mJEU.setState("closed");
					}else{
						mJEU.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
					}
					
					attr1.put("url", m.getCMpath());
					mJEU.setAttributes(attr1);
					mJEU.setChildren(nextList);
					dataList.add(mJEU);
				} else{
//					System.out.println(m.getCMname()+" is leaf ");
					JEasyUI_Tree_Leaf mJEU_L = new JEasyUI_Tree_Leaf();
					LinkedHashMap attr2 = new LinkedHashMap();
					mJEU_L.setId(m.getNMid());
					mJEU_L.setText(m.getCMname());
					mJEU_L.setIconCls(m.getCMiconcls());
					mJEU_L.setChecked( new Boolean( m.getCMchecked() ).booleanValue() );
					
					mJEU_L.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
					
					attr2.put("url", m.getCMpath());
					mJEU_L.setAttributes(attr2);
					dataList.add(mJEU_L);
				}
			}
		}
//		log.debug("#########assembleData_JEasyUI_Tree   over###########");
	}
	
	/**
	 * recursive assemble Data for JEasyUI Tree's lazy children
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_GubuSoft_Tree and TAuthorityModule_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_GubuSoft_Tree is noleaf node ,TAuthorityModule_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  node's children
	 * @param list module list
	 */
	public void assembleData_JEasyUI_Tree_Async(List dataList, List<TAuthorityModule> children ) {
		
//		log.debug("#########assembleData_JEasyUI_Tree_Async  begin...###########");
		for (int i = 0, j = children.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) children.get(i);
//			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
			if ( !new Boolean(m.getCMleaf()).booleanValue() ) {// not leaf
				JEasyUI_Tree mJEU = new JEasyUI_Tree();
				LinkedHashMap attr1 = new LinkedHashMap();
				mJEU.setId(m.getNMid());
				mJEU.setText(m.getCMname());
				
				//Folder node should set state closed
				mJEU.setState("closed");
//				mJEU.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
				mJEU.setIconCls(m.getCMiconcls());
				attr1.put("url", m.getCMpath());
				mJEU.setAttributes(attr1);
				dataList.add( mJEU );
			} else{
				JEasyUI_Tree_Leaf mJEU_L = new JEasyUI_Tree_Leaf();
				LinkedHashMap attr2 = new LinkedHashMap();
				mJEU_L.setId(m.getNMid());
				mJEU_L.setText(m.getCMname());
				mJEU_L.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
				mJEU_L.setIconCls(m.getCMiconcls());
				attr2.put("url", m.getCMpath());
				mJEU_L.setAttributes(attr2);
				dataList.add( mJEU_L );
			}
//			}
		}
//		log.debug("#########assembleData_JEasyUI_Tree_Async   over! ###########");
	}
	/**
	 * recursive assemble Data for tree
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_JEasyUI_Tree and TAuthorityModule_JEasyUI_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_JEasyUI_Tree is noleaf node ,TAuthorityModule_JEasyUI_Tree_Leaf is leaf node
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
	public void assembleData_JEasyUI_CBT(List dataList, TAuthorityModule parentM, int level, 
			List<TAuthorityModule> list1, List<TAuthorityModule> list2, 
			List<TAuthorityModule> list3, List<TAuthorityModule> list4, 
			List<TAuthorityModule> list5, List<TAuthorityModule> list6,
			List<TAuthorityModule> list7, List<TAuthorityModule> list8,
			List<TAuthorityModule> list9, List<TAuthorityModule> list10) {
		
//		log.debug("#########assembleData_JEasyUI_CBT###########");
		int nextLevel = level+1;
		List<TAuthorityModule> tempList = new ArrayList<TAuthorityModule>();
		switch (level) {
		case 0: break;
		case 1: tempList = list1; break;
		case 2:	tempList = list2; break;
		case 3:	tempList = list3; break;
		case 4:	tempList = list4; break;
		case 5:	tempList = list5; break;
		case 6:	tempList = list6; break;
		case 7:	tempList = list7; break;
		case 8:	tempList = list8; break;
		case 9:	tempList = list9; break;
		case 10:tempList = list10;break;
		default:
			System.out.println("level:"+level);
			System.out.println("module level invalid!");
		}
		for (int i = 0, j = tempList.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) tempList.get(i);
			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
//				System.out.println(m.getCMname()+" is "+parentM.getCMname()+"'s child");
				if ( !new Boolean(m.getCMleaf()).booleanValue() ) {// not leaf
//					System.out.println(m.getCMname()+" is not leaf ");
					List nextList = new ArrayList();
					JEasyUI_CBT mJEU = new JEasyUI_CBT();
					this.assembleData_JEasyUI_CBT(nextList, m, nextLevel, 
							list1, list2,
							list3, list4,
							list5, list6,
							list7, list8,
							list9, list10);
					
					mJEU.setId(new Long(m.getNMid()));
					mJEU.setText(m.getCMname());
					if(nextList.size()==0){
						mJEU.setState("closed");
					}else{
						mJEU.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
					}
					mJEU.setIconCls(m.getCMiconcls());
					mJEU.setChildren(nextList);
					dataList.add(mJEU);
				} else{
//					System.out.println(m.getCMname()+" is leaf ");
					JEasyUI_CBT_Leaf mJEU_L = new JEasyUI_CBT_Leaf();
					mJEU_L.setId( new Long(m.getNMid()) );
					mJEU_L.setText(m.getCMname());
					mJEU_L.setState( null==m.getCMexpanded() || m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
					mJEU_L.setIconCls(m.getCMiconcls());
					dataList.add(mJEU_L);
				}
			}
		}
//		log.debug("#########assembleData_JEasyUI_CBT   over###########");
	}
	/**
	 * recursive assemble Data for JEasyUI Tree's lazy children
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_GubuSoft_Tree and TAuthorityModule_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_GubuSoft_Tree is noleaf node ,TAuthorityModule_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  node's children
	 * @param list module list
	 */
	public void assembleData_JEasyUI_CBT_Async(List dataList, List<TAuthorityModule> children ) {
		
//		log.debug("#########assembleData_JEasyUI_CBT_Async###########");
		for (int i = 0, j = children.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) children.get(i);
//			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
			if ( !new Boolean(m.getCMleaf()).booleanValue() ) {// not leaf
				JEasyUI_CBT mJEU = new JEasyUI_CBT();
				mJEU.setId(new Long(m.getNMid()));
				mJEU.setText(m.getCMname());
				mJEU.setState("closed");
//				mJEU.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
				mJEU.setIconCls(m.getCMiconcls());
				dataList.add( mJEU );
				
			} else{
				JEasyUI_CBT_Leaf mJEU_L = new JEasyUI_CBT_Leaf();
				mJEU_L.setId( new Long(m.getNMid()));
				mJEU_L.setText(m.getCMname());
				mJEU_L.setState( null==m.getCMexpanded()||m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
				mJEU_L.setIconCls(m.getCMiconcls());
				dataList.add( mJEU_L );
			}
//			}
		}
//		log.debug("#########assembleData_JEasyUI_CBT_Async   over###########");
	}
	/**
	 * recursive assemble Data for tree
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_JEasyUI_Tree and TAuthorityModule_JEasyUI_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_JEasyUI_Tree is noleaf node ,TAuthorityModule_JEasyUI_Tree_Leaf is leaf node
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
	public void assembleData_JEasyUI_Dndtree(List dataList, TAuthorityModule parentM, int level, 
			List<TAuthorityModule> list1, List<TAuthorityModule> list2, 
			List<TAuthorityModule> list3, List<TAuthorityModule> list4, 
			List<TAuthorityModule> list5, List<TAuthorityModule> list6,
			List<TAuthorityModule> list7, List<TAuthorityModule> list8,
			List<TAuthorityModule> list9, List<TAuthorityModule> list10) {
		
//		log.debug("#########assembleData_JEasyUI_Dndtree###########");
		int nextLevel = level+1;
		List<TAuthorityModule> tempList = new ArrayList<TAuthorityModule>();
		switch (level) {
		case 0: break;
		case 1: tempList = list1; break;
		case 2:	tempList = list2; break;
		case 3:	tempList = list3; break;
		case 4:	tempList = list4; break;
		case 5:	tempList = list5; break;
		case 6:	tempList = list6; break;
		case 7:	tempList = list7; break;
		case 8:	tempList = list8; break;
		case 9:	tempList = list9; break;
		case 10:tempList = list10;break;
		default:
			System.out.println("level:"+level);
			System.out.println("module level invalid!");
		}
		for (int i = 0, j = tempList.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) tempList.get(i);
			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
//				System.out.println(m.getCMname()+" is "+parentM.getCMname()+"'s child");
				if ( !new Boolean(m.getCMleaf()).booleanValue() ) {// not leaf
//					System.out.println(m.getCMname()+" is not leaf ");
					List nextList = new ArrayList();
					JEasyUI_Tree mJEU = new JEasyUI_Tree();
					this.assembleData_JEasyUI_Dndtree(nextList, m, nextLevel, 
							list1, list2,
							list3, list4,
							list5, list6,
							list7, list8,
							list9, list10);
					
					LinkedHashMap attr1 = new LinkedHashMap();
					mJEU.setId(m.getNMid());
					mJEU.setText(m.getCMname());
					if(nextList.size()==0){
						mJEU.setState("closed");
					}else{
						mJEU.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
					}
					
					mJEU.setIconCls(m.getCMiconcls());
					attr1.put("leaf", m.getCMleaf());
					attr1.put("level", m.getNMlevel());
					attr1.put("parent", m.getNMparent());
//					attr1.put("parent", m.getNMparent().getNMid());
					attr1.put("order", m.getNMorder());
					attr1.put("iconcls", m.getCMiconcls());
					attr1.put("expanded", m.getCMexpanded());
					attr1.put("checked", m.getCMchecked());
					attr1.put("url", m.getCMpath());
					attr1.put("note", m.getCMnote());
					mJEU.setAttributes(attr1);
					mJEU.setChildren(nextList);
					
					dataList.add(mJEU);
				} else{
//					System.out.println(m.getCMname()+" is leaf ");
					JEasyUI_Tree_Leaf mJEU_L = new JEasyUI_Tree_Leaf();
					LinkedHashMap attr2 = new LinkedHashMap();
					mJEU_L.setId(m.getNMid());
					mJEU_L.setText(m.getCMname());
					mJEU_L.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
					mJEU_L.setIconCls(m.getCMiconcls());
					
					attr2.put("leaf", m.getCMleaf());
					attr2.put("level", m.getNMlevel());
					attr2.put("parent", m.getNMparent());
//					attr2.put("parent", m.getNMparent().getNMid());
					attr2.put("order", m.getNMorder());
					attr2.put("iconcls", m.getCMiconcls());
					attr2.put("expanded", m.getCMexpanded());
					attr2.put("checked", m.getCMchecked());
					attr2.put("url", m.getCMpath());
					attr2.put("note", m.getCMnote());
					mJEU_L.setAttributes(attr2);
					
					dataList.add(mJEU_L);
				}
			}
		}
//		log.debug("#########assembleData_JEasyUI_Dndtree   over###########");
	}
	/**
	 * recursive assemble Data for JEasyUI Tree's lazy children
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_GubuSoft_Tree and TAuthorityModule_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_GubuSoft_Tree is noleaf node ,TAuthorityModule_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  node's children
	 * @param list module list
	 */
	public void assembleData_JEasyUI_Dndtree_Async(List dataList, List<TAuthorityModule> children ) {
		
//		log.debug("#########assembleData_JEasyUI_Dndtree_Async###########");
		for (int i = 0, j = children.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) children.get(i);
//			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
			if ( !new Boolean(m.getCMleaf()).booleanValue() ) {// not leaf
				JEasyUI_Tree mJEU = new JEasyUI_Tree();
				
				LinkedHashMap attr1 = new LinkedHashMap();
				mJEU.setId(m.getNMid());
				mJEU.setText(m.getCMname());
				
				//Folder node should set state closed
				mJEU.setState("closed");
//				mJEU.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
				
				mJEU.setIconCls(m.getCMiconcls());
				
				attr1.put("leaf", m.getCMleaf());
				attr1.put("level", m.getNMlevel());
				attr1.put("parent", m.getNMparent());
//				attr1.put("parent", m.getNMparent().getNMid());
				attr1.put("order", m.getNMorder());
				attr1.put("iconcls", m.getCMiconcls());
				attr1.put("expanded", m.getCMexpanded());
				attr1.put("checked", m.getCMchecked());
				attr1.put("url", m.getCMpath());
				attr1.put("note", m.getCMnote());
				mJEU.setAttributes(attr1);
				
				dataList.add( mJEU );
				
			} else{
				JEasyUI_Tree_Leaf mJEU_L = new JEasyUI_Tree_Leaf();
				LinkedHashMap attr2 = new LinkedHashMap();
				mJEU_L.setId(m.getNMid());
				mJEU_L.setText(m.getCMname());
				mJEU_L.setState( m.getCMexpanded().trim().equalsIgnoreCase("true") ? "open" : "closed" );//add by daizhongde,date:2013/10/12
				mJEU_L.setIconCls(m.getCMiconcls());
				
				attr2.put("leaf", m.getCMleaf());
				attr2.put("level", m.getNMlevel());
				attr2.put("parent", m.getNMparent());
//				attr2.put("parent", m.getNMparent().getNMid());
				attr2.put("order", m.getNMorder());
				attr2.put("iconcls", m.getCMiconcls());
				attr2.put("expanded", m.getCMexpanded());
				attr2.put("checked", m.getCMchecked());
				attr2.put("url", m.getCMpath());
				attr2.put("note", m.getCMnote());
				mJEU_L.setAttributes(attr2);
				
				dataList.add( mJEU_L );
			}
//			}
		}
//		log.debug("#########assembleData_JEasyUI_Dndtree_Async   over###########");
	}
	/**
	 * recursive assemble Data for GubuSoft TreeView
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_GubuSoft_Tree and TAuthorityModule_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_GubuSoft_Tree is noleaf node ,TAuthorityModule_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  root's children
	 * @param parentM  this is noleaf
	 * @param level  the level of the nodes that will be add
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
	public void assembleData_GubuSoft_Tree(List dataList, TAuthorityModule parentM, int level, 
			List<TAuthorityModule> list1, List<TAuthorityModule> list2, 
			List<TAuthorityModule> list3, List<TAuthorityModule> list4, 
			List<TAuthorityModule> list5, List<TAuthorityModule> list6,
			List<TAuthorityModule> list7, List<TAuthorityModule> list8,
			List<TAuthorityModule> list9, List<TAuthorityModule> list10) {
		
//		log.debug("#########assembleData_GubuSoft_Tree###########");
		int nextLevel = level+1; 
		List<TAuthorityModule> tempList = new ArrayList<TAuthorityModule>();
		switch (level) {
			case 0: break;
			case 1: tempList = list1; break;
			case 2:	tempList = list2; break;
			case 3:	tempList = list3; break;
			case 4:	tempList = list4; break;
			case 5:	tempList = list5; break;
			case 6:	tempList = list6; break;
			case 7:	tempList = list7; break;
			case 8:	tempList = list8; break;
			case 9:	tempList = list9; break;
			case 10:tempList = list10;break;
			default:
				System.out.println("level:"+level);
				System.out.println("module level invalid!");
		}
		for (int i = 0, j = tempList.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) tempList.get(i);
			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
				if ( !new Boolean(m.getCMleaf()).booleanValue() ) {// not leaf
					List nextList = new ArrayList();
					TAuthorityModule_GubuSoft_Tree gbsTvM = new TAuthorityModule_GubuSoft_Tree();
					this.assembleData_GubuSoft_Tree(nextList, m, nextLevel, 
							list1, list2,
							list3, list4,
							list5, list6,
							list7, list8,
							list9, list10);
					
					gbsTvM.setId(m.getNMid());
					gbsTvM.setText(m.getCMname());
					gbsTvM.setIconcls(m.getCMiconcls());
					gbsTvM.setChildren(nextList);
					
					dataList.add(gbsTvM);
					
				} else{
					TAuthorityModule_GubuSoft_Tree_Leaf gbsTvM_L = new TAuthorityModule_GubuSoft_Tree_Leaf();
					gbsTvM_L.setId(m.getNMid());
					gbsTvM_L.setText(m.getCMname());
					gbsTvM_L.setIconcls(m.getCMiconcls());
					gbsTvM_L.setTarget(m.getCMtarget());
					gbsTvM_L.setUrl(m.getCMpath());
					
					dataList.add(gbsTvM_L);
				}
			}
		}
//		log.debug("#########assembleData_GubuSoft_Tree   over###########");
	}
	
	/**
	 * 
	 * @param dataList
	 * @param parentM
	 * @param level The level of the nodes that will be add
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
	public void assembleData_YUI2_Menu(List dataList, TAuthorityModule parentM, int level, 
			List<TAuthorityModule> list1, List<TAuthorityModule> list2, 
			List<TAuthorityModule> list3, List<TAuthorityModule> list4, 
			List<TAuthorityModule> list5, List<TAuthorityModule> list6,
			List<TAuthorityModule> list7, List<TAuthorityModule> list8,
			List<TAuthorityModule> list9, List<TAuthorityModule> list10) {
		
//		log.debug("#########assembleData_YUI2_Menu###########");
		int nextLevel = level+1; 
		List<TAuthorityModule> tempList = new ArrayList<TAuthorityModule>();
		switch (level) {
			case 0: break;
			case 1: tempList = list1; break;
			case 2:	tempList = list2; break;
			case 3:	tempList = list3; break;
			case 4:	tempList = list4; break;
			case 5:	tempList = list5; break;
			case 6:	tempList = list6; break;
			case 7:	tempList = list7; break;
			case 8:	tempList = list8; break;
			case 9:	tempList = list9; break;
			case 10:tempList = list10;break;
			default:
				System.out.println("level:"+level);
				System.out.println("module level invalid!");
		}
		for (int i = 0, j = tempList.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) tempList.get(i);
			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//				System.out.println("m.getNMparent():"+m.getNMparent()+", parentM.getNMid():"+parentM.getNMid());
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
				if (!new Boolean(m.getCMleaf())) {// not leaf
					List nextList = new ArrayList();
					TAuthorityModule_YUI2_Menu yui2MenuItem = new TAuthorityModule_YUI2_Menu();
					
					TAuthorityModule_YUI2_Menu_Fold dojoMenuM_F = new TAuthorityModule_YUI2_Menu_Fold();
					
					//####################   menu item #######  begin
					yui2MenuItem.setId(m.getNMid().toString());
					this.assembleData_YUI2_Menu(nextList, m, nextLevel, 
							list1, list2,
							list3, list4,
							list5, list6,
							list7, list8,
							list9, list10);
					
					yui2MenuItem.setItemdata(nextList);
					//####################   menu  item #######  end
					
					dojoMenuM_F.setText(m.getCMname());
					dojoMenuM_F.setSubmenu(yui2MenuItem);
					
					dataList.add(dojoMenuM_F);
					
				} else{
					TAuthorityModule_YUI2_Menu_Leaf dojoMenuM_L = new TAuthorityModule_YUI2_Menu_Leaf();
//					dojoMenuM_L.setId(m.getNMid());
					dojoMenuM_L.setText(m.getCMname());
//					dojoMenuM_L.setIconcls(m.getCMiconcls());
//					dojoMenuM_L.setTarget(m.getCMtarget());
					dojoMenuM_L.setUrl(m.getCMpath());
					dataList.add(dojoMenuM_L);
				}
			}
		}
//		log.debug("#########assembleData_YUI2_Menu   over###########");
	}
	
	/**
	 * recursive assemble Data for Dojo Tree's lazy children
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_GubuSoft_Tree and TAuthorityModule_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_GubuSoft_Tree is noleaf node ,TAuthorityModule_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  node's children
	 * @param list module list
	 */
	public void assembleData_Dojo_Tree_Async(List dataList, List<TAuthorityModule> children ) {
		
//		log.debug("#########assembleData_Dojo_Tree_Async###########");
		for (int i = 0, j = children.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) children.get(i);
//			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
			if ( !new Boolean(m.getCMleaf()).booleanValue() ) {// not leaf
				TAuthorityModule_Dojo_Tree_LazyNode dojoTvM = new TAuthorityModule_Dojo_Tree_LazyNode();
//				List nextList = new ArrayList();
//				this.assembleData_GubuSoft_Tree(nextList, m, nextLevel, 
//						list1, list2,
//						list3, list4,
//						list5, list6,
//						list7, list8,
//						list9, list10);
				
				dojoTvM.setId(m.getNMid());
				dojoTvM.setText(m.getCMname());
				dojoTvM.setIconcls(m.getCMiconcls());
				dojoTvM.setChildren(true);
				
				dataList.add(dojoTvM);
				
			} else{
				TAuthorityModule_GubuSoft_Tree_Leaf gbsTvM_L = new TAuthorityModule_GubuSoft_Tree_Leaf();
				gbsTvM_L.setId(m.getNMid());
				gbsTvM_L.setText(m.getCMname());
				gbsTvM_L.setIconcls(m.getCMiconcls());
				gbsTvM_L.setTarget(m.getCMtarget());
				gbsTvM_L.setUrl(m.getCMpath());
				
				dataList.add(gbsTvM_L);
			}
//			}
		}
//		log.debug("#########assembleData_Dojo_Tree_Async   over###########");
	}
	
	/**
	 * recursive assemble Data for Ext Tree's lazy children
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_GubuSoft_Tree and TAuthorityModule_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_GubuSoft_Tree is noleaf node ,TAuthorityModule_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  node's children
	 * @param list module list
	 */
	public void assembleData_Ext_Tree_Async(List dataList, List<TAuthorityModule> children ) {
		
//		log.debug("#########assembleData_Ext_Tree_Async###########");
		for (int i = 0, j = children.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) children.get(i);
//			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
			if ( !new Boolean(m.getCMleaf()).booleanValue() ) {// not leaf
				TAuthorityModule_Ext_Tree_LazyNode extTvM = new TAuthorityModule_Ext_Tree_LazyNode();
//				List nextList = new ArrayList();
//				this.assembleData_Ext_Tree(nextList, m, nextLevel, 
//						list1, list2, list3, list4, list5, 
//						list6, list7, list8, list9, list10);
				
				extTvM.setId(m.getNMid());
				extTvM.setText(m.getCMname());
				extTvM.setCls(m.getCMiconcls());
				extTvM.setTarget(m.getCMtarget());
				extTvM.setUrl(m.getCMpath());
				
				//Folder node should set state closed
				extTvM.setExpanded(false);
//				extTvM.setExpanded(Boolean.parseBoolean(m.getCMexpanded()));
				
				extTvM.setChildren(true);
				dataList.add(extTvM);
				
			} else {
				TAuthorityModule_Ext_Tree_Leaf extTvM_L = new TAuthorityModule_Ext_Tree_Leaf();
				extTvM_L.setId(m.getNMid());
				extTvM_L.setText(m.getCMname());
				extTvM_L.setLeaf(true);
				extTvM_L.setCls(m.getCMiconcls());
				extTvM_L.setTarget(m.getCMtarget());
				extTvM_L.setUrl(m.getCMpath());
				dataList.add(extTvM_L);
			}
//			}
		}
//		log.debug("#########assembleData_Ext_Tree_Async   over###########");
	}
	
	
	/**
	 * recursive assemble Data for Ext3 and Ext4 Tree
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityModule is the pojo mapping database module table
	 *            TAuthorityModule_Ext_Tree and TAuthorityModule_Ext_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityModule_Ext_Tree is noleaf node ,TAuthorityModule_Ext_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  root's children
	 * @param parentM  this is noleaf
	 * @param level  the level of the nodes that will be add
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
	public void assembleData_Ext_Tree(List dataList, TAuthorityModule parentM, int level, 
			List<TAuthorityModule> list1, List<TAuthorityModule> list2, 
			List<TAuthorityModule> list3, List<TAuthorityModule> list4, 
			List<TAuthorityModule> list5, List<TAuthorityModule> list6,
			List<TAuthorityModule> list7, List<TAuthorityModule> list8,
			List<TAuthorityModule> list9, List<TAuthorityModule> list10) {
		
//		log.debug("#########assembleData_Ext_Tree###########");
		int nextLevel = level+1; 
		List<TAuthorityModule> tempList = new ArrayList<TAuthorityModule>();
		switch (level) {
		case 0: break;
		case 1: tempList = list1; break;
		case 2:	tempList = list2; break;
		case 3:	tempList = list3; break;
		case 4:	tempList = list4; break;
		case 5:	tempList = list5; break;
		case 6:	tempList = list6; break;
		case 7:	tempList = list7; break;
		case 8:	tempList = list8; break;
		case 9:	tempList = list9; break;
		case 10:tempList = list10;break;
		default:
			System.out.println("level:"+level);
			System.out.println("module level invalid!");
		}
		for (int i = 0, j = tempList.size(); i < j; i++) {
			TAuthorityModule m = (TAuthorityModule) tempList.get(i);
			if(m.getNMparent().compareTo(parentM.getNMid()) == 0){
//			if(m.getNMparent().getNMid().compareTo( parentM.getNMid() ) == 0){
				if (!new Boolean(m.getCMleaf())) {// not leaf
					List nextList = new ArrayList();
					TAuthorityModule_Ext_Tree extTvM = new TAuthorityModule_Ext_Tree();
					this.assembleData_Ext_Tree(nextList, m, nextLevel, 
							list1, list2, list3, list4, list5, 
							list6, list7, list8, list9, list10);
					extTvM.setId(m.getNMid());
					extTvM.setText(m.getCMname());
					extTvM.setCls(m.getCMiconcls());
					extTvM.setTarget(m.getCMtarget());
					extTvM.setUrl(m.getCMpath());
					
					if(nextList.size()==0){
						extTvM.setExpanded(false);
					}else{
						extTvM.setExpanded(Boolean.parseBoolean(m.getCMexpanded()) );//add by daizhongde,date:2013/10/12
					}
					
					extTvM.setChildren(nextList);
					dataList.add(extTvM);
				} else{
					TAuthorityModule_Ext_Tree_Leaf extTvM_L = new TAuthorityModule_Ext_Tree_Leaf();
					extTvM_L.setId(m.getNMid());
					extTvM_L.setText(m.getCMname());
					extTvM_L.setLeaf(true);
					extTvM_L.setCls(m.getCMiconcls());
					extTvM_L.setTarget(m.getCMtarget());
					extTvM_L.setUrl(m.getCMpath());
					dataList.add(extTvM_L);
				}
			}
		}
//		log.debug("#########assembleData_Ext_Tree   over###########");
	}
}
