package person.daizhongde.authority.hibernate.pojo;

/**
 * TAuthorityUrrelationId entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityUrrelationId implements java.io.Serializable {

	// Fields

	private TAuthorityUser TAuthorityUser;
	private TAuthorityRole TAuthorityRole;

	// Constructors

	/** default constructor */
	public TAuthorityUrrelationId() {
	}

	/** full constructor */
	public TAuthorityUrrelationId(TAuthorityUser TAuthorityUser,
			TAuthorityRole TAuthorityRole) {
		this.TAuthorityUser = TAuthorityUser;
		this.TAuthorityRole = TAuthorityRole;
	}

	// Property accessors

	public TAuthorityUser getTAuthorityUser() {
		return this.TAuthorityUser;
	}

	public void setTAuthorityUser(TAuthorityUser TAuthorityUser) {
		this.TAuthorityUser = TAuthorityUser;
	}

	public TAuthorityRole getTAuthorityRole() {
		return this.TAuthorityRole;
	}

	public void setTAuthorityRole(TAuthorityRole TAuthorityRole) {
		this.TAuthorityRole = TAuthorityRole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TAuthorityUrrelationId))
			return false;
		TAuthorityUrrelationId castOther = (TAuthorityUrrelationId) other;

		return ((this.getTAuthorityUser() == castOther.getTAuthorityUser()) || (this
				.getTAuthorityUser() != null
				&& castOther.getTAuthorityUser() != null && this
				.getTAuthorityUser().equals(castOther.getTAuthorityUser())))
				&& ((this.getTAuthorityRole() == castOther.getTAuthorityRole()) || (this
						.getTAuthorityRole() != null
						&& castOther.getTAuthorityRole() != null && this
						.getTAuthorityRole().equals(
								castOther.getTAuthorityRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTAuthorityUser() == null ? 0 : this.getTAuthorityUser()
						.hashCode());
		result = 37
				* result
				+ (getTAuthorityRole() == null ? 0 : this.getTAuthorityRole()
						.hashCode());
		return result;
	}

}