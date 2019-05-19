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
import person.daizhongde.authority.hibernate.pojo.TAuthorityInst;

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
public class TreeDataUtil_Inst {
	private static final Log log = LogFactory.getLog(TreeDataUtil_Inst.class);
	/**
	 * Only menu data
	 * <p>
	 * recursive assemble Data for tree
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityInst is the pojo mapping database module table
	 *            TAuthorityInst_JEasyUI_Tree and TAuthorityInst_JEasyUI_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityInst_JEasyUI_Tree is noleaf node ,TAuthorityInst_JEasyUI_Tree_Leaf is leaf node
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
	public void assembleData_JEasyUI_Tree(List dataList, TAuthorityInst parentM, int level, 
			List<TAuthorityInst> list1, List<TAuthorityInst> list2, 
			List<TAuthorityInst> list3, List<TAuthorityInst> list4, 
			List<TAuthorityInst> list5, List<TAuthorityInst> list6,
			List<TAuthorityInst> list7, List<TAuthorityInst> list8,
			List<TAuthorityInst> list9, List<TAuthorityInst> list10) {
		
//		log.debug("#########assembleData_JEasyUI_Tree###########");
		int nextLevel = level+1;
		List<TAuthorityInst> tempList = new ArrayList<TAuthorityInst>();
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
			TAuthorityInst m = (TAuthorityInst) tempList.get(i);
			if(m.getNIsuperior().compareTo( parentM.getNIid() ) == 0){
//			if(m.getTAuthorityInst().getNIid().compareTo(parentM.getNIid()) == 0){
//				System.out.println(m.getCIname()+" is "+parentM.getCIname()+"'s child");
				if ( !new Boolean(m.getCIleaf()).booleanValue() ) {// not leaf
//					System.out.println(m.getCIname()+" is not leaf ");
					List nextList = new ArrayList();
					JEasyUI_Tree mJEU = new JEasyUI_Tree();
					this.assembleData_JEasyUI_Tree(nextList, m, nextLevel, 
							list1, list2,
							list3, list4,
							list5, list6,
							list7, list8,
							list9, list10);
					
					mJEU.setId(m.getNIid());
					mJEU.setText(m.getCIname());
					
					mJEU.setState("closed");//机构树太大，关闭所有市公司节点
//					if(nextList.size()==0){
//						mJEU.setState("closed");
//					}else{
//						mJEU.setState( "open");
//					}
					
					LinkedHashMap attr1 = new LinkedHashMap();
					attr1.put("code", m.getCIcode() );
					attr1.put("level", m.getNIlevel() );
					attr1.put("type", m.getNItype() );
					attr1.put("leaf", m.getCIleaf());
					attr1.put("superior", m.getNIsuperior() );
//					attr1.put("superior", m.getTAuthorityInst().getNIid());
//					attr1.put("manager", m.getCImanager() );
//					attr1.put("mtel", m.getCImtel() );
//					attr1.put("memail", m.getCImemail() );
//					attr1.put("mqq", m.getCImqq() );
//					attr1.put("linkman", m.getCIlinkman() );
//					attr1.put("ltel", m.getCIltel() );
//					attr1.put("lemail", m.getCIlemail() );
//					attr1.put("lqq", m.getCIlqq() );
//					attr1.put("address", m.getCIaddress() );
//					attr1.put("description", m.getCIdescription() );

					mJEU.setAttributes(attr1);
					mJEU.setChildren(nextList);
					dataList.add(mJEU);
				} else{
//					System.out.println(m.getCIname()+" is leaf ");
					JEasyUI_Tree_Leaf mJEU_L = new JEasyUI_Tree_Leaf();
					mJEU_L.setId(m.getNIid());
					mJEU_L.setText(m.getCIname());
					mJEU_L.setState( "open");
					
					LinkedHashMap attr2 = new LinkedHashMap();
					attr2.put("code", m.getCIcode() );
					attr2.put("level", m.getNIlevel() );
					attr2.put("type", m.getNItype() );
					attr2.put("leaf", m.getCIleaf());
					attr2.put("superior", m.getNIsuperior() );
//					attr2.put("superior", m.getTAuthorityInst().getNIid());
//					attr2.put("manager", m.getCImanager() );
//					attr2.put("mtel", m.getCImtel() );
//					attr2.put("memail", m.getCImemail() );
//					attr2.put("mqq", m.getCImqq() );
//					attr2.put("linkman", m.getCIlinkman() );
//					attr2.put("ltel", m.getCIltel() );
//					attr2.put("lemail", m.getCIlemail() );
//					attr2.put("lqq", m.getCIlqq() );
//					attr2.put("address", m.getCIaddress() );
//					attr2.put("description", m.getCIdescription() );
					
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
	 *            TAuthorityInst is the pojo mapping database module table
	 *            TAuthorityInst_GubuSoft_Tree and TAuthorityInst_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityInst_GubuSoft_Tree is noleaf node ,TAuthorityInst_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  node's children
	 * @param list module list
	 */
	public void assembleData_JEasyUI_Tree_Async(List dataList, List<TAuthorityInst> children ) {
		
//		log.debug("#########assembleData_JEasyUI_Tree_Async  begin...###########");
		for (int i = 0, j = children.size(); i < j; i++) {
			TAuthorityInst m = (TAuthorityInst) children.get(i);
//			if(m.getTAuthorityInst().getNIid().compareTo(parentM.getNIid()) == 0){
//			if(m.getTAuthorityInst().getNIid().getNIid().compareTo( parentM.getNIid() ) == 0){
			if ( !new Boolean(m.getCIleaf()).booleanValue() ) {// not leaf
				JEasyUI_Tree mJEU = new JEasyUI_Tree();

				mJEU.setId(m.getNIid());
				mJEU.setText(m.getCIname());
				
				mJEU.setState("closed");
				
				LinkedHashMap attr1 = new LinkedHashMap();
				attr1.put("code", m.getCIcode() );
				attr1.put("level", m.getNIlevel() );
				attr1.put("type", m.getNItype() );
				attr1.put("leaf", m.getCIleaf());
				attr1.put("superior", m.getNIsuperior() );
//				attr1.put("superior", m.getTAuthorityInst().getNIid());
//				attr1.put("manager", m.getCImanager() );
//				attr1.put("mtel", m.getCImtel() );
//				attr1.put("memail", m.getCImemail() );
//				attr1.put("mqq", m.getCImqq() );
//				attr1.put("linkman", m.getCIlinkman() );
//				attr1.put("ltel", m.getCIltel() );
//				attr1.put("lemail", m.getCIlemail() );
//				attr1.put("lqq", m.getCIlqq() );
//				attr1.put("address", m.getCIaddress() );
//				attr1.put("description", m.getCIdescription() );

				mJEU.setAttributes(attr1);
//				mJEU.setChildren(nextList);
				dataList.add(mJEU);
				
			} else{
				JEasyUI_Tree_Leaf mJEU_L = new JEasyUI_Tree_Leaf();
				
				mJEU_L.setId(m.getNIid());
				mJEU_L.setText(m.getCIname());
				mJEU_L.setState( "open");
				
				LinkedHashMap attr2 = new LinkedHashMap();
				attr2.put("code", m.getCIcode() );
				attr2.put("level", m.getNIlevel() );
				attr2.put("type", m.getNItype() );
				attr2.put("leaf", m.getCIleaf());
				attr2.put("superior", m.getNIsuperior() );
//				attr2.put("superior", m.getTAuthorityInst().getNIid());
//				attr2.put("manager", m.getCImanager() );
//				attr2.put("mtel", m.getCImtel() );
//				attr2.put("memail", m.getCImemail() );
//				attr2.put("mqq", m.getCImqq() );
//				attr2.put("linkman", m.getCIlinkman() );
//				attr2.put("ltel", m.getCIltel() );
//				attr2.put("lemail", m.getCIlemail() );
//				attr2.put("lqq", m.getCIlqq() );
//				attr2.put("address", m.getCIaddress() );
//				attr2.put("description", m.getCIdescription() );
				
				mJEU_L.setAttributes(attr2);
				dataList.add(mJEU_L);
			}
//			}
		}
//		log.debug("#########assembleData_JEasyUI_Tree_Async   over! ###########");
	}
	/**
	 * recursive assemble Data for tree
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityInst is the pojo mapping database module table
	 *            TAuthorityInst_JEasyUI_Tree and TAuthorityInst_JEasyUI_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityInst_JEasyUI_Tree is noleaf node ,TAuthorityInst_JEasyUI_Tree_Leaf is leaf node
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
	public void assembleData_JEasyUI_CBT(List dataList, TAuthorityInst parentM, int level, 
			List<TAuthorityInst> list1, List<TAuthorityInst> list2, 
			List<TAuthorityInst> list3, List<TAuthorityInst> list4, 
			List<TAuthorityInst> list5, List<TAuthorityInst> list6,
			List<TAuthorityInst> list7, List<TAuthorityInst> list8,
			List<TAuthorityInst> list9, List<TAuthorityInst> list10) {
		
//		log.debug("#########assembleData_JEasyUI_CBT###########");
		int nextLevel = level+1;
		List<TAuthorityInst> tempList = new ArrayList<TAuthorityInst>();
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
			TAuthorityInst m = (TAuthorityInst) tempList.get(i);
			if(m.getNIsuperior().compareTo( parentM.getNIid() ) == 0){
//			if(m.getTAuthorityInst().getNIid().compareTo(parentM.getNIid()) == 0){
//				System.out.println(m.getCIname()+" is "+parentM.getCIname()+"'s child");
				if (!new Boolean(m.getCIleaf()).booleanValue() ) {// not leaf
//					System.out.println(m.getCIname()+" is not leaf ");
					List nextList = new ArrayList();
					JEasyUI_CBT mJEU = new JEasyUI_CBT();
					this.assembleData_JEasyUI_CBT(nextList, m, nextLevel, 
							list1, list2,
							list3, list4,
							list5, list6,
							list7, list8,
							list9, list10);
					
					mJEU.setId(new Long(m.getNIid()));
					mJEU.setText(m.getCIname());
					
					mJEU.setState("closed");//机构树太大，关闭所有市公司节点
//					if(nextList.size()==0){
//						mJEU.setState("closed");
//					}else{
//						mJEU.setState( "open");
//					}

					mJEU.setChildren(nextList);
					dataList.add(mJEU);
				} else{
//					System.out.println(m.getCIname()+" is leaf ");
					JEasyUI_CBT_Leaf mJEU_L = new JEasyUI_CBT_Leaf();
					mJEU_L.setId( new Long(m.getNIid())  );
					mJEU_L.setText(m.getCIname());
					mJEU_L.setState( "open" );
					
					dataList.add(mJEU_L);
				}
			}
		}
//		log.debug("#########assembleData_JEasyUI_CBT   over###########");
	}
	/**
	 * recursive assemble Data for JEasyUI Tree's lazy children
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityInst is the pojo mapping database module table
	 *            TAuthorityInst_GubuSoft_Tree and TAuthorityInst_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityInst_GubuSoft_Tree is noleaf node ,TAuthorityInst_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  node's children
	 * @param list module list
	 */
	public void assembleData_JEasyUI_CBT_Async(List dataList, List<TAuthorityInst> children ) {
		
//		log.debug("#########assembleData_JEasyUI_CBT_Async###########");
		for (int i = 0, j = children.size(); i < j; i++) {
			TAuthorityInst m = (TAuthorityInst) children.get(i);
//			if(m.getTAuthorityInst().getNIid().compareTo(parentM.getNIid()) == 0){
//			if(m.getTAuthorityInst().getNIid().getNIid().compareTo( parentM.getNIid() ) == 0){
			if ( !new Boolean(m.getCIleaf()).booleanValue() ) {// not leaf
				JEasyUI_CBT mJEU = new JEasyUI_CBT();
				mJEU.setId(new Long(m.getNIid()));
				mJEU.setText(m.getCIname());
				mJEU.setState("closed");
				dataList.add( mJEU );
				
			} else{
				JEasyUI_CBT_Leaf mJEU_L = new JEasyUI_CBT_Leaf();
				mJEU_L.setId( new Long(m.getNIid()) );
				mJEU_L.setText(m.getCIname());
				mJEU_L.setState( "open" );
				dataList.add( mJEU_L );
			}
//			}
		}
//		log.debug("#########assembleData_JEasyUI_CBT_Async   over###########");
	}
	/**
	 * recursive assemble Data for tree
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityInst is the pojo mapping database module table
	 *            TAuthorityInst_JEasyUI_Tree and TAuthorityInst_JEasyUI_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityInst_JEasyUI_Tree is noleaf node ,TAuthorityInst_JEasyUI_Tree_Leaf is leaf node
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
	public void assembleData_JEasyUI_FullTree(List dataList, TAuthorityInst parentM, int level, 
			List<TAuthorityInst> list1, List<TAuthorityInst> list2, 
			List<TAuthorityInst> list3, List<TAuthorityInst> list4, 
			List<TAuthorityInst> list5, List<TAuthorityInst> list6,
			List<TAuthorityInst> list7, List<TAuthorityInst> list8,
			List<TAuthorityInst> list9, List<TAuthorityInst> list10) {
		
//		log.debug("#########assembleData_JEasyUI_FullTree###########");
		int nextLevel = level+1;
		List<TAuthorityInst> tempList = new ArrayList<TAuthorityInst>();
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
			TAuthorityInst m = (TAuthorityInst) tempList.get(i);
			if(m.getNIsuperior().compareTo( parentM.getNIid() ) == 0){
//			if(m.getTAuthorityInst().getNIid().compareTo(parentM.getNIid()) == 0){
//				System.out.println(m.getCIname()+" is "+parentM.getCIname()+"'s child");
				if ( !new Boolean(m.getCIleaf()).booleanValue() ) {// not leaf
//					System.out.println(m.getCIname()+" is not leaf ");
					List nextList = new ArrayList();
					JEasyUI_Tree mJEU = new JEasyUI_Tree();
					this.assembleData_JEasyUI_FullTree(nextList, m, nextLevel, 
							list1, list2,
							list3, list4,
							list5, list6,
							list7, list8,
							list9, list10);
					
					mJEU.setId(m.getNIid());
					mJEU.setText(m.getCIname());
					
					mJEU.setState("closed");//机构树太大，关闭所有市公司节点
//					if(nextList.size()==0){
//						mJEU.setState("closed");
//					}else{
//						mJEU.setState( "open");
//					}
					
					LinkedHashMap attr1 = new LinkedHashMap();
					attr1.put("code", m.getCIcode() );
					attr1.put("level", m.getNIlevel() );
					attr1.put("type", m.getNItype() );
					attr1.put("leaf", m.getCIleaf());
					attr1.put("superior", m.getNIsuperior() );
//					attr1.put("superior", m.getTAuthorityInst().getNIid());
					attr1.put("manager", m.getCImanager() );
					attr1.put("mtel", m.getCImtel() );
					attr1.put("memail", m.getCImemail() );
					attr1.put("mqq", m.getCImqq() );
					attr1.put("linkman", m.getCIlinkman() );
					attr1.put("ltel", m.getCIltel() );
					attr1.put("lemail", m.getCIlemail() );
					attr1.put("lqq", m.getCIlqq() );
					attr1.put("address", m.getCIaddress() );
					attr1.put("description", m.getCIdescription() );

					mJEU.setAttributes(attr1);
					mJEU.setChildren(nextList);
					dataList.add(mJEU);
				} else{
//					System.out.println(m.getCIname()+" is leaf ");
					JEasyUI_Tree_Leaf mJEU_L = new JEasyUI_Tree_Leaf();
					mJEU_L.setId(m.getNIid());
					mJEU_L.setText(m.getCIname());
					mJEU_L.setState( "open");
					
					LinkedHashMap attr2 = new LinkedHashMap();
					attr2.put("code", m.getCIcode() );
					attr2.put("level", m.getNIlevel() );
					attr2.put("type", m.getNItype() );
					attr2.put("leaf", m.getCIleaf());
					attr2.put("superior", m.getNIsuperior() );
//					attr2.put("superior", m.getTAuthorityInst().getNIid());
					attr2.put("manager", m.getCImanager() );
					attr2.put("mtel", m.getCImtel() );
					attr2.put("memail", m.getCImemail() );
					attr2.put("mqq", m.getCImqq() );
					attr2.put("linkman", m.getCIlinkman() );
					attr2.put("ltel", m.getCIltel() );
					attr2.put("lemail", m.getCIlemail() );
					attr2.put("lqq", m.getCIlqq() );
					attr2.put("address", m.getCIaddress() );
					attr2.put("description", m.getCIdescription() );
					
					mJEU_L.setAttributes(attr2);
					dataList.add(mJEU_L);
				}
			}
		}
//		log.debug("#########assembleData_JEasyUI_FullTree   over###########");
	}
	/**
	 * recursive assemble Data for JEasyUI Tree's lazy children
	 * attention： max level is ten,exclude rootnode
	 *            TAuthorityInst is the pojo mapping database module table
	 *            TAuthorityInst_GubuSoft_Tree and TAuthorityInst_GubuSoft_Tree_Leaf must overload method hasCode and equals
	 *            TAuthorityInst_GubuSoft_Tree is noleaf node ,TAuthorityInst_GubuSoft_Tree_Leaf is leaf node
	 *            a method and a little code accomplished this function perfect
	 * @param dataList  node's children
	 * @param list module list
	 */
	public void assembleData_JEasyUI_FullTree_Async(List dataList, List<TAuthorityInst> children ) {
		
//		log.debug("#########assembleData_JEasyUI_FullTree_Async###########");
		for (int i = 0, j = children.size(); i < j; i++) {
			TAuthorityInst m = (TAuthorityInst) children.get(i);
//			if(m.getTAuthorityInst().getNIid().compareTo(parentM.getNIid()) == 0){
//			if(m.getTAuthorityInst().getNIid().getNIid().compareTo( parentM.getNIid() ) == 0){
			if ( !new Boolean(m.getCIleaf()).booleanValue() ) {// not leaf
				JEasyUI_Tree mJEU = new JEasyUI_Tree();
				
				mJEU.setId(m.getNIid());
				mJEU.setText(m.getCIname());
				
				mJEU.setState("closed");
				
				LinkedHashMap attr1 = new LinkedHashMap();
				attr1.put("code", m.getCIcode() );
				attr1.put("level", m.getNIlevel() );
				attr1.put("type", m.getNItype() );
				attr1.put("leaf", m.getCIleaf());
				attr1.put("superior", m.getNIsuperior() );
//				attr1.put("superior", m.getTAuthorityInst().getNIid());
				attr1.put("manager", m.getCImanager() );
				attr1.put("mtel", m.getCImtel() );
				attr1.put("memail", m.getCImemail() );
				attr1.put("mqq", m.getCImqq() );
				attr1.put("linkman", m.getCIlinkman() );
				attr1.put("ltel", m.getCIltel() );
				attr1.put("lemail", m.getCIlemail() );
				attr1.put("lqq", m.getCIlqq() );
				attr1.put("address", m.getCIaddress() );
				attr1.put("description", m.getCIdescription() );

				mJEU.setAttributes(attr1);
//				mJEU.setChildren(nextList);
				dataList.add(mJEU);
				
			} else{
				JEasyUI_Tree_Leaf mJEU_L = new JEasyUI_Tree_Leaf();
				
				mJEU_L.setId(m.getNIid());
				mJEU_L.setText(m.getCIname());
				mJEU_L.setState( "open");
				
				LinkedHashMap attr2 = new LinkedHashMap();
				attr2.put("code", m.getCIcode() );
				attr2.put("level", m.getNIlevel() );
				attr2.put("type", m.getNItype() );
				attr2.put("leaf", m.getCIleaf());
				attr2.put("superior", m.getNIsuperior() );
//				attr2.put("superior", m.getTAuthorityInst().getNIid());
				attr2.put("manager", m.getCImanager() );
				attr2.put("mtel", m.getCImtel() );
				attr2.put("memail", m.getCImemail() );
				attr2.put("mqq", m.getCImqq() );
				attr2.put("linkman", m.getCIlinkman() );
				attr2.put("ltel", m.getCIltel() );
				attr2.put("lemail", m.getCIlemail() );
				attr2.put("lqq", m.getCIlqq() );
				attr2.put("address", m.getCIaddress() );
				attr2.put("description", m.getCIdescription() );
				
				mJEU_L.setAttributes(attr2);
				dataList.add(mJEU_L);
			}
//			}
		}
//		log.debug("#########assembleData_JEasyUI_FullTree_Async   over###########");
	}
}
