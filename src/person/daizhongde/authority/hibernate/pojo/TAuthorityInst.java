package person.daizhongde.authority.hibernate.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TAuthorityInst entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityInst implements java.io.Serializable {

	// Fields

	private Integer NIid;
	private Integer NIsuperior;
//	private TAuthorityInst NIsuperior;
	
	private String CIcode;
	private String CIname;
	private Short NIlevel;
	private String CIleaf;
	private Short NItype;
	private String CImanager;
	private String CImtel;
	private String CImemail;
	private String CImqq;
	private String CIlinkman;
	private String CIltel;
	private String CIlemail;
	private String CIlqq;
	private String CIaddress;
	private String CIdescription;
	private Date CIctime;
	private String CIcip;
	private String CIcreator;
	private Date CImtime;
	private String CImip;
	private String CImodifier;
	private String Jsddm;
	private String CIons;
	private Date CIont;
	private Set TAuthorityInsts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TAuthorityInst() {
	}

	/** minimal constructor */
	public TAuthorityInst(Integer NIid, String CIcode, String CIname,
			Short NIlevel, String CIleaf, Date CIctime) {
		this.NIid = NIid;
		this.CIcode = CIcode;
		this.CIname = CIname;
		this.NIlevel = NIlevel;
		this.CIleaf = CIleaf;
		this.CIctime = CIctime;
	}

	/** full constructor */
	public TAuthorityInst(Integer NIid, Integer NIsuperior,
			String CIcode, String CIname, Short NIlevel, String CIleaf,
			Short NItype, String CImanager, String CImtel, String CImemail,
			String CImqq, String CIlinkman, String CIltel, String CIlemail,
			String CIlqq, String CIaddress, String CIdescription, Date CIctime,
			String CIcip, String CIcreator, Date CImtime, String CImip,
			String CImodifier, String Jsddm,
			String CIons, Date CIont, Set TAuthorityInsts) {
		this.NIid = NIid;
		this.NIsuperior = NIsuperior;
		this.CIcode = CIcode;
		this.CIname = CIname;
		this.NIlevel = NIlevel;
		this.CIleaf = CIleaf;
		this.NItype = NItype;
		this.CImanager = CImanager;
		this.CImtel = CImtel;
		this.CImemail = CImemail;
		this.CImqq = CImqq;
		this.CIlinkman = CIlinkman;
		this.CIltel = CIltel;
		this.CIlemail = CIlemail;
		this.CIlqq = CIlqq;
		this.CIaddress = CIaddress;
		this.CIdescription = CIdescription;
		this.CIctime = CIctime;
		this.CIcip = CIcip;
		this.CIcreator = CIcreator;
		this.CImtime = CImtime;
		this.CImip = CImip;
		this.CImodifier = CImodifier;
		this.Jsddm = Jsddm;
		this.CIons = CIons;
		this.CIont = CIont;
		this.TAuthorityInsts = TAuthorityInsts;
	}

	// Property accessors

	public Integer getNIid() {
		return this.NIid;
	}

	public void setNIid(Integer NIid) {
		this.NIid = NIid;
	}

//	public TAuthorityInst getTAuthorityInst() {
//		return this.TAuthorityInst;
//	}
//
//	public void setTAuthorityInst(TAuthorityInst TAuthorityInst) {
//		this.TAuthorityInst = TAuthorityInst;
//	}

	public String getCIcode() {
		return this.CIcode;
	}

	public Integer getNIsuperior() {
		return NIsuperior;
	}

	public void setNIsuperior(Integer nIsuperior) {
		NIsuperior = nIsuperior;
	}

	public void setCIcode(String CIcode) {
		this.CIcode = CIcode;
	}

	public String getCIname() {
		return this.CIname;
	}

	public void setCIname(String CIname) {
		this.CIname = CIname;
	}

	public Short getNIlevel() {
		return this.NIlevel;
	}

	public void setNIlevel(Short NIlevel) {
		this.NIlevel = NIlevel;
	}

	public String getCIleaf() {
		return this.CIleaf;
	}

	public void setCIleaf(String CIleaf) {
		this.CIleaf = CIleaf;
	}

	public Short getNItype() {
		return this.NItype;
	}

	public void setNItype(Short NItype) {
		this.NItype = NItype;
	}

	public String getCImanager() {
		return this.CImanager;
	}

	public void setCImanager(String CImanager) {
		this.CImanager = CImanager;
	}

	public String getCImtel() {
		return this.CImtel;
	}

	public void setCImtel(String CImtel) {
		this.CImtel = CImtel;
	}

	public String getCImemail() {
		return this.CImemail;
	}

	public void setCImemail(String CImemail) {
		this.CImemail = CImemail;
	}

	public String getCImqq() {
		return this.CImqq;
	}

	public void setCImqq(String CImqq) {
		this.CImqq = CImqq;
	}

	public String getCIlinkman() {
		return this.CIlinkman;
	}

	public void setCIlinkman(String CIlinkman) {
		this.CIlinkman = CIlinkman;
	}

	public String getCIltel() {
		return this.CIltel;
	}

	public void setCIltel(String CIltel) {
		this.CIltel = CIltel;
	}

	public String getCIlemail() {
		return this.CIlemail;
	}

	public void setCIlemail(String CIlemail) {
		this.CIlemail = CIlemail;
	}

	public String getCIlqq() {
		return this.CIlqq;
	}

	public void setCIlqq(String CIlqq) {
		this.CIlqq = CIlqq;
	}

	public String getCIaddress() {
		return this.CIaddress;
	}

	public void setCIaddress(String CIaddress) {
		this.CIaddress = CIaddress;
	}

	public String getCIdescription() {
		return this.CIdescription;
	}

	public void setCIdescription(String CIdescription) {
		this.CIdescription = CIdescription;
	}

	public Date getCIctime() {
		return this.CIctime;
	}

	public void setCIctime(Date CIctime) {
		this.CIctime = CIctime;
	}

	public String getCIcip() {
		return this.CIcip;
	}

	public void setCIcip(String CIcip) {
		this.CIcip = CIcip;
	}

	public String getCIcreator() {
		return this.CIcreator;
	}

	public void setCIcreator(String CIcreator) {
		this.CIcreator = CIcreator;
	}

	public Date getCImtime() {
		return this.CImtime;
	}

	public void setCImtime(Date CImtime) {
		this.CImtime = CImtime;
	}

	public String getCImip() {
		return this.CImip;
	}

	public void setCImip(String CImip) {
		this.CImip = CImip;
	}

	public String getCImodifier() {
		return this.CImodifier;
	}

	public void setCImodifier(String CImodifier) {
		this.CImodifier = CImodifier;
	}

	public String getJsddm() {
		return Jsddm;
	}

	public void setJsddm(String jsddm) {
		Jsddm = jsddm;
	}

	public String getCIons() {
		return CIons;
	}

	public void setCIons(String cIons) {
		CIons = cIons;
	}

	public Date getCIont() {
		return CIont;
	}

	public void setCIont(Date cIont) {
		CIont = cIont;
	}

	public Set getTAuthorityInsts() {
		return this.TAuthorityInsts;
	}

	public void setTAuthorityInsts(Set TAuthorityInsts) {
		this.TAuthorityInsts = TAuthorityInsts;
	}

}