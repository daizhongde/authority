package person.daizhongde.authority.hibernate.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TAuthorityRole entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityRole implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 998009629894724981L;
	private Short NRid;
//	private TAuthorityLevel TAuthorityLevel;
	private Short NRlevel;
	private String CRno;
	private String CRname;
	private String CRnote;
	private Date CRctime;
	private String CRcip;
	private String CRcreator;
	private String CRons;
	private Date CRont;
//	private Set TAuthorityRmrelations = new HashSet(0);

	// Constructors

	/** default constructor */
	public TAuthorityRole() {
	}

	/** minimal constructor */
	public TAuthorityRole(Short NRid, Short NRlevel,
			String CRno, String CRname, Date CRctime) {
		this.NRid = NRid;
		this.NRlevel = NRlevel;
		this.CRno = CRno;
		this.CRname = CRname;
		this.CRctime = CRctime;
	}

	/** full constructor */
	public TAuthorityRole(Short NRid, Short NRlevel,
			String CRno, String CRname, String CRnote, Date CRctime,
			String CRcip, String CRcreator,
			String CRons, Date CRont) {
		this.NRid = NRid;
		this.NRlevel = NRlevel;
		this.CRno = CRno;
		this.CRname = CRname;
		this.CRnote = CRnote;
		this.CRctime = CRctime;
		this.CRcip = CRcip;
		this.CRcreator = CRcreator;
		this.CRons = CRons;
		this.CRont = CRont;
//		this.TAuthorityRmrelations = TAuthorityRmrelations;
	}

	// Property accessors

	public Short getNRid() {
		return this.NRid;
	}

	public void setNRid(Short NRid) {
		this.NRid = NRid;
	}

	public Short getNRlevel() {
		return NRlevel;
	}

	public void setNRlevel(Short nRlevel) {
		NRlevel = nRlevel;
	}

	public String getCRno() {
		return this.CRno;
	}

	public void setCRno(String CRno) {
		this.CRno = CRno;
	}

	public String getCRname() {
		return this.CRname;
	}

	public void setCRname(String CRname) {
		this.CRname = CRname;
	}

	public String getCRnote() {
		return this.CRnote;
	}

	public void setCRnote(String CRnote) {
		this.CRnote = CRnote;
	}

	public Date getCRctime() {
		return this.CRctime;
	}

	public void setCRctime(Date CRctime) {
		this.CRctime = CRctime;
	}

	public String getCRcip() {
		return this.CRcip;
	}

	public void setCRcip(String CRcip) {
		this.CRcip = CRcip;
	}

	public String getCRcreator() {
		return this.CRcreator;
	}

	public void setCRcreator(String CRcreator) {
		this.CRcreator = CRcreator;
	}

	public String getCRons() {
		return CRons;
	}

	public void setCRons(String cRons) {
		CRons = cRons;
	}

	public Date getCRont() {
		return CRont;
	}

	public void setCRont(Date cRont) {
		CRont = cRont;
	}
}