package person.daizhongde.authority.hibernate.pojo;


/**
 * TAuthorityModule_Dojo_Menu_Leaf entity.
 * <p>
 * leaf node entity
 * text,url
 * Dojo2 menu use data
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityModule_YUI2_Menu_Leaf implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5728275452813882849L;
	private String text;
	private String url;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		TAuthorityModule_YUI2_Menu_Leaf other = (TAuthorityModule_YUI2_Menu_Leaf) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

}
