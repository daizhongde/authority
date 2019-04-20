package person.daizhongde.authority.hibernate.pojo;

import java.util.Date;

/**
 * TAuthorityUrrelation entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityUrrelation implements java.io.Serializable {

	// Fields

	private TAuthorityUrrelationId id;
	private Date CCtime;
	private String CCip;
	private String CCreator;

	// Constructors

	/** default constructor */
	public TAuthorityUrrelation() {
	}

	/** minimal constructor */
	public TAuthorityUrrelation(TAuthorityUrrelationId id, Date CCtime) {
		this.id = id;
		this.CCtime = CCtime;
	}

	/** full constructor */
	public TAuthorityUrrelation(TAuthorityUrrelationId id, Date CCtime,
			String CCip, String CCreator) {
		this.id = id;
		this.CCtime = CCtime;
		this.CCip = CCip;
		this.CCreator = CCreator;
	}

	// Property accessors

	public TAuthorityUrrelationId getId() {
		return this.id;
	}

	public void setId(TAuthorityUrrelationId id) {
		this.id = id;
	}

	public Date getCCtime() {
		return this.CCtime;
	}

	public void setCCtime(Date CCtime) {
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