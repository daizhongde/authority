package person.daizhongde.authority.hibernate.pojo;

/**
 * TAuthorityLevel entity. @author MyEclipse Persistence Tools
 */
public class TAuthorityLevel extends AbstractTAuthorityLevel implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -5862379483644234361L;

	/** default constructor */
	public TAuthorityLevel() {
	}

	/** full constructor */
	public TAuthorityLevel(Short NLid, String CLname, String CLnote) {
		super(NLid, CLname, CLnote);
	}

}
