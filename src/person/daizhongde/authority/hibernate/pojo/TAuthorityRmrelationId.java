package person.daizhongde.authority.hibernate.pojo;

/**
 * TAuthorityRmrelationId entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityRmrelationId implements java.io.Serializable {

	// Fields

	private Integer NRid;
	private Integer NMid;

	// Constructors

	/** default constructor */
	public TAuthorityRmrelationId() {
	}

	/** full constructor */
	public TAuthorityRmrelationId(Integer NRid, Integer NMid) {
		this.NRid = NRid;
		this.NMid = NMid;
	}

	// Property accessors

	public Integer getNRid() {
		return this.NRid;
	}

	public void setNRid(Integer NRid) {
		this.NRid = NRid;
	}

	public Integer getNMid() {
		return this.NMid;
	}

	public void setNMid(Integer NMid) {
		this.NMid = NMid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TAuthorityRmrelationId))
			return false;
		TAuthorityRmrelationId castOther = (TAuthorityRmrelationId) other;

		return ((this.getNRid() == castOther.getNRid()) || (this.getNRid() != null
				&& castOther.getNRid() != null && this.getNRid().equals(
				castOther.getNRid())))
				&& ((this.getNMid() == castOther.getNMid()) || (this.getNMid() != null
						&& castOther.getNMid() != null && this.getNMid()
						.equals(castOther.getNMid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNRid() == null ? 0 : this.getNRid().hashCode());
		result = 37 * result
				+ (getNMid() == null ? 0 : this.getNMid().hashCode());
		return result;
	}

}