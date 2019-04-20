package person.daizhongde.authority.hibernate.pojo;

/**
 * TAuthorityModule_Dojo_Menu_Fold entity.
 * <p>
 * noleaf node entity
 * id,text,url
 * Dojo2 use data 
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityModule_YUI2_Menu_Fold implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -174918334892434001L;
	private String text;
	private TAuthorityModule_YUI2_Menu submenu;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public TAuthorityModule_YUI2_Menu getSubmenu() {
		return submenu;
	}
	public void setSubmenu(TAuthorityModule_YUI2_Menu submenu) {
		this.submenu = submenu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((submenu == null) ? 0 : submenu.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		TAuthorityModule_YUI2_Menu_Fold other = (TAuthorityModule_YUI2_Menu_Fold) obj;
		if (submenu == null) {
			if (other.submenu != null)
				return false;
		} else if (!submenu.equals(other.submenu))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
