package neft.file.management.entity;
import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="nris_neft")
public class data_table  {
	
	
	  
	@Id
	@Column (name = "UTR_NO")
	private String UTR_NO;
	
	@Column (name = "MSG_TYPE")
	private String MSG_TYPE;
	
	@Column (name = "INIT_DATE")
	private String INIT_DATE;
	
	@Column (name = "AMOUNT")
	private String AMOUNT;
	
	@Column (name = "STATUS")
	private String STATUS;
	
    @Column (name = "PREV_STATUSES")
    private String PREV_STATUSES;
	
	@Column (name = "LAST_MOD_TIME")
	private String LAST_MOD_TIME;
	
	@Column (name="REJECT_REASON",nullable=true)
	private String REJECT_REASON;

	@Column(name = "REMIT_INFO", nullable = false)
	private String REMIT_INFO ;
	
	
	
	private data_table() {
		
	}
	


	public data_table(String uTR_NO, String mSG_TYPE, String iNIT_DATE, String aMOUNT, String sTATUS,
			String pREV_STATUSES, String lAST_MOD_TIME ,String rEJECT_REASON, String rEMIT_INFO) {
		super();
		UTR_NO = uTR_NO;
		MSG_TYPE = mSG_TYPE;
		INIT_DATE = iNIT_DATE;
		AMOUNT = aMOUNT;
		STATUS = sTATUS;
		PREV_STATUSES = pREV_STATUSES;
		LAST_MOD_TIME = lAST_MOD_TIME;
		REJECT_REASON=rEJECT_REASON;
		REMIT_INFO=rEMIT_INFO;
	}


   public String getSelect() {
	   return REMIT_INFO;
   }
   
   public void setSelect(String rEMIT_INFO) {
	    REMIT_INFO=rEMIT_INFO;
   }
   
   




	public String getPENDING_TIME() {
		return REJECT_REASON;
	}



	public void setPENDING_TIME(String rEJECT_REASON) {
		REJECT_REASON = rEJECT_REASON;
	}



	@Override
	public String toString() {
		return "data_table [UTR_NO=" + UTR_NO + ", MSG_TYPE=" + MSG_TYPE + ", INIT_DATE=" + INIT_DATE + ", AMOUNT="
				+ AMOUNT + ", STATUS=" + STATUS + ", PREV_STATUSES=" + PREV_STATUSES + ", LAST_MOD_TIME="
				+ LAST_MOD_TIME + ", PENDING_TIME= "+REJECT_REASON+"]";
	}



	public String getUTR_NO() {
		return UTR_NO;
	}






	public void setUTR_NO(String uTR_NO) {
		UTR_NO = uTR_NO;
	}






	public String getMSG_TYPE() {
		return MSG_TYPE;
	}






	public void setMSG_TYPE(String mSG_TYPE) {
		MSG_TYPE = mSG_TYPE;
	}






	public String getINIT_DATE() {
		return INIT_DATE;
	}






	public void setINIT_DATE(String iNIT_DATE) {
		INIT_DATE = iNIT_DATE;
	}






	public String getAMOUNT() {
		return AMOUNT;
	}






	public void setAMOUNT(String aMOUNT) {
		AMOUNT = aMOUNT;
	}






	public String getSTATUS() {
		return STATUS;
	}






	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}






	public String getPREV_STATUSES() {
		return PREV_STATUSES;
	}






	public void setPREV_STATUSES(String pREV_STATUSES) {
		PREV_STATUSES = pREV_STATUSES;
	}






	public String getLAST_MOD_TIME() {
		return LAST_MOD_TIME;
	}






	public void setLAST_MOD_TIME(String lAST_MOD_TIME) {
		LAST_MOD_TIME = lAST_MOD_TIME;
	}






	public String get_id() {
		return UTR_NO;
	}
		

}