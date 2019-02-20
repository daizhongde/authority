package person.daizhongde.authority.hibernate.pojo;

/**
 * TAuthorityRbrelationId entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityRbrelationId implements java.io.Serializable {

	// Fields

	private Integer NRid;
	private Integer NBid;

	// Constructors

	/** default constructor */
	public TAuthorityRbrelationId() {
	}

	/** full constructor */
	public TAuthorityRbrelationId(Integer NRid, Integer NBid) {
		this.NRid = NRid;
		this.NBid = NBid;
	}

	// Property accessors

	public Integer getNRid() {
		return this.NRid;
	}

	public void setNRid(Integer NRid) {
		this.NRid = NRid;
	}

	public Integer getNBid() {
		return this.NBid;
	}

	public void setNBid(Integer NBid) {
		this.NBid = NBid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TAuthorityRbrelationId))
			return false;
		TAuthorityRbrelationId castOther = (TAuthorityRbrelationId) other;

		return ((this.getNRid() == castOther.getNRid()) || (this.getNRid() != null
				&& castOther.getNRid() != null && this.getNRid().equals(
				castOther.getNRid())))
				&& ((this.getNBid() == castOther.getNBid()) || (this.getNBid() != null
						&& castOther.getNBid() != null && this.getNBid()
						.equals(castOther.getNBid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNRid() == null ? 0 : this.getNRid().hashCode());
		result = 37 * result
				+ (getNBid() == null ? 0 : this.getNBid().hashCode());
		return result;
	}

}