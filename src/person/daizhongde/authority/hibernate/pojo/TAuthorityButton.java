package person.daizhongde.authority.hibernate.pojo;

/**
 * TAuthorityButton entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityButton implements java.io.Serializable {

	// Fields

	private Integer NBid;
	private String CBcode;
	private String CBname;
	private String url;
	private String remark;
	private Integer NMid;

	// Constructors

	/** default constructor */
	public TAuthorityButton() {
	}

	/** minimal constructor */
	public TAuthorityButton(String CBcode, String CBname, String url,
			Integer NMid) {
		this.CBcode = CBcode;
		this.CBname = CBname;
		this.url = url;
		this.NMid = NMid;
	}

	/** full constructor */
	public TAuthorityButton(String CBcode, String CBname, String url,
			String remark, Integer NMid) {
		this.CBcode = CBcode;
		this.CBname = CBname;
		this.url = url;
		this.remark = remark;
		this.NMid = NMid;
	}

	// Property accessors

	public Integer getNBid() {
		return this.NBid;
	}

	public void setNBid(Integer NBid) {
		this.NBid = NBid;
	}

	public String getCBcode() {
		return this.CBcode;
	}

	public void setCBcode(String CBcode) {
		this.CBcode = CBcode;
	}

	public String getCBname() {
		return this.CBname;
	}

	public void setCBname(String CBname) {
		this.CBname = CBname;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getNMid() {
		return this.NMid;
	}

	public void setNMid(Integer NMid) {
		this.NMid = NMid;
	}

}