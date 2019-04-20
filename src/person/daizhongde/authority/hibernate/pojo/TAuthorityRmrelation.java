package person.daizhongde.authority.hibernate.pojo;

import java.sql.Timestamp;

/**
 * TAuthorityRmrelation entity. @author MyEclipse Persistence Tools
 */

public class TAuthorityRmrelation implements java.io.Serializable {

	// Fields

	private TAuthorityRmrelationId id;
	private Timestamp CCtime;
	private String CCip;
	private String CCreator;
	private String createBtn;
	private String updateBtn;
	private String updateBtn1;
	private String readBtn;
	private String deleteBtn;
	private String deleteBtn1;
	private String deleteBtn2;
	private String searchBtn;
	private String importBtn;
	private String importWizardbtn;
	private String exportBtn;
	private String exportWizardbtn;
	private String printBtn;
	private String printPreviewbtn;
	private String btn15;
	private String btn16;
	private String btn17;
	private String btn18;
	private String btn19;
	private String btn20;
	private String btn21;
	private String btn22;
	
	// Constructors

	/** default constructor */
	public TAuthorityRmrelation() {
	}

	/** minimal constructor */
	public TAuthorityRmrelation(TAuthorityRmrelationId id, Timestamp CCtime,
			String createBtn, String updateBtn, String updateBtn1,
			String readBtn, String deleteBtn, String deleteBtn1,
			String deleteBtn2, String searchBtn, String importBtn,
			String importWizardbtn, String exportBtn, String exportWizardbtn,
			String printBtn, String printPreviewbtn, String btn15,
			String btn16, String btn17, String btn18, String btn19, String btn20) {
		this.id = id;
		this.CCtime = CCtime;
		this.createBtn = createBtn;
		this.updateBtn = updateBtn;
		this.updateBtn1 = updateBtn1;
		this.readBtn = readBtn;
		this.deleteBtn = deleteBtn;
		this.deleteBtn1 = deleteBtn1;
		this.deleteBtn2 = deleteBtn2;
		this.searchBtn = searchBtn;
		this.importBtn = importBtn;
		this.importWizardbtn = importWizardbtn;
		this.exportBtn = exportBtn;
		this.exportWizardbtn = exportWizardbtn;
		this.printBtn = printBtn;
		this.printPreviewbtn = printPreviewbtn;
		this.btn15 = btn15;
		this.btn16 = btn16;
		this.btn17 = btn17;
		this.btn18 = btn18;
		this.btn19 = btn19;
		this.btn20 = btn20;
	}

	/** full constructor */
	public TAuthorityRmrelation(TAuthorityRmrelationId id, Timestamp CCtime,
			String CCip, String CCreator, String createBtn, String updateBtn,
			String updateBtn1, String readBtn, String deleteBtn,
			String deleteBtn1, String deleteBtn2, String searchBtn,
			String importBtn, String importWizardbtn, String exportBtn,
			String exportWizardbtn, String printBtn, String printPreviewbtn,
			String btn15, String btn16, String btn17, String btn18,
			String btn19, String btn20) {
		this.id = id;
		this.CCtime = CCtime;
		this.CCip = CCip;
		this.CCreator = CCreator;
		this.createBtn = createBtn;
		this.updateBtn = updateBtn;
		this.updateBtn1 = updateBtn1;
		this.readBtn = readBtn;
		this.deleteBtn = deleteBtn;
		this.deleteBtn1 = deleteBtn1;
		this.deleteBtn2 = deleteBtn2;
		this.searchBtn = searchBtn;
		this.importBtn = importBtn;
		this.importWizardbtn = importWizardbtn;
		this.exportBtn = exportBtn;
		this.exportWizardbtn = exportWizardbtn;
		this.printBtn = printBtn;
		this.printPreviewbtn = printPreviewbtn;
		this.btn15 = btn15;
		this.btn16 = btn16;
		this.btn17 = btn17;
		this.btn18 = btn18;
		this.btn19 = btn19;
		this.btn20 = btn20;
	}

	// Property accessors

	public TAuthorityRmrelationId getId() {
		return this.id;
	}

	public void setId(TAuthorityRmrelationId id) {
		this.id = id;
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

	public String getCreateBtn() {
		return this.createBtn;
	}

	public void setCreateBtn(String createBtn) {
		this.createBtn = createBtn;
	}

	public String getUpdateBtn() {
		return this.updateBtn;
	}

	public void setUpdateBtn(String updateBtn) {
		this.updateBtn = updateBtn;
	}

	public String getUpdateBtn1() {
		return this.updateBtn1;
	}

	public void setUpdateBtn1(String updateBtn1) {
		this.updateBtn1 = updateBtn1;
	}

	public String getReadBtn() {
		return this.readBtn;
	}

	public void setReadBtn(String readBtn) {
		this.readBtn = readBtn;
	}

	public String getDeleteBtn() {
		return this.deleteBtn;
	}

	public void setDeleteBtn(String deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public String getDeleteBtn1() {
		return this.deleteBtn1;
	}

	public void setDeleteBtn1(String deleteBtn1) {
		this.deleteBtn1 = deleteBtn1;
	}

	public String getDeleteBtn2() {
		return this.deleteBtn2;
	}

	public void setDeleteBtn2(String deleteBtn2) {
		this.deleteBtn2 = deleteBtn2;
	}

	public String getSearchBtn() {
		return this.searchBtn;
	}

	public void setSearchBtn(String searchBtn) {
		this.searchBtn = searchBtn;
	}

	public String getImportBtn() {
		return this.importBtn;
	}

	public void setImportBtn(String importBtn) {
		this.importBtn = importBtn;
	}

	public String getImportWizardbtn() {
		return this.importWizardbtn;
	}

	public void setImportWizardbtn(String importWizardbtn) {
		this.importWizardbtn = importWizardbtn;
	}

	public String getExportBtn() {
		return this.exportBtn;
	}

	public void setExportBtn(String exportBtn) {
		this.exportBtn = exportBtn;
	}

	public String getExportWizardbtn() {
		return this.exportWizardbtn;
	}

	public void setExportWizardbtn(String exportWizardbtn) {
		this.exportWizardbtn = exportWizardbtn;
	}

	public String getPrintBtn() {
		return this.printBtn;
	}

	public void setPrintBtn(String printBtn) {
		this.printBtn = printBtn;
	}

	public String getPrintPreviewbtn() {
		return this.printPreviewbtn;
	}

	public void setPrintPreviewbtn(String printPreviewbtn) {
		this.printPreviewbtn = printPreviewbtn;
	}

	public String getBtn15() {
		return this.btn15;
	}

	public void setBtn15(String btn15) {
		this.btn15 = btn15;
	}

	public String getBtn16() {
		return this.btn16;
	}

	public void setBtn16(String btn16) {
		this.btn16 = btn16;
	}

	public String getBtn17() {
		return this.btn17;
	}

	public void setBtn17(String btn17) {
		this.btn17 = btn17;
	}

	public String getBtn18() {
		return this.btn18;
	}

	public void setBtn18(String btn18) {
		this.btn18 = btn18;
	}

	public String getBtn19() {
		return this.btn19;
	}

	public void setBtn19(String btn19) {
		this.btn19 = btn19;
	}

	public String getBtn20() {
		return this.btn20;
	}

	public void setBtn20(String btn20) {
		this.btn20 = btn20;
	}

	public String getBtn21() {
		return btn21;
	}

	public void setBtn21(String btn21) {
		this.btn21 = btn21;
	}

	public String getBtn22() {
		return btn22;
	}

	public void setBtn22(String btn22) {
		this.btn22 = btn22;
	}

}