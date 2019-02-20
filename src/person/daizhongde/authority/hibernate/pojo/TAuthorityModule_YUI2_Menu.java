package person.daizhongde.authority.hibernate.pojo;

import java.util.LinkedList;
import java.util.List;

/**
 * TAuthorityModule_Dojo_Menu entity.
 * <p>
 * id,itemdata
 * Dojo2 use data 
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityModule_YUI2_Menu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8956597380826874332L;

	private String id;
	
	private List itemdata = new LinkedList();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List getItemdata() {
		return itemdata;
	}
	public void setItemdata(List itemdata) {
		this.itemdata = itemdata;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemdata == null) ? 0 : itemdata.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TAuthorityModule_YUI2_Menu other = (TAuthorityModule_YUI2_Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemdata == null) {
			if (other.itemdata != null)
				return false;
		} else if (!itemdata.equals(other.itemdata))
			return false;
		return true;
	}
	
}
