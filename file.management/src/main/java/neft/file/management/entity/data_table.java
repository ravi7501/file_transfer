package neft.file.management.entity;
import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="nris_neft")
public class data_table  {
	
	
	@Id
	@Column (name = "UTR_NO")
	private String UTR_NO;
	

	
	@Column (name = "INIT_DATE")
	private String INIT_DATE;
	
	@Column (name = "AMOUNT")
	private String AMOUNT;
	
	@Column (name = "STATUS")
	private String STATUS;
	
	@Column(name ="FLOW")
	private String FLOW;
	
    

	@Column (name = "PREV_STATUSES")
    private String PREV_STATUSES;
    

	@Column (name = "LAST_MOD_DATE")
	private String LAST_MOD_DATE;
	
	
	@Column (name = "LAST_MOD_TIME")
	private String LAST_MOD_TIME;
	
	@Column (name = "IFSC_SENDER")
	private String IFSC_SENDER;
	
	@Column (name = "IFSC_RECVR")
	private String IFSC_RECVR;

	
	private data_table() {
		
	}


	public data_table(String uTR_NO, String iNIT_DATE, String aMOUNT, String sTATUS, String fLOW, String pREV_STATUSES,
			String lAST_MOD_DATE, String lAST_MOD_TIME, String iFSC_SENDER, String iFSC_RECVR) {
		super();
		UTR_NO = uTR_NO;
		INIT_DATE = iNIT_DATE;
		AMOUNT = aMOUNT;
		STATUS = sTATUS;
		FLOW = fLOW;
		PREV_STATUSES = pREV_STATUSES;
		LAST_MOD_DATE = lAST_MOD_DATE;
		LAST_MOD_TIME = lAST_MOD_TIME;
		IFSC_SENDER = iFSC_SENDER;
		IFSC_RECVR = iFSC_RECVR;
	}


	@Override
	public String toString() {
		return "neftIn [UTR_NO=" + UTR_NO + ", INIT_DATE=" + INIT_DATE + ", AMOUNT=" + AMOUNT + ", STATUS=" + STATUS
				+ ", FLOW=" + FLOW + ", PREV_STATUSES=" + PREV_STATUSES + ", LAST_MOD_DATE=" + LAST_MOD_DATE
				+ ", LAST_MOD_TIME=" + LAST_MOD_TIME + ", IFSC_SENDER=" + IFSC_SENDER + ", IFSC_RECVR=" + IFSC_RECVR
				+ "]";
	}


	public String getUTR_NO() {
		return UTR_NO;
	}

	public void setUTR_NO(String uTR_NO) {
		UTR_NO = uTR_NO;
	}
	public String getFLOW() {
		return FLOW;
	}
	public void setFLOW(String fLOW) {
		FLOW = fLOW;
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

	public String getLAST_MOD_DATE() {
		return LAST_MOD_DATE;
	}

	public void setLAST_MOD_DATE(String lAST_MOD_DATE) {
		LAST_MOD_DATE = lAST_MOD_DATE;
	}

	public String getLAST_MOD_TIME() {
		return LAST_MOD_TIME;
	}

	public void setLAST_MOD_TIME(String lAST_MOD_TIME) {
		LAST_MOD_TIME = lAST_MOD_TIME;
	}

	public String getIFSC_SENDER() {
		return IFSC_SENDER;
	}

	public void setIFSC_SENDER(String iFSC_SENDER) {
		IFSC_SENDER = iFSC_SENDER;
	}

	public String getIFSC_RECVR() {
		return IFSC_RECVR;
	}

	public void setIFSC_RECVR(String iFSC_RECVR) {
		IFSC_RECVR = iFSC_RECVR;
	}
	
	//@Column (name="REJECT_REASON",nullable=true) kept for  pending time
	//private String REJECT_REASON;
	
}