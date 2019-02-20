package person.daizhongde.authority.hibernate.pojo;

import java.sql.Timestamp;

/**
 * TAuthorityFunc entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityFunc implements java.io.Serializable {

	// Fields

	private Short NFid;
	private String CFcode;
	private String CFname;
	private Timestamp CCtime;
	private String CCip;
	private String CCreator;

	// Constructors

	/** default constructor */
	public TAuthorityFunc() {
	}

	/** minimal constructor */
	public TAuthorityFunc(Short NFid, String CFcode, String CFname,
			Timestamp CCtime) {
		this.NFid = NFid;
		this.CFcode = CFcode;
		this.CFname = CFname;
		this.CCtime = CCtime;
	}

	/** full constructor */
	public TAuthorityFunc(Short NFid, String CFcode, String CFname,
			Timestamp CCtime, String CCip, String CCreator) {
		this.NFid = NFid;
		this.CFcode = CFcode;
		this.CFname = CFname;
		this.CCtime = CCtime;
		this.CCip = CCip;
		this.CCreator = CCreator;
	}

	// Property accessors

	public Short getNFid() {
		return this.NFid;
	}

	public void setNFid(Short NFid) {
		this.NFid = NFid;
	}

	public String getCFcode() {
		return this.CFcode;
	}

	public void setCFcode(String CFcode) {
		this.CFcode = CFcode;
	}

	public String getCFname() {
		return this.CFname;
	}

	public void setCFname(String CFname) {
		this.CFname = CFname;
	}

	public Timestamp getCCtime() {
		return this.CCtime;
	}

	public void setCCtime(Timestamp CCtime) {
		this.CCtime = CCtime;
	}

	public String getCCip() {
		return this.CCip;
	}

	public void setCCip(String CCip) {
		this.CCip = CCip;
	}

	public String getCCreator() {
		return this.CCreator;
	}

	public void setCCreator(String CCreator) {
		this.CCreator = CCreator;
	}

}