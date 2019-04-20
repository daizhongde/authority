package person.daizhongde.authority.hibernate.pojo;

/**
 * AbstractTAuthorityLevel entity provides the base persistence definition of
 * the TAuthorityLevel entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTAuthorityLevel implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7516233836852983221L;
	private Short NLid;
	private String CLname;
	private String CLnote;

	// Constructors

	/** default constructor */
	public AbstractTAuthorityLevel() {
	}

	/** full constructor */
	public AbstractTAuthorityLevel(Short NLid, String CLname, String CLnote) {
		this.NLid = NLid;
		this.CLname = CLname;
		this.CLnote = CLnote;
	}

	// Property accessors

	public Short getNLid() {
		return this.NLid;
	}

	public void setNLid(Short NLid) {
		this.NLid = NLid;
	}

	public String getCLname() {
		return this.CLname;
	}

	public void setCLname(String CLname) {
		this.CLname = CLname;
	}

	public String getCLnote() {
		return CLnote;
	}

	public void setCLnote(String cLnote) {
		CLnote = cLnote;
	}

}