package neft.file.management;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neft.file.management.dao.*;
import neft.file.management.entity.*;

@Service
public class service {
	
	@Autowired 
	neft_repository neft_rep;
	
	@Autowired 
	rtgs_repository rtgs_rep;
	
	//=================neft_dat==============//
	
	// Will get all neft data
	public List<data_table> getAlldata() {
		
		List <data_table> utr = new ArrayList<data_table>();
		neft_rep.findAll().forEach(data->utr.add(data));
			
	return utr;
	}
	
	// Will get neft_outgoing_data
	public List<Map<String, Integer>> neft_out_ward(String ifsc){
		if (ifsc.equals("all")) {
			return neft_rep.getneftout();

		}
		else {
			return neft_rep.getbank_neft_out(ifsc);
		}
		
	}
	
	// Will get neft_InComing_data
	public List<Map<String, Integer>> neft_In_ward(){
		
		return neft_rep.getneftIn();
    }
	
	
	//========================rtgs_data=========================//
	
	
	
	// Will get all rtgs data
    public List<rtgsTable> getrtgsTable() {
		
		List <rtgsTable> utr = new ArrayList<rtgsTable>();
		rtgs_rep.findAll().forEach(data->utr.add(data));
			
	return utr;
	}
	
    
	
	// Will get rtgs_outgoing_data
	public List<Map<String, Integer>> rtgs_out_ward(){
		
		return rtgs_rep.getrtgsout();
	}
	// Will get rtgs_Incoming_data
	public List<Map<String, Integer>> rtgs_In_ward(){
			
			return rtgs_rep.getrtgsIn();
	}
}
