package person.daizhongde.authority.hibernate.pojo;

import java.util.LinkedHashMap;


/**
 * TAuthorityModule entity.
 * leaf node entity
 * id,text,iconCls,attributes
 * @author MyEclipse Persistence Tools
 */
public class JEasyUI_CBT_Leaf implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5490135395716545037L;
	private Long id;
	private String text;
	/** closed, open.  default is 'open'  **/
	private String state;//add by daizhongde,date:2013/10/12
	private String iconCls;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((iconCls == null) ? 0 : iconCls.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		JEasyUI_CBT_Leaf other = (JEasyUI_CBT_Leaf) obj;
		if (iconCls == null) {
			if (other.iconCls != null)
				return false;
		} else if (!iconCls.equals(other.iconCls))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
