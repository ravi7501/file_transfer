package neft.file.management;

import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neft.file.management.dao.neft_repository;
import neft.file.management.entity.data_table;

@Service
public class service {
	
	@Autowired 
	neft_repository neft_rep;
	
	
	public List<data_table> getAlldata() {
		
		List <data_table> utr = new ArrayList<data_table>();
		neft_rep.findAll().forEach(data->utr.add(data));
			
	return utr;
	}
}
