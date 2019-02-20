package person.daizhongde.authority.hibernate.pojo;

/**
 * TAuthorityModule entity.
 * noleaf node entity
 * id,text,url
 * dojo lazy load tree use data
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityModule_Dojo_Tree_LazyNode implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8166229424880625080L;
	private Integer id;
	private String text;
	private String iconcls;
	
	private boolean children;
	
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
	public boolean getChildren() {
		return children;
	}
	public void setChildren(boolean children) {
		this.children = children;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (children ? 1231 : 1237);
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
		TAuthorityModule_Dojo_Tree_LazyNode other = (TAuthorityModule_Dojo_Tree_LazyNode) obj;
		if (children != other.children)
			return false;
		if (iconcls == null) {
			if (other.iconcls != null)
				return false;
		} else if (!iconcls.equals(other.iconcls))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
