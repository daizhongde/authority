package person.daizhongde.authority.hibernate.pojo;

import java.util.LinkedList;
import java.util.List;

/**
 * TAuthorityModule entity.
 * noleaf node entity
 * id,text,url
 * gubusoft treeview use data (also is compatible with fason\wefxtree)
 * <b>also is used by dojo lazy load
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityModule_GubuSoft_Tree implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8166229424880625080L;
	private Integer id;
	private String text;
	private String iconcls;
	
	private List children = new LinkedList();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getIconcls() {
		return iconcls;
	}
	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}
	public List getChildren() {
		return children;
	}
	public void setChildren(List children) {
		this.children = children;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((iconcls == null) ? 0 : iconcls.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TAuthorityModule_GubuSoft_Tree other = (TAuthorityModule_GubuSoft_Tree) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (iconcls == null) {
			if (other.iconcls != null)
				return false;
		} else if (!iconcls.equals(other.iconcls))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
