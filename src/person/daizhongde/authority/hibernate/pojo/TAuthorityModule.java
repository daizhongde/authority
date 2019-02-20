package person.daizhongde.authority.hibernate.pojo;

import java.util.Date;

/**
 * TAuthorityModule entity. @author MyEclipse Persistence Tools
 */
public class TAuthorityModule extends AbstractTAuthorityModule implements
		java.io.Serializable {

	// Constructors 

	/**
	 * 
	 */
	private static final long serialVersionUID = -4099067365842214143L;

	/** default constructor */
	public TAuthorityModule() {
	}

	/** minimal constructor */
	public TAuthorityModule(Integer NMid, String CMname, Short NMlevel,
			String CMleaf, Short NMorder, Date CMctime) {
		super(NMid, CMname, NMlevel, CMleaf, NMorder, CMctime);
	}

	/** full constructor */
	public TAuthorityModule(Integer NMid, String CMname, Short NMlevel,
			String CMleaf, Short NMorder, Integer NMparent, String CMtarget,
			String CMiconcls, String CMexpanded, String CMchecked,
			String CMpath, String CMnote, Date CMctime, String CMcip,
			String CMcreator, Date CMmtime, String CMmip, String CMmodifier,String CMons, Date CMont) {
		super(NMid, CMname, NMlevel, CMleaf, NMorder, NMparent, CMtarget,
				CMiconcls, CMexpanded, CMchecked, CMpath, CMnote, CMctime,
				CMcip, CMcreator, CMmtime, CMmip, CMmodifier, CMons, CMont);
	}

}
