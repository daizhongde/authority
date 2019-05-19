package person.daizhongde.authority.hibernate.pojo;

import java.util.Date;

import javax.persistence.Transient;

/**
 * TAuthorityUser_NIid entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityUser_NIid implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5157744434707155887L;
	private Long NUid;
	private TAuthorityInst TAuthorityInst;
	private Integer NIid;
//	private Integer NDid;
	private String CUlogname;
	private String CUname;
	private String CUpassword;
	private String CUsex;
	
	private String EmployeeNumber;
	private Long SupervisorId;
	
	private String CUphone;
	private String CUemail;
	private String CUqq;
	private String CUaddr;
	private String CUnote;
	private String CUtel;
	private String CUfax;
	
	private Date CUctime;
	private String CUcip;
	private String CUcreator;
	private Date CUmtime;
	private String CUmip;
	private String CUmodifier;
	private String CUons;
	private Date CUont;
	
	private String CLogins;
	private String CLoginip;
	private Date CLogint;
	private Date CLogoutt;
	
//	/** 角色名称，有多个名称用‘-’分隔 */
//	@Transient
//	private String roles;
	// Constructors

	/** default constructor */
	public TAuthorityUser_NIid() {
	}

	/** minimal constructor */
	public TAuthorityUser_NIid(Long NUid, TAuthorityInst TAuthorityInst,
			String CUlogname, String CUname, String CUpassword, String CUsex,
			String EmployeeNumber,
			Date CUctime) {
		this.NUid = NUid;
		this.TAuthorityInst = TAuthorityInst;
		this.CUlogname = CUlogname;
		this.CUname = CUname;
		this.CUpassword = CUpassword;
		this.CUsex = CUsex;
		this.EmployeeNumber = EmployeeNumber;
		this.CUctime = CUctime;
	}

	/** full constructor */
	public TAuthorityUser_NIid(Long NUid, TAuthorityInst TAuthorityInst,
			String CUlogname, String CUname, String CUpassword, String CUsex,
			String EmployeeNumber,Long SupervisorId,
			String CUphone, String CUemail, String CUqq, String CUaddr,String CUnote,
			String CUtel, String CUfax, Integer NIid, Date CUctime,
			String CUcip, String CUcreator, Date CUmtime, String CUmip,
			String CUmodifier,String CUons, Date CUont,
			String CLogins, String CLoginip, Date CLogint, Date CLogoutt ) {
		this.NUid = NUid;
		this.TAuthorityInst = TAuthorityInst;
		this.CUlogname = CUlogname;
		this.CUname = CUname;
		this.CUpassword = CUpassword;
		this.CUsex = CUsex;
		this.EmployeeNumber = EmployeeNumber;
		this.SupervisorId = SupervisorId;
		
		this.CUphone = CUphone;
		this.CUemail = CUemail;
		this.CUqq = CUqq;
		this.CUaddr = CUaddr;
		this.CUnote = CUnote;
		this.CUtel = CUtel;
		this.CUfax = CUfax;
		this.NIid = NIid;
		this.CUctime = CUctime;
		this.CUcip = CUcip;
		this.CUcreator = CUcreator;
		this.CUmtime = CUmtime;
		this.CUmip = CUmip;
		this.CUmodifier = CUmodifier;
		this.CUons = CUons;
		this.CUont = CUont;
		
		this.CLogins = CLogins;
		this.CLoginip = CLoginip;
		this.CLogint = CLogint;
		this.CLogoutt = CLogoutt;
	}

	// Property accessors

	public Long getNUid() {
		return this.NUid;
	}

	public void setNUid(Long NUid) {
		this.NUid = NUid;
	}

	public TAuthorityInst getTAuthorityInst() {
		return this.TAuthorityInst;
	}

	public void setTAuthorityInst(TAuthorityInst TAuthorityInst) {
		this.TAuthorityInst = TAuthorityInst;
	}

	public String getCUlogname() {
		return this.CUlogname;
	}

	public void setCUlogname(String CUlogname) {
		this.CUlogname = CUlogname;
	}

	public String getCUname() {
		return this.CUname;
	}

	public void setCUname(String CUname) {
		this.CUname = CUname;
	}

	public String getCUpassword() {
		return this.CUpassword;
	}

	public void setCUpassword(String CUpassword) {
		this.CUpassword = CUpassword;
	}

	public String getCUsex() {
		return this.CUsex;
	}

	public void setCUsex(String CUsex) {
		this.CUsex = CUsex;
	}

	public String getEmployeeNumber() {
		return EmployeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		EmployeeNumber = employeeNumber;
	}

	public Long getSupervisorId() {
		return SupervisorId;
	}

	public void setSupervisorId(Long supervisorId) {
		SupervisorId = supervisorId;
	}

	public String getCUphone() {
		return this.CUphone;
	}

	public void setCUphone(String CUphone) {
		this.CUphone = CUphone;
	}

	public String getCUemail() {
		return this.CUemail;
	}

	public void setCUemail(String CUemail) {
		this.CUemail = CUemail;
	}

	public String getCUqq() {
		return this.CUqq;
	}

	public void setCUqq(String CUqq) {
		this.CUqq = CUqq;
	}

	public String getCUaddr() {
		return this.CUaddr;
	}

	public void setCUaddr(String CUaddr) {
		this.CUaddr = CUaddr;
	}

	public String getCUnote() {
		return CUnote;
	}

	public void setCUnote(String cUnote) {
		CUnote = cUnote;
	}

	public String getCUtel() {
		return this.CUtel;
	}

	public void setCUtel(String CUtel) {
		this.CUtel = CUtel;
	}

	public String getCUfax() {
		return this.CUfax;
	}

	public void setCUfax(String CUfax) {
		this.CUfax = CUfax;
	}

	public Integer getNIid() {
		return this.NIid;
	}

	public void setNIid(Integer NIid) {
		this.NIid = NIid;
	}

	public Date getCUctime() {
		return this.CUctime;
	}

	public void setCUctime(Date CUctime) {
		this.CUctime = CUctime;
	}

	public String getCUcip() {
		return this.CUcip;
	}

	public void setCUcip(String CUcip) {
		this.CUcip = CUcip;
	}

	public String getCUcreator() {
		return this.CUcreator;
	}

	public void setCUcreator(String CUcreator) {
		this.CUcreator = CUcreator;
	}

	public Date getCUmtime() {
		return this.CUmtime;
	}

	public void setCUmtime(Date CUmtime) {
		this.CUmtime = CUmtime;
	}

	public String getCUmip() {
		return this.CUmip;
	}

	public void setCUmip(String CUmip) {
		this.CUmip = CUmip;
	}

	public String getCUmodifier() {
		return this.CUmodifier;
	}

	public void setCUmodifier(String CUmodifier) {
		this.CUmodifier = CUmodifier;
	}

	public String getCUons() {
		return CUons;
	}

	public void setCUons(String cUons) {
		CUons = cUons;
	}

	public Date getCUont() {
		return CUont;
	}

	public void setCUont(Date cUont) {
		CUont = cUont;
	}

	public String getCLogins() {
		return CLogins;
	}

	public void setCLogins(String cLogins) {
		CLogins = cLogins;
	}

	public String getCLoginip() {
		return CLoginip;
	}

	public void setCLoginip(String cLoginip) {
		CLoginip = cLoginip;
	}

	public Date getCLogint() {
		return CLogint;
	}

	public void setCLogint(Date cLogint) {
		CLogint = cLogint;
	}

	public Date getCLogoutt() {
		return CLogoutt;
	}

	public void setCLogoutt(Date cLogoutt) {
		CLogoutt = cLogoutt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NUid == null) ? 0 : NUid.hashCode());
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
		TAuthorityUser_NIid other = (TAuthorityUser_NIid) obj;
		if (NUid == null) {
			if (other.NUid != null)
				return false;
		} else if (!NUid.equals(other.NUid))
			return false;
		return true;
	}

}