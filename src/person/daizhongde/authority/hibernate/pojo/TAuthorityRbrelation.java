package person.daizhongde.authority.hibernate.pojo;

import java.sql.Timestamp;

/**
 * TAuthorityRbrelation entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityRbrelation implements java.io.Serializable {

	// Fields

	private TAuthorityRbrelationId id;
	private String CRule;
	
	private Timestamp CCtime;
	private String CCip;
	private String CCreator;

	// Constructors

	/** default constructor */
	public TAuthorityRbrelation() {
	}

	/** minimal constructor */
	public TAuthorityRbrelation(TAuthorityRbrelationId id, Timestamp CCtime) {
		this.id = id;
		this.CCtime = CCtime;
	}

	/** full constructor */
	public TAuthorityRbrelation(TAuthorityRbrelationId id, String CRule, Timestamp CCtime,
			String CCip, String CCreator) {
		this.id = id;
		this.CRule = CRule;
		this.CCtime = CCtime;
		this.CCip = CCip;
		this.CCreator = CCreator;
	}

	// Property accessors

	public TAuthorityRbrelationId getId() {
		return this.id;
	}

	public void setId(TAuthorityRbrelationId id) {
		this.id = id;
	}

	public String getCRule() {
		return CRule;
	}

	public void setCRule(String cRule) {
		CRule = cRule;
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